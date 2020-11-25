package com.application.feed.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aurimas
 * created on 2020-11-25
 */
class RssReaderTest {

    @Test
    void readRss() {
        RssReader.readRss("https://www.15min.lt/rss");
    }
}