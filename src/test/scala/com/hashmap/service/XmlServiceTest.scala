package com.hashmap.service
import java.io.FileNotFoundException

import com.hashmap.dao.CatalogDaoImpl
import org.junit.{Assert, Before, Test}


class XmlServiceTest {

  var  xmlService: XmlService = _

  @Before
  def initialize(): Unit ={
     xmlService = new XmlService(new CatalogDaoImpl)
  }

  @Test(expected = classOf[FileNotFoundException])
  def readXmlShouldReturnNoFileException(): Unit = {
    val xmlFilePath  = "src/test/scala/com/hashmap/resources/catalog.xml"
    xmlService.readXml(xmlFilePath)
  }

  @Test
  def readXmlShouldReturnNoElementWhenFileIsEmpty(): Unit ={
    val xmlFilePath  = "src/test/scala/com/hashmap/resources/emptyCatalogTest.xml"
    val xmlElements = xmlService.readXml(xmlFilePath)

    Assert.assertTrue(xmlElements.isEmpty)
  }

  @Test
  def readXmlSuccess(): Unit ={
    val xmlFilePath  = "src/test/scala/com/hashmap/resources/catalogTest.xml"
    val xmlElements = xmlService.readXml(xmlFilePath)

    Assert.assertTrue(xmlElements.nonEmpty)
  }


}
