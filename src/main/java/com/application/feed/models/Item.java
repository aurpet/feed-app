package com.application.feed.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    private String title;
    private String link;
    private String description;

    @CreatedDate
    private Date published = new Date();

    @OneToOne()
    private Feed feed;
}
