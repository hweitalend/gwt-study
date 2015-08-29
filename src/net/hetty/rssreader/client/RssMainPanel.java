package net.hetty.rssreader.client;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

import net.hetty.rssreader.client.grid.ItemGrid;

public class RssMainPanel extends ContentPanel {
	public RssMainPanel() {
		setHeading("Main");
		setLayout(new FitLayout());
		add(new ItemGrid());
	}
}
