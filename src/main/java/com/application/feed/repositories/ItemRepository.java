package com.application.feed.repositories;

import com.application.feed.models.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Aurimas
 * created on 2020-11-24
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
