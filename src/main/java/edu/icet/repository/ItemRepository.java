package edu.icet.repository;

import edu.icet.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {
   // List<ItemEntity> findByName(String itemName);
}
