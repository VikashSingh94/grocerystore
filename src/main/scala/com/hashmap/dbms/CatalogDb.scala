package com.hashmap.dbms

trait CatalogDb[T] {
  def add(item:T):T
  def getAll():List[T]
}
