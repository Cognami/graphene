Ext.define("DARPA.AbstractGraphPanel", {
	extend: "Ext.panel.Panel",
	border: 1,
	title: "Graph",
	titleAlign: "center",
	layout: {
		type: "hbox",
		align: "stretch"
	},
	resizable: true,
	collapsible: false,
	width: "auto",
	
	graphType: "default",
	GraphVis: null,
	graphStore: null,
	institution: "",
	
	json: null,
	json1Hop: null,
	legendJSON: null,
	
	serviceURL: "",
	previousPivotIds: [],
	
	prevLoadParams: {
		searchValue: null,
		value: null,
		prevValue: null
	},
	
	listeners: {
		resize: function(tab, width, height, oldWidth, oldHeight) {
			if (typeof tab.GraphVis !== "undefined") {
				tab.GraphVis.resize(width, height);
			}
		}
	},
	
	constructor: function(config) {
		var self = this;
		
		this.institution = config.institution;
		
		//this.GraphVis = null; // TODO: implement in extending class
		Ext.define("DARPA.JsonStoreDataModel", {
			extend: "Ext.data.Model"
		});
		
		this.graphStore = Ext.create("Ext.data.JsonStore", {
			proxy: {
				type: 'ajax',
				model: "DARPA.JsonStoreDataModel",
				timeout: 120000,
				url: "",
				reader: {
					type: 'json'
				}
			}
		});
		
		config.tbar = Ext.create("DARPA.GraphToolbar", {
			id: config.id + "-GraphToolbar",
			institution: config.institution
		});
		
		config.tbar.setDefaultLayoutBtn(self.GraphVis.CONSTANTS("defaultLayout"));
		
		config.bbar = Ext.create("DARPA.ProgressBar", {
			text: "Ready",
			id: config.id + "-ProgressBar",
			height: 20,
			width: 200
		});
		
		this.callParent(arguments);
	}, 
	
	getToolbar: function() {
		return Ext.getCmp(this.id + "-GraphToolbar");
	},
	
	getNodeDisplay : function() {
		return undefined;
	},
	
	getSettings : function() {
		return undefined;
	},
	
	getProgressBar: function() {
		return Ext.getCmp(this.id + "-ProgressBar");
	},
	
	getPivotButton : function() {
		return this.getNodeDisplay().items.items[1].getPivotButton();
	},

	getUnPivotButton : function() {
		return this.getNodeDisplay().items.items[1].getUnPivotButton();
	},

	getHideButton : function() {
		return this.getNodeDisplay().items.items[1].getHideButton();
	},

	getUnHideButton : function() {
		return this.getNodeDisplay().items.items[1].getUnHideButton();
	},
	getExpandButton : function() {
		return this.getNodeDisplay().items.items[1].getExpandButton();
	},
	getUnExpandButton : function() {
		return this.getNodeDisplay().items.items[1].getUnExpandButton();
	},
	getShowButton : function() {
		return this.getNodeDisplay().items.items[1].getShowButton();
	},
	getStopButton : function() {
		return this.getNodeDisplay().items.items[1].getStopButton();
	},
	
	setStatus: function(msg) {
		this.GraphVis.utils.updateProgress(msg);
	},
	
	// FIXME: legacy
	appendTabTitle: function(text) {
		if (typeof text == "string" && text.length > 0) {
			if (this.originalTitle == undefined || this.originalTitle == null) {
				this.originalTitle = this.title;
			}

			var title = (this.originalTitle) ? this.originalTitle : this.title;
			this.setTitle(title + " " + text);
		}
	},
	
	load: function(custno) {
		// TODO: implement in extended class
	},
	
	loadOneHop: function(node) {
		// TODO: implement in extended class
	},
	
	showjson: function(searchValue, useSaved) {
		if (this.json != null && this.GraphVis.getGv() != null) {
			this.GraphVis.load(this.json, searchValue, useSaved);
		}
	},
	
	// why is this even here?
	applySettings: function() {
		this.load(this.prevLoadParams.value); 
	},
	
	importGraph: function() {
		var importWindow = Ext.create("DARPA.importDialog", {
			title: "Import Window",
			border: true
		});
		
		importWindow.setGraphVis(this.GraphVis);
		importWindow.show();
		importWindow.center();
	},
	
	exportGraph: function() {
		var self = this;
		var outJSON;
		try {
			outJSON = this.GraphVis.exportGraph();
		} catch (e) {
			console.error("ERROR GETTING GRAPH JSON");
			outJSON = undefined;
		}
		
		var outPNG;
		try {
			outPNG = self.GraphVis.utils.toPng({
				// bg: background-color
				// full: false = current viewport, true = entire graph
				scale: 2
			});
		} catch (e) {
			console.error("ERROR GETTING GRAPH PNG");
			outPNG = undefined;
		}
		
		var exportWindow = Ext.create("DARPA.exportDialog", {
			title: "Export Window",
			border: true
		});
		
		exportWindow.setGraphJSON(outJSON);
		exportWindow.setGraphPNG(outPNG);
		exportWindow.setFileName(self.graphType + "-" + self.prevLoadParams.searchValue);
		exportWindow.show();
		exportWindow.center();
	},
	
	saveGraph: function(userId) {
		var outJSON = this.GraphVis.exportGraph();
		var uid = (typeof userId == "undefined") ? "unknown" : userId; // FIXME: get userID somehow
		UDSIF.init();
		var UDSAction = {type: "sg", data: {graphJSON: outJSON}};
		UDSIF.addToUDSession(UDSAction);
		UDSIF.saveUDSession(uid, null);
	},
	
	restoreGraph: function(butId) {
		var uid = "unknown";  // FIXME: get userID somehow
		UDSIF.restoreUDSession(uid, this.GraphVis, butId);
	},
	
	nodeClick: function(node) {
		// TODO: implement in extended class
		var nodeDisp = this.getNodeDisplay();
		nodeDisp.showNodeAttrs(node);
		nodeDisp.enablePivot(true);
        nodeDisp.enableHide(true);
	},
	
	edgeClick: function(edge) {
		// TODO: implement in extended class
		var nodeDisp = this.getNodeDisplay();
		var d = edge.data();
		if (d && d.attrs) {
			nodeDisp.showEdgeAttrs(edge);
		}
	},
	
	edgeRightClick: function(edge) {
		// TODO: override in customization
	},

	setNodeVisibility: function(nodes, isVisible, isFilter) {
		for (var i = 0; i < nodes.length; i++) {
			this.GraphVis.setNodeVisibility(nodes[i], isVisible, isFilter);
		}
	},
	
	setEdgeVisibility: function(edges, isVisible, isFilter) {
		for (var i = 0; i < edges.length; i++) {
			this.GraphVis.setEdgeVisibility(edges[i], isVisible, isFilter);
		}
	},
	
	editElement: function(ele) {
		var self = this;

		if (ele == null || typeof ele == "undefined") {
			console.error("Element is not defined.  Can not edit it.");
			return;
		}

		//var x_pos = node.position().x;
		//var y_pos = node.position().y;

		var window = Ext.create("DARPA.ElementEditor", {
			eleRef: ele,
			onComplete: function() {
				var fields = window.getAttrs();
				var newAttrs = [];
				for (var i = 0; i < fields.length; i++) {
					newAttrs.push({
						key: fields[i].name, 
						val: fields[i].value
					});
				}
				ele.data().attrs = newAttrs;
				
				ele.data({
					"label": window.getName(true),
					"idType": window.getIdType(),
					"color": window.getColor(),
					"edited": true
				});
				// edges do not have a "name" field
				if (ele.isNode()) {
					ele.data({
						//"imgUrl": window.getImgUrl(),
						"name": window.getName(false)
					});
				}
			}
		});

		// window.showAt(x_pos, y_pos - window.height)?
		window.show();
	},
	
	givePromptToMerge: function(superNode, selectedNodes) {
		var scope = this;
		var window = Ext.create("DARPA.NodeMergeDialog", {
			confirmFn: function(reason) {
				// first, do the client-side merge of all the nodes and get subNodeIds
				var subNodeIds = scope.mergeNodes(superNode, selectedNodes); 
				
				superNode.data({
					"reason" : reason
				});
			},
			cancelFn: function() {
				// don't merge
			}
		});
		window.show();
	},
	
	mergeNodes: function(superNode, selectedNodes) {
		var doContinue = true;
		try {
			if (typeof superNode == "undefined") throw "Variable 'superNode' is undefined.";
			if (typeof superNode.isNode == "undefined" || typeof superNode.isNode() == false) throw "Right-clicked element is not a node.";
			if (typeof selectedNodes == "string" || selectedNodes.length < 1) throw "No other nodes were selected.";
		} catch (e) {
			doContinue = false;
			Ext.Msg.alert("Failed to Merge", "Unable merge nodes.  Reason: " + e);
		}

		var _this = this;
		var typesMatch = true;
		for (var i = 0; i < selectedNodes.length; i++) {
			if (superNode.data("idType") !== selectedNodes[i].data("idType")) {
				typesMatch = false;
				break;
			}
		}
		
		if (!typesMatch) {
			doContinue = false;
			Ext.Msg.alert("Failed to Merge", "You can only merge nodes of the same type.");
		}
		
		if (!doContinue) return;
		
		var subNodeIds = [];
		
		superNode.addClass("super-node");
		
		selectedNodes.each(function(i, n) {
			if (n.data("id") != superNode.data("id")) {
			
				subNodeIds.push(n.data("id"));
				
				n.connectedEdges().each(function(j, e) {
					var edge_clone = e.json();
					if (e.data("target") == n.data("id")) {
						// selectedNode n is target node
						if (edge_clone.data.old_targets == null || typeof edge_clone.data.old_targets == "undefined") {
							edge_clone.data.old_targets = [];
						}
						edge_clone.data.old_targets.push(n.data("id"));
						edge_clone.data.target = superNode.data("id");
					} else if (e.data("source") == n.data("id")) {
						// selectedNode n is source node
						if (edge_clone.data.old_sources == null || typeof edge_clone.data.old_sources == "undefined") {
							edge_clone.data.old_sources = [];
						}
						edge_clone.data.old_sources.push(n.data("id"));
						edge_clone.data.source = superNode.data("id");
					}
					_this.GraphVis.gv.remove(e);
					_this.GraphVis.gv.add(edge_clone);
				});
				
				if (superNode.data().subNodes == null || typeof superNode.data().subNodes == "undefined") {
					superNode.data().subNodes = [];
				}
				
				superNode.data().subNodes.push(n.json());
				_this.GraphVis.deleteNodes([n], true);
			}
		});
		
		return subNodeIds;
	},
	
	givePromptToUnmerge: function(superNodes) {
		var scope = this;
		
		if (superNodes == null || superNodes == undefined || superNodes.length == undefined) {
			return;
		}
		
		var noSuperNodes = true;
		for (var i = 0; i < superNodes.length; i++) {
			if (superNodes[i].hasClass("super-node")) {
				noSuperNodes = false;
				break;
			}
		}
		
		if (noSuperNodes) return;
		
		var window = Ext.create("DARPA.NodeMergeDialog", {
			confirmFn: function(reason) {
				// first, do the client-side merge of all the nodes
				for (var i = 0; i < superNodes.length; i++) {
					var n = superNodes[i];
					n.removeData("reason");
					if (n.hasClass("super-node")) scope.unmergeNode(n);
				}
			},
			cancelFn: function() {
				// don't merge
			}
		});
		window.show();
	},
	
	unmergeNode: function(superNode) {
		if (typeof superNode == "undefined" || typeof superNode.isNode == "undefined" ||
			superNode.isNode == false || typeof superNode.data().subNodes == "undefined") {
			// fail quietly
			console.log("variable superNode is not valid input");
			return;
		}
		
		var _this = this;

		superNode.removeClass("super-node");
		
		var subNodes = superNode.data("subNodes");
		while (subNodes.length > 0) {
			var subNodeJSON = subNodes.pop();
			_this.GraphVis.gv.add(subNodeJSON);
			_this.json.nodes.push(subNodeJSON);
			
			_this.GraphVis.gv.edges().each(function(i, e) {
				var edge_clone;
				
				if (e.data().old_sources!==null && typeof e.data().old_sources !== "undefined" && e.data().old_sources.length > 0) {
					var old_source = e.data().old_sources.pop();
					if (old_source == subNodeJSON.data.id) {
						edge_clone = e.json();
						edge_clone.data.source = subNodeJSON.data.id;
						_this.GraphVis.gv.remove(e);
						_this.GraphVis.gv.add(edge_clone);
						_this.json.edges.push(edge_clone);
					} else {
						// didn't match, so put it back
						e.data().old_sources.push(old_source);
					}
				}
				
				if (e.data().old_targets!==null && typeof e.data().old_targets !== "undefined" && e.data().old_targets.length > 0) {
					var old_target = e.data().old_targets.pop();
					if (old_target == subNodeJSON.data.id) {
						edge_clone = e.json();
						edge_clone.data.target = subNodeJSON.data.id;
						_this.GraphVis.gv.remove(e);
						_this.GraphVis.gv.add(edge_clone);
						_this.json.edges.push(edge_clone);
					} else {
						// didn't match, so put it back
						e.data().old_targets.push(old_target);
					}
				}
			});
		}
		// might not be necessary, since subNodes would be [] at this point
		delete superNode.data().subNodes;
	},
	
	pivot: function(node) {
		var self = this;
		var id = node.data("idVal");
		self.previousPivotIds.push(self.prevLoadParams.prevValue);
		self.load(id);
		
		if (typeof setTabTitle == "function") {
			setTabTitle("" + id);
		} else {
			console.log("the function setTabTitle() has not yet been implemented in the .html");
		}
	},
	
	unpivot: function() {
		var self = this;
		var prevId = self.previousPivotIds.pop();
		if (prevId != null && typeof prevId !== "undefined") {
			this.load(prevId);
			
			if (typeof setTabTitle == "function") {
				setTabTitle("" + prevId);
			} else {
				console.log("the function setTabTitle() has not yet been implemented in the .html");
			}
		}
	},
	
	expand: function(node) {
		this.loadOneHop(node);
	},
	
	unexpand: function(node) {
		this.GraphVis.unexpand(node);
	},
	
	applyFilter: function(searchItems, amount, fromDate, toDate) {
		this.GraphVis.getStateManager().applyFilter(searchItems);
	},

	clearFilter : function() {
		this.GraphVis.showAll(true);
		this.GraphVis.gv.fit(); // ugh...
	},

	clear : function() {
		this.GraphVis.clear();
	}
});