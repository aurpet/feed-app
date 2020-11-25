package com.application.feed.repositories;

import com.application.feed.models.Feed;
import com.application.feed.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Repository
public interface FeedRepository extends CrudRepository<Feed, Long> {

    Feed findByFeedName(String feedName);
}
