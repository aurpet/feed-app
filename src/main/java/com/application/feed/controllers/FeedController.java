package com.application.feed.controllers;

import com.application.feed.dto.FeedDto;
import com.application.feed.services.FeedService;
import com.application.feed.utils.RssReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Controller
public class FeedController {

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/")
    public String displayIndexPage(Model model) {
        model.addAttribute("feed", new FeedDto());
        return "feeds/index";
    }

    @PostMapping("/save")
    private String saveFeed(FeedDto feed) {
        if (feedService.feedExist(feed.getFeedName())){
            return "redirect:/?exist";
        } else {
            feedService.save(RssReader.readRss(feed.getUrl(), feed.getFeedName()));
            return "redirect:/?insert";
        }

    }
}
