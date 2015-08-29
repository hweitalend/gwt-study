package net.hetty.rssreader.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import net.hetty.rssreader.shared.model.Feed;
import net.hetty.rssreader.shared.model.Item;

@RemoteServiceRelativePath("feed-service")
public interface FeedService extends RemoteService {

	Feed createNewFeed();

	void saveFeed(Feed feed);

	void addExistingFeed(String feedUrl);

	List<Feed> loadFeedList();

	List<Item> loadItems(String feedUrl);
}
