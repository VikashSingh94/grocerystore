package com.hashmap.service

import util.control.Breaks._
import java.util.{TimerTask, UUID}
import com.hashmap.model.{Item, Quantity}

case class SchedulerService(xmlFilePath: String , xmlService: XmlService, catalogService: CatalogService) extends TimerTask {

  override def run(): Unit = {

    val oldCatalogItems = catalogService.getCatalog()
    val newCatalogItems = xmlService.readXml(xmlFilePath)

    updateCatalog(oldCatalogItems, newCatalogItems)
  }

  def updateCatalog(oldCatalogItems: List[Item], newCatalogItems: List[Item]): Unit = {

    for (newItem <- newCatalogItems) {

        val oldItem = findItemInCatalog(oldCatalogItems, newItem.id)

        if(oldItem == None)
          catalogService.addItem(newItem)
        else {
          val updatedItem = updateItemStock(oldItem.get, newItem)
          catalogService.updateItem(updatedItem)
        }

    }

  }

  private def findItemInCatalog(items:List[Item],key:UUID): Option[Item] ={
    items.find(item => item.id == key)
  }

  private def updateItemStock(oldItem: Item, newItem: Item): Item = {
    val oldStock = oldItem.quantity.stock
    val newStock = newItem.quantity.stock
    val newQuantity = Quantity((oldStock + newStock), oldItem.quantity.measure)

    oldItem.copy(quantity = newQuantity)
  }

}