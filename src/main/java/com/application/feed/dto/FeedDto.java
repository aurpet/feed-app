package com.application.feed.dto;

import com.application.feed.models.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedDto {
    private Long id;
    private String url;
    private String title;
    private Date lastUpdate;
    private String feedName;
    private Collection<Item> items = new HashSet<>();
}
