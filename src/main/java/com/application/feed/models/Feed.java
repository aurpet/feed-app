package com.application.feed.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "feeds")
public class Feed extends BaseEntity {
    private String url;
    private String title;
    private Date lastUpdate;
    private String feedName;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private Collection<Item> items = new HashSet<>();
}
