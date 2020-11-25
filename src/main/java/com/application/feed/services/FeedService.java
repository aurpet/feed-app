package com.application.feed.services;

import com.application.feed.dto.FeedDto;
import com.application.feed.models.Feed;

/**
 * @author Aurimas
 * created on 2020-11-25
 */
public interface FeedService {
    Feed save (FeedDto feedDto);
    boolean feedExist(String feedName);
}
