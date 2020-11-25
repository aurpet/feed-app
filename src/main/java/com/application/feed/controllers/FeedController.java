package com.application.feed.controllers;

import com.application.feed.models.Feed;
import com.application.feed.repositories.FeedRepository;
import com.application.feed.services.FeedService;
import com.application.feed.utils.FeedReader;
import javafx.scene.effect.SepiaTone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Controller
public class FeedController {

    private final FeedService feedService;
    private final FeedRepository feedRepository;

    public FeedController(FeedService feedService, FeedRepository feedRepository) {
        this.feedService = feedService;
        this.feedRepository = feedRepository;
    }

    @GetMapping("/")
    public String displayIndexPage(Model model) {
        model.addAttribute("feed", new Feed());
        return "feeds/index";
    }

    @PostMapping("/save")
    private String saveFeed(Feed feed) {
        if (feedService.feedExist(feed.getUrl())){
            return "redirect:/?exist";
        } else {
            feedRepository.save(FeedReader.readFeed(feed));

            //feedService.save(RssReader.readRss(feedDto));
            return "redirect:/?insert";
        }
    }

    @GetMapping("/all")
    private String displayAllFeeds(Model model){
        List<Feed> feeds = feedRepository.findAll();
        model.addAttribute("feeds", feeds);
        return "feeds/feeds";
    }
}
