package com.application.feed.services;

import com.application.feed.models.Feed;

import java.util.Set;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
public interface FeedService {

    Feed saveFeed(Feed feed);

    boolean feedExist(String nickName);


    Set<Feed> getFeeds();

    Feed findById(Long id);
}
