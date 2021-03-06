package graphene.web.services.javascript;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.func.F;
import org.apache.tapestry5.func.Mapper;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptAggregationStrategy;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;
import org.got5.tapestry5.jquery.utils.JQueryUtils;

public class GlobeStack implements JavaScriptStack {
	public static final String STACK_ID = "GlobeStack";

	private final List<Asset> javaScriptStack;

	private final List<StylesheetLink> cssStack;

	private final List<String> modules;

	public GlobeStack(final AssetSource assetSource) {
		final Mapper<String, Asset> pathToAsset = new Mapper<String, Asset>() {
			public Asset map(String path) {
				return assetSource.getExpandedAsset(path);
			}

		};
		// <script src="js/Detector.js"></script>
		// <script src="js/Tween.js"></script>
		// <script src="js/dat.gui.min.js"></script>
		// <script src="js/Three.js"></script>
		// <script src="js/THREEx.KeyboardState.js"></script>
		// <script src="js/THREEx.WindowResize.js"></script>
		// <script src="js/Stats.js"></script>
		// <script src="js/jquery-1.7.1.min.js"></script>
		// <script src="js/jquery-ui-1.8.21.custom.min.js"></script>
		// <script src="js/RequestAnimationFrame.js"></script>
		// <script src="js/ShaderExtras.js"></script>
		// <script src="js/canvg.js"></script>
		// <script src="js/rgbcolor.js"></script>
		// <script src="js/innersvg.js"></script>
		//
		// <script src="js/util.js"></script>
		// <script src="js/mousekeyboard.js"></script>
		// <script src="js/datguicontrol.js"></script>
		// <script src="js/dataloading.js"></script>
		// <script src="js/camerastates.js"></script>
		// <script src="js/geopins.js"></script>
		// <script src="js/visualize.js"></script>
		// <script src="js/visualize_lines.js"></script>
		// <script src="js/markers.js"></script>
		// <script src="js/svgtoy.js" type="text/javascript"></script>
		// <script src="js/d3.v2.min.js"></script>
		// <script src="js/ui.controls.js"></script>
		javaScriptStack = F
				.flow("context:globe/js/Detector.js",
						"context:globe/js/Tween.js",
						"context:globe/js/dat.gui.min.js",
						"context:core/js/three.r68/three.min.js",
						"context:globe/js/THREEx.KeyboardState.js",
						"context:globe/js/THREEx.WindowResize.js",
						"context:globe/js/Stats.js",
						"context:globe/js/jquery-1.7.1.min.js",
						"context:globe/js/jquery-ui-1.8.21.custom.min.js",
						"context:globe/js/RequestAnimationFrame.js",
						"context:globe/js/ShaderExtras.js",
						"context:globe/js/canvg.js",
						"context:globe/js/rgbcolor.js",
						"context:globe/js/innersvg.js",
						"context:globe/js/util.js",
						"context:globe/js/mousekeyboard.js",
						"context:globe/js/datguicontrol.js",
						"context:globe/js/dataloading.js",
						"context:globe/js/camerastates.js",
						"context:globe/js/geopins.js",
						"context:globe/js/visualize.js",
						"context:globe/js/visualize_lines.js",
						"context:globe/js/markers.js",
						"context:globe/js/svgtoy.js",
						"context:globe/js/d3.v2.min.js",
						"context:globe/js/ui.controls.js"

				).map(pathToAsset).toList();

		final Mapper<String, StylesheetLink> pathToStylesheetLink = F.combine(
				pathToAsset, JQueryUtils.assetToStylesheetLink);
		cssStack = F.flow("context:globe/style.css").map(pathToStylesheetLink)
				.toList();
		
		modules = new ArrayList<String>();

		/**
		 * Project modules
		 */
		modules.add("GlobeStack");
	}

	public String getInitialization() {
		return "";
	}

	public List<Asset> getJavaScriptLibraries() {
		return javaScriptStack;
	}

	public List<StylesheetLink> getStylesheets() {
		return cssStack;
	}

	public List<String> getStacks() {
		return Collections.emptyList();
	}

	 @Override
	   public JavaScriptAggregationStrategy getJavaScriptAggregationStrategy() {
	      return JavaScriptAggregationStrategy.COMBINE_AND_MINIMIZE;
	   }

	@Override
	public List<String> getModules() {
		return modules;
	}

}
