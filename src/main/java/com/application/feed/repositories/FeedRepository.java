package com.application.feed.repositories;

import com.application.feed.models.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Aurimas
 * created on 2020-11-24
 */
@Repository
public interface FeedRepository extends CrudRepository<Feed, Long> {

    List<Feed> findAll();

    Feed findFeedById(long id);

    @Query("SELECT f FROM Feed f WHERE f.url = :url")
    Feed findByFeedUrl(@Param("url") String userId);
}
