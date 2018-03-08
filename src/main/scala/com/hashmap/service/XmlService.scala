package com.hashmap.service

import com.hashmap.model.Item
import scala.xml.XML

class XmlService() {

  def readXml(XmlFilePath: String): List[Item] = {

    val xmlDocument = XML.loadFile(XmlFilePath)

    val tagName = "item"
    val xmlElements = (xmlDocument \\ tagName).map(Item.fromXml).toList

    xmlElements
  }

}
