package com.application.feed.utils;

import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
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
public class RssReader {
    public static String feedString;

    public static void readRss(String feedUrl) {
        try {
            URL url = new URL(feedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(url));

            List entries = feed.getEntries();
            Iterator itEntries = entries.iterator();

            System.out.println("Title " + feed.getTitle());
            System.out.println("URL " + feed.getLink());
            System.out.println("Date " +  feed.getPublishedDate());
            System.out.printf("============= \n");

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry)itEntries.next();
                System.out.println("Title: " + entry.getTitle());
                System.out.println("Link " + entry.getLink());
                System.out.println("Date " +  feed.getPublishedDate());

                SyndContent description = entry.getDescription();
                System.out.println("Descritpion: " + description.getValue());
                System.out.println();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SyndFeedOutput readFeed(String feedUrl) {
        SyndFeedInput input = new SyndFeedInput();
        try {
            URL feedSource = new URL(feedUrl);
            SyndFeed feed = input.build(new XmlReader(feedSource));
            SyndFeedOutput output = new SyndFeedOutput();

            //print xml feed
            //output.output(feed, new PrintWriter(System.out));

            //print xml string
            System.out.printf(feedString = output.outputString(feed));

            return output;
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
