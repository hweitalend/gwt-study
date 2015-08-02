package net.hetty.rssreader.client;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;

import net.hetty.rssreader.client.components.LinkFeedPopup;

public class RssNavigationPanel extends ContentPanel {

	final ToggleButton btnLinkFeed = new ToggleButton("Link feed");

	final LinkFeedPopup linkFeedPopup = new LinkFeedPopup();

	public RssNavigationPanel() {
		setHeading("Navigation");
		addLinkFeedButton();

		btnLinkFeed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if (btnLinkFeed.isPressed()) {
					linkFeedPopup.show(btnLinkFeed.getElement(), "bl-tl?");
				} else {
					linkFeedPopup.hide();
				}
			}
		});
	}

	private void addLinkFeedButton() {
		btnLinkFeed.setIconStyle("link-feed");
		setButtonAlign(HorizontalAlignment.LEFT);
		addButton(btnLinkFeed);

		addLinkFeedButtonToolTip();
	}

	private void addLinkFeedButtonToolTip() {
		ToolTipConfig linkFeedToolTipConfig = new ToolTipConfig();
		linkFeedToolTipConfig.setTitle("Link to existing RSS feed");
		linkFeedToolTipConfig.setText("Allows you to enter the URL of an existing RSS feed you would like to link to");
		btnLinkFeed.setToolTip(linkFeedToolTipConfig);
	}

}
