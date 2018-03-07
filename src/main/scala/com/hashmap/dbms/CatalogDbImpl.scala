package com.hashmap.dbms

import com.hashmap.model.Item

case object CatalogDbImpl extends CatalogDb[Item] {

   var catalog =  List[Item]()

  override def add(item: Item): Item = {
    catalog = item::catalog
    item
  }

  override def getAll(): List[Item] = {
    catalog
  }

}
