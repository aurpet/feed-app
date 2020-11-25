package com.application.feed.services;

import com.application.feed.dto.FeedDto;
import com.application.feed.models.Feed;
import com.application.feed.repositories.FeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Aurimas
 * created on 2020-11-25
 */
@Slf4j
@Service
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;

    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public Feed save(FeedDto feedDto) {
        Feed feed = Feed.builder()
                .url(feedDto.getUrl())
                .title(feedDto.getTitle())
                .lastUpdate(feedDto.getLastUpdate())
                .feedName(feedDto.getFeedName())
                .items(feedDto.getItems())
                .build();

        return feedRepository.save(feed);
    }

    @Override
    public boolean feedExist(String feedName) {
        Feed feed = feedRepository.findByFeedName(feedName);
        if(feed==null){
            return false;
        } else {
            return true;
        }
    }
}
