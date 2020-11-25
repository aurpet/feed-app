package com.application.feed.services;

import com.application.feed.models.Feed;
import com.application.feed.repositories.FeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Slf4j
@Service
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;

    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public Feed saveFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    @Override
    public boolean feedExist(String feedName) {
        Feed feed = feedRepository.findByFeedName(feedName);
        if (feed==null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Set<Feed> getFeeds() {
        Set<Feed> feedSet = new HashSet<>();
        feedRepository.findAll().iterator().forEachRemaining(feedSet::add);
        return feedSet;
    }

    @Override
    public Feed findById(Long id) {
        Optional<Feed> feedOptional = feedRepository.findById(id);
        if (!feedOptional.isPresent()) {
            log.error("Feed not found!");
        }
        return feedOptional.get();
    }
}
