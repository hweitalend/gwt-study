package net.hetty.rssreader.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import net.hetty.rssreader.shared.model.Feed;

@RemoteServiceRelativePath("feed-service")
public interface FeedService extends RemoteService {
	
	Feed createNewFeed();

	void saveFeed(Feed feed);
}
