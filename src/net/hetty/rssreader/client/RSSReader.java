package net.hetty.rssreader.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RSSReader implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		Viewport viewport = new Viewport();

		final BorderLayout borderLayout = new BorderLayout();
		viewport.setLayout(borderLayout);
		RootPanel.get().add(viewport);

		addHeader(viewport);
		
		addContent(viewport);
		
		addNavigator(viewport);
		
		viewport.layout();
		
	}

	private void addNavigator(Viewport viewport) {
		BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 200, 150, 300);
		westData.setCollapsible(true);
		westData.setSplit(true);
		
		ContentPanel navPanel = new ContentPanel();
		viewport.add(navPanel, westData);
	}

	private void addContent(Viewport viewport) {
		BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
		centerData.setCollapsible(false);
		ContentPanel mainPanel = new ContentPanel();
		viewport.add(mainPanel, centerData);
	}

	private void addHeader(Viewport viewport) {
		BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 20);
		northData.setCollapsible(false);
		northData.setSplit(false);

		HTML headerHtml = new HTML();
		headerHtml.setHTML("<h1>RSS Reader</h1>");
		viewport.add(headerHtml, northData);
	}
}
