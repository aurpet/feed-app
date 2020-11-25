package com.application.feed.dto;

import lombok.Builder;
import lombok.Data;


import java.util.Date;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Data
@Builder
public class ItemDto {
    private String title;
    private String link;
    private String description;
    private Date published;
}
