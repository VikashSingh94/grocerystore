package com.hashmap.service

import com.hashmap.dao.{CatalogDao, CatalogDaoImpl}
import com.hashmap.model.Item

class CatalogService(xmlFilePath:String ,catalogDao : CatalogDao[Item] ,xmlService: XmlService) {

  def getCatalog(): List[Item] = {
    catalogDao.getItems()
  }

  def buildCatalog(): Unit ={
    val catalogElements = getCatalogElements()
    saveElementsToCatalog(catalogElements)
  }

  private def saveElementsToCatalog(xmlElements: List[Item]): Unit = {
    xmlElements.foreach(element => catalogDao.addItem(element))
  }

  private def getCatalogElements(): List[Item] ={
    val xmlElements = xmlService.readXml(xmlFilePath)
    xmlElements
  }

}
