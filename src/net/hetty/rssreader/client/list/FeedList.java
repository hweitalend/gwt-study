package net.hetty.rssreader.client.list;

import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.ListField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hetty.rssreader.client.RSSReaderConstants;
import net.hetty.rssreader.client.services.FeedServiceAsync;
import net.hetty.rssreader.shared.model.Feed;

public class FeedList extends LayoutContainer {

	public FeedList() {
		setLayout(new FitLayout());
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		final ListField<BeanModel> feedList = new ListField<BeanModel>();
		final FeedServiceAsync feedService = (FeedServiceAsync) Registry.get(RSSReaderConstants.FEED_SERVICE);
		final ListStore<BeanModel> feedStore = retrieveFeedStoreFromPrc(feedService);
		feedList.setStore(feedStore);
		feedList.setDisplayField("title");
		add(feedList);
	}

	private ListStore<BeanModel> retrieveFeedStoreFromPrc(final FeedServiceAsync feedService) {
		RpcProxy<List<Feed>> proxy = new RpcProxy<List<Feed>>() {
			@Override
			protected void load(Object loadConfig, AsyncCallback<List<Feed>> callback) {
				feedService.loadFeedList(callback);
			}
		};

		BeanModelReader reader = new BeanModelReader();
		ListLoader<ListLoadResult<BeanModel>> loader = new BaseListLoader<ListLoadResult<BeanModel>>(proxy, reader);

		ListStore<BeanModel> feedStore = new ListStore<BeanModel>(loader);
		loader.load();

		return feedStore;
	}
}
