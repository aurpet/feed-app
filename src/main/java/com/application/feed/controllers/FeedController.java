package com.application.feed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Controller
public class FeedController {

    @GetMapping("/")
    public String displayHomePage(){
        return "feeds/index";
    }
}
