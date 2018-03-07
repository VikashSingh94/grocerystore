package com.hashmap.service

import com.hashmap.dao.CatalogDaoImpl
import org.junit.{Assert, Before, Test}

class CatalogTest {

  var catalogService:CatalogService = _

  @Before
  def initialize(): Unit ={
    val xmlService = new XmlService(new CatalogDaoImpl)
    val xmlFilePath = "/home/vikash/Downloads/file.xml"
    catalogService = new CatalogService(xmlFilePath,new CatalogDaoImpl,xmlService)
    catalogService.buildCatalog()
  }


  @Test
  def testGetCatalogShouldNotEmpty(): Unit ={
    val catalog =catalogService.getCatalog()
    Assert.assertTrue(catalog.nonEmpty)
  }

}
