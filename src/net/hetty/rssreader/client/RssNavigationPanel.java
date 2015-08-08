package net.hetty.rssreader.client;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hetty.rssreader.client.components.LinkFeedPopup;
import net.hetty.rssreader.client.services.FeedServiceAsync;
import net.hetty.rssreader.client.windows.FeedWindow;
import net.hetty.rssreader.shared.model.Feed;

public class RssNavigationPanel extends ContentPanel {

	final ToggleButton btnLinkFeed = new ToggleButton("Link feed");

	final LinkFeedPopup linkFeedPopup = new LinkFeedPopup();

	final Button btnCreateFeed = new Button("Create feed");

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

		addCreateFeedButton();

		btnCreateFeed.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				createNewFeedWindow();
			}
		});
	}

	private void addCreateFeedButton() {
		btnCreateFeed.setIconStyle("create-feed");
		addButton(btnCreateFeed);
		addCreateFeedButtonToolTip();
	}

	private void addCreateFeedButtonToolTip() {
		ToolTipConfig createNewToolTipConfig = new ToolTipConfig();
		createNewToolTipConfig.setTitle("Create a new RSS feed");
		createNewToolTipConfig.setText("Creates a new RSS feed");
		btnCreateFeed.setToolTip(createNewToolTipConfig);
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

	private void createNewFeedWindow() {

		final FeedServiceAsync feedService = Registry.get(RSSReaderConstants.FEED_SERVICE);
		feedService.createNewFeed(new AsyncCallback<Feed>() {
			@Override
			public void onFailure(Throwable caught) {
				Info.display("RSSReader", "Unable to create a new feed");
			}

			@Override
			public void onSuccess(Feed feed) {
				final Window newFeedWindow = new FeedWindow(feed);
				newFeedWindow.show();
			}
		});
	}

}
