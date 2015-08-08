package net.hetty.rssreader.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.hetty.rssreader.shared.model.Feed;

public interface FeedServiceAsync {
	
	void createNewFeed(AsyncCallback<Feed> callback);
	
	void saveFeed(Feed feed, AsyncCallback<Void> asyncCallback);
}