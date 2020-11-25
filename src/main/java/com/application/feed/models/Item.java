package com.application.feed.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    private String title;
    private String link;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Date published;

    @ManyToOne()
    @JoinColumn(name = "feed_id")
    private Feed feed;
}
