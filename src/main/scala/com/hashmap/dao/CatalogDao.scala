package com.hashmap.dao

import com.hashmap.dbms.CatalogDb

trait  CatalogDao[T] {
  def dataBase:CatalogDb[T]
  def addItem(item: T):Unit
  def getItems():List[T]
}
