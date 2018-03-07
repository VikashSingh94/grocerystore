package com.hashmap.dao

import com.hashmap.dbms.{CatalogDb, CatalogDbImpl}
import com.hashmap.model.Item

class CatalogDaoImpl extends CatalogDao[Item] {

  override def dataBase:CatalogDb[Item] = CatalogDbImpl

  override def addItem(item:Item): Unit = dataBase.add(item)

  override def getItems(): List[Item] = dataBase.getAll()

}

