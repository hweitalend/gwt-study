package net.hetty.rssreader.client.windows;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;

import net.hetty.rssreader.client.forms.FeedForm;
import net.hetty.rssreader.shared.model.Feed;

public class FeedWindow extends Window {

	private final FeedForm feedForm = new FeedForm();

	public FeedWindow(final Feed feed) {
		setHeading("Feed");
		setWidth(350);
		setHeight(200);
		setResizable(false);
		setLayout(new FitLayout());

		addSaveButton(feed);
	}

	private void addSaveButton(final Feed feed) {
		final Button btnSave = new Button("Save");
		btnSave.setIconStyle("save");
		btnSave.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				btnSave.setEnabled(false);
				if (feedForm.isValid()) {
					hide(btnSave);
					feedForm.save(feed);
				} else {
					btnSave.setEnabled(true);
				}
			}
		});
		addButton(btnSave);
	}

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		add(feedForm);
	}

}
