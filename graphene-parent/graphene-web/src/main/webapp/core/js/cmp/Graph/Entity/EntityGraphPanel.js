Ext.define("DARPA.EntityGraphPanel", {
	extend: "DARPA.AbstractGraphPanel",
	
	constructor: function(config) {
		var self = this;
		
		this.GraphVis = new CytoscapeGraphVis(config.id + "-ENTcygraph");
		
		var graphSettings = Ext.create("DARPA.GraphSettings", {
			id: config.id + "-Settings"
		});
		
		graphSettings.setGraph(self);
		
		var filterSettings = Ext.create("DARPA.FilterSettings", {
			id: config.id + "-Filter",
			graphRef: self
		});
		
		var graphContainer = Ext.create("Ext.Container", {
			width: 'auto',
			height: 'auto',
			id: config.id + "-ENTcygraph",
			flex: 1
		});
		
		var settingsPanel = Ext.create("Ext.tab.Panel", {
			width: 320,
			height: 'auto',
			collapsible: true,
			collapseDirection: 'right',
			listeners: {
				collapse: function(e) {
					self.GraphVis.resize();
				},
				expand: function(e) {
					self.GraphVis.resize();
				}
			},
			items: [
				Ext.create("Ext.panel.Panel", {
					title: "DETAILS/ACTIONS",
					layout: 'fit',
					items: [
						Ext.create("DARPA.EntityNodeDisplay", {
							id: config.id + "-NodeDisplay",
							height: "auto"
						})
					]
				}),
				Ext.create("Ext.panel.Panel", {
					title: "SETTINGS/FILTER",
					items: [
						graphSettings,
						Ext.create("Ext.panel.Panel", {
							title: "FILTER",
							collapsible: false,
							items: filterSettings
						})
					] // END settings/filter items
				}),
				/* Hide until it is complete *//*
				Ext.create("DARPA.AdvancedQueryPanel", {
					title: "ADV. QUERY",
					id: config.id + "-AdvQuery",
					graphRef: self.GraphVis
				})
				*/
			] // END settings panel items
		});
		
		this.items = [graphContainer, settingsPanel];
		this.callParent(arguments);
	},

	getNodeDisplay : function() {
		var tabPanel = this.items.items[1];
		var tabScreen = tabPanel.items.items[0];
		return tabScreen.items.items[0];
	},
	
	getSettings : function() {
		var tabPanel = this.items.items[1];
		var settingsPanel = tabPanel.items.items[1];
		return settingsPanel.items.items[0];
	},
	
	afterLayout: function() {
		var self = this;
		if (self.GraphVis.getGv() == null) {
			var config = {/* configs go here */};
			self.GraphVis.init(config, self, function() {
				//self.showjson(self.prevLoadParams.value);
			}, true);
		}
		this.callParent(arguments); // ?
	},
	
	load: function(custno, useSaved) {
		var self = this;

		// TODO write catch to make sure variable useSaved is a boolean
		// useSaved = useSaved === true;
		
		var graphStore = self.graphStore;
		var hops = self.getSettings().getMaxHops();
		var degree = parseInt(hops);// + 1; //djue
		var s = self.getSettings();
		
		self.json = null;
		self.prevLoadParams.searchValue = self.prevLoadParams.value = self.prevLoadParams.prevValue = custno;
		
		self.getProgressBar().wait({
        	interval: 1000,
        	duration: 90000,
        	increment: 10,
        	text: "Searching..."
        });

		graphStore.proxy.extraParams.degree = degree;
		graphStore.proxy.extraParams.useSaved = useSaved;
		graphStore.proxy.extraParams.maxEdgesPerNode = s.getMaxEdgesPerNode();
		graphStore.proxy.extraParams.maxNodes = s.getMaxNodes();
		
		graphStore.proxy.url = Config.entityGraphCSUrl + 'customer/' + custno;
		
		graphStore.load({
			scope: this, // ?
			callback: function(records, operation, success) {

				self.getProgressBar().reset();

				if (success == false || records == null || records.length == 0) {
					if (success == false) self.setStatus("SERVER ERROR REQUESTING GRAPH", 0);
					else if (records == null) self.setStatus("SERVER RETURNED NULL GRAPH", 0);
					else if (records.length == 0) self.setStatus("SERVER RETURNED EMPTY GRAPH", 0);
					self.clear();
					return;
				}

				var retJSON = records[0].raw;
				
				self.json = retJSON;
				self.GraphVis.setUserName(retJSON.userName);
				self.setStatus(retJSON.strStatus, 1);
				
				self.legendJSON = retJSON.legend;
				if (typeof self.legendJSON == "string") {
					self.legendJSON = Ext.decode(self.legendJSON);
				} // else assume JSON
				
				var loadGraph = function(scope, useSaved) {
					if (scope.GraphVis.getGv() != null) {
						//scope.clear();
						scope.showjson(scope.prevLoadParams.value, useSaved);
						scope.getNodeDisplay().updateLegend(scope.legendJSON, "EntityGraph");
					}
				};
				
				if (typeof self.json == "undefined" || self.json.nodes.length <= 0) {
					//TODO error notice
					console.log("Problem with Entity graph - No nodes to load");
					return;
				}
				
				var THRESHOLD = 300;
				var useSaved = false;
				
				if (self.json.nodes.length < THRESHOLD) {
					useSaved = self.json.nodes[0].position != null;
					loadGraph(self, useSaved);
				} else {
					useSaved = self.json.nodes[0].position != null;
					Ext.Msg.confirm(
						"Loading a Large Graph",
						"The expected graph contains over " + THRESHOLD + " nodes.  This may take a moment to render.  Do you wish to wait?\n" +
						"If not, the graph will not render.",
						function(ans) {
							if (ans == 'yes') {
								loadGraph(self, useSaved);
							}
						}
					);
				}
			}
		});
	},
	
	loadOneHop: function(node, intype) {
		var self = this;
		var graphStore = self.graphStore;
		var s = self.getSettings();
		var maxNewCallsAlertThresh = 30; // Adjust as needed
		
		graphStore.proxy.extraParams.degree = 1; // labeled hops. only 1 hop out from this node
		graphStore.proxy.extraParams.maxEdgesPerNode = s.getMaxEdgesPerNode();
		graphStore.proxy.extraParams.maxNodes = s.getMaxNodes();
		graphStore.proxy.extraParams.minWeight = s.getMinWeight();
		
		if (maxNewCallsAlertThresh > graphStore.proxy.extraParams.maxEdgesPerNode) {
			maxNewCallsAlertThresh = graphStore.proxy.extraParams.maxEdgesPerNode;
		}
		
		if (intype == null || intype.length == 0) {
			intype = "customer";
		}
		
		graphStore.proxy.extraParams.Type = intype;

		// FIXME: REST services don't seem to like properly encoded symbols. Re-address when time permits
		// In the meantime, use regex to replace all / characters with a space
		/* graphStore.proxy.url = Config.entityGraphUrl + intype + "/" + encodeURIComponent(node.data("name")); */
		graphStore.proxy.url = Config.entityGraphUrl + intype + "/" + node.data("name").replace(/\//g, " ");

		self.json1Hop = null; // prevents us from trying to display the previous graph if we switch to this tab before we have fully loaded the new graph
		self.json1HopNode = node;

		self.getProgressBar().wait({
        	interval: 1000,
        	duration: 90000,
        	increment: 10,
        	text: "Expanding..."
        });
		
		graphStore.load({
			scope : this, // ?
			callback : function(records, operation, success) {

				self.getProgressBar().reset();
				
				if (success == false || records == null || records.length == 0) {
					if (success == false) self.setStatus("SERVER ERROR REQUESTING GRAPH", 0);
					else if (records == null) self.setStatus("SERVER RETURNED NULL GRAPH", 0);
					else if (records.length == 0) self.setStatus("SERVER RETURNED EMPTY GRAPH", 0);
					self.clear();
					return;
				}

				var retJSON = records[0].raw;
				
				self.json = retJSON;
				self.setStatus(retJSON.strStatus, 1);

				self.legendJSON = retJSON.legend;
				if (typeof self.legendJSON == "string") {
					self.legendJSON = Ext.decode(self.legendJSON);
				} // else assume JSON
				
				// should be self.json.nodes.length
				if (self.json.length > maxNewCallsAlertThresh) {
					Ext.Msg.confirm(
						'Confirm',
						'This value has more than ' + maxNewCallsAlertThresh + ' items and may clutter the display. Do you want to continue displaying it?',
						function(ans) {
							if (ans == 'yes') {
								self.GraphVis.expand(self.json, node);
								self.getNodeDisplay().updateLegend(self.legendJSON, "EntityGraph");
							}
						}
					);
				} else {
					self.GraphVis.expand(self.json, node);
					self.getNodeDisplay().updateLegend(self.legendJSON, "EntityGraph");
				}
			}
		});
	},
	
	nodeClick: function(node) {
		var self = this;
		self.currentNode = node;
		var nodeDisp = self.getNodeDisplay();
		nodeDisp.showNodeAttrs(node);
		var type = node.data().idType;
		var isEntity = false;
		if (typeof isPivotableType == "function") {
			// isPivotableType is a global function found in .html
			isEntity = isPivotableType(type);
		} else {
			isEntity = (type == 'customer' || type == 'LENDER' || type == 'BORROWER');
		}
		
		var len = this.GraphVis.getSelectedNodes().length;
		var msg = "" + len + " selected node" + ((len > 1) ? "s" : "");
		this.setStatus(msg, 1);
		
		nodeDisp.enablePivot(isEntity && len == 1);
		nodeDisp.enableShow(type == 'account' || isEntity);
		nodeDisp.enableHide(true);
	},
	
	edgeClick: function(edge) {
		var nodeDisp = this.getNodeDisplay();
		var d = edge.data();
		if (d && d.attrs) {
			nodeDisp.showEdgeAttrs(edge);
		}
	},
	
	edgeRightClick: function(edge) {
		// do nothing
	}
});