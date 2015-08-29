package net.hetty.rssreader.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hetty.rssreader.shared.model.Feed;
import net.hetty.rssreader.shared.model.Item;

public interface FeedServiceAsync {

	void createNewFeed(AsyncCallback<Feed> callback);

	void saveFeed(Feed feed, AsyncCallback<Void> asyncCallback);

	void addExistingFeed(String feedUrl, AsyncCallback<Void> callback);

	void loadFeedList(AsyncCallback<List<Feed>> callback);

	void loadItems(String feedUrl, AsyncCallback<List<Item>> callback);
}