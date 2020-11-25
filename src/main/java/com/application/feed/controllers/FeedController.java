package com.application.feed.controllers;

import com.application.feed.models.Feed;
import com.application.feed.models.Item;
import com.application.feed.repositories.FeedRepository;
import com.application.feed.repositories.ItemRepository;
import com.application.feed.services.FeedService;
import com.application.feed.utils.FeedReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Controller
public class FeedController {

    private final FeedService feedService;
    private final FeedRepository feedRepository;
    private final ItemRepository itemRepository;

    public FeedController(FeedService feedService, FeedRepository feedRepository, ItemRepository itemRepository) {
        this.feedService = feedService;
        this.feedRepository = feedRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String displayIndexPage(Model model) {
        model.addAttribute("feed", new Feed());
        return "feeds/index";
    }

    @PostMapping("/save")
    private String saveFeed(Feed feed) {
        if (feedService.feedExist(feed.getUrl())) {
            return "redirect:/?exist";
        } else {
            feedRepository.save(FeedReader.readFeed(feed));
            return "redirect:/?insert";
        }
    }

    @GetMapping("/all")
    private String displayAllFeeds(Model model) {
        Set<Feed> feeds = new HashSet<>();
        feedRepository.findAll().iterator().forEachRemaining(feeds::add);
        if (feeds.isEmpty()) {
            return "redirect:/?blank";
        } else {
            model.addAttribute("feeds", feeds);
            return "feeds/feeds";
        }
    }

    @GetMapping("/preview")
    public String displayFeedById(@RequestParam("id") long feedId, Model model) {
        Feed feed = feedRepository.findFeedById(feedId);
        Collection<Item> items = feed.getItems();
        model.addAttribute("items", items);
        return "feeds/feed-details";
    }
}
