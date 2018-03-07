package com.hashmap.model

import java.util.UUID

import scala.xml.Node

case class Item(id:UUID, name:String, price:Price, quantity: Quantity)

object Item {

  def fromXml(node: Node): Item = {
    val id = UUID.fromString((node \ "id").text)
    val name = (node \ "name").text
    val priceTemp = (node \ "unitPrice").map(Price.fromXml)
    val price = priceTemp.head
    val quantityTemp = (node \ "quantity").map(Quantity.fromXml)
    val quantity = quantityTemp.head
    Item(id, name, price, quantity)
  }
}
