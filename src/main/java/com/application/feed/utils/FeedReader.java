package com.application.feed.utils;

import com.application.feed.models.Feed;
import com.application.feed.models.Item;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * @author Aurimas
 * created on 2020-11-25
 */

public class FeedReader {

    public static Feed readFeed(Feed feed) {
        try {
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input.build(new XmlReader(new URL(feed.getUrl())));

            List entries = syndFeed.getEntries();
            Iterator itEntries = entries.iterator();

            feed.setTitle(syndFeed.getTitle());
            feed.setLastUpdate(syndFeed.getPublishedDate());

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry)itEntries.next();
                SyndContent description = entry.getDescription();

                Item item = Item.builder()
                        .title(entry.getTitle())
                        .description(description.getValue())
                        .link(entry.getLink())
                        .published(syndFeed.getPublishedDate())
                        .feed(feed)
                        .build();

                feed.getItems().add(item);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feed;
    }
}
