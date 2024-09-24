package com.olzhas.justforfun.dao;

import com.olzhas.justforfun.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {
}
