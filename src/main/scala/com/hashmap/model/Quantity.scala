package com.hashmap.model


import scala.xml.Node

case class Quantity(stock: Int, measure: String)

object Quantity {

  def fromXml(node: Node): Quantity = {
    val stock = (node \ "stock").text.toInt
    val measure = (node \ "measure").text
    Quantity(stock, measure)
  }

}
