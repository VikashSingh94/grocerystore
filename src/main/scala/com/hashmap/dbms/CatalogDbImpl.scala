package com.hashmap.dbms

import java.util.UUID

import com.hashmap.model.Item

case object CatalogDbImpl extends CatalogDb[Item] {


  var catalog =  scala.collection.mutable.Map[UUID, Item]()

  override def add(item: Item): Item = {
    catalog += (item.id -> item)
    item
  }

  override def getAll(): List[Item] = {
    catalog.values.toList
  }

  override def update(item:Item): Unit = {
    catalog -= item.id
    catalog += (item.id -> item)
  }


}
