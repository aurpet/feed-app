package com.application.feed.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Data
@ToString
public class FeedDto {
    private String url;
    private String title;
    private Date lastUpdate;
    private String feedName;
    private Collection<ItemDto> items = new HashSet<>();
}
