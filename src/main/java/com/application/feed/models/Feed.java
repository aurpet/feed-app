package com.application.feed.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "feeds")
public class Feed extends BaseEntity {
    private String url;
    private String title;
    private Date lastUpdate;
    private String feedName;

    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
}
