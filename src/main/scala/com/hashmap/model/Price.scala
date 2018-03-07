package com.hashmap.model

import scala.xml.Node

case class Price(amount: Double, currency: String)

object Price {

  def fromXml(node: Node): Price = {
    val amount = (node \ "amount").text.toDouble
    val currency = (node \ "currency").text.toString
    Price(amount, currency)
  }

}