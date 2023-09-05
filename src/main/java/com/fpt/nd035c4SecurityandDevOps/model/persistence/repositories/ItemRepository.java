package com.fpt.nd035c4SecurityandDevOps.model.persistence.repositories;

import java.util.List;
import com.fpt.nd035c4SecurityandDevOps.model.persistence.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);

}