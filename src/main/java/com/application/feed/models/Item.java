package com.application.feed.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    private String title;
    private String link;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Date published;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;
}
