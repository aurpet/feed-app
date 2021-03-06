package com.application.feed.utils;

import com.application.feed.dto.FeedDto;
import com.application.feed.models.Feed;
import com.application.feed.models.Item;
import com.application.feed.repositories.FeedRepository;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * @author Aurimas
 * created on 2020-11-25
 */

public class RssReader {

    public static FeedDto readRss(FeedDto feedDto) {
        try {
            URL url = new URL(feedDto.getUrl());
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(url));

            List entries = feed.getEntries();
            Iterator itEntries = entries.iterator();

            feedDto.setTitle(feed.getTitle());
            feedDto.setLastUpdate(feed.getPublishedDate());

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry)itEntries.next();
                SyndContent description = entry.getDescription();

                Item item = Item.builder()
                        .title(entry.getTitle())
                        .description(description.getValue())
                        .link(entry.getLink())
                        .published(feed.getPublishedDate())
                        //todo add feed
                        //.feed(feedDto)

                        .build();

                feedDto.getItems().add(item);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedDto;
    }
}
