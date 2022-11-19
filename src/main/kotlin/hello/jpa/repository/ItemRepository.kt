package hello.jpa.repository

import hello.jpa.domain.item.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<Item, Long>