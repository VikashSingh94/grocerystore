package com.hashmap.service

import com.hashmap.dao.{CatalogDao}
import com.hashmap.model.Item

class CatalogService(xmlFilePath:String ,catalogDao : CatalogDao[Item] ,xmlService: XmlService) {

  def getCatalog(): List[Item] = {
    catalogDao.getItems()
  }

  def buildCatalog(): Unit ={
    val catalogElements = getCatalogElements()
    saveElementsToCatalog(catalogElements)
  }

  def addItem(item: Item): Unit ={
    catalogDao.addItem(item)
  }

  def updateItem(item: Item): Unit ={
    catalogDao.updateItem(item)
  }

  private def saveElementsToCatalog(xmlElements: List[Item]): Unit = {
    xmlElements.foreach(element => catalogDao.addItem(element))
  }

  private def getCatalogElements(): List[Item] ={
    val xmlElements = xmlService.readXml(xmlFilePath)
    xmlElements
  }

}
