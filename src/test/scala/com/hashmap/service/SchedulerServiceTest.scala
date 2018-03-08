package com.hashmap.service

import java.util.{Timer, UUID}

import com.hashmap.dao.{CatalogDao, CatalogDaoImpl}
import com.hashmap.model.Item
import org.junit.{Assert, Before, Test}

class SchedulerServiceTest {

  var xmlService:XmlService = _
  var catalogService:CatalogService =_
  var catalogDao:CatalogDao[Item] =_
  var xmlFilePath:String =_
  @Before
  def initialize(): Unit ={
    xmlService = new XmlService()
    catalogDao = new CatalogDaoImpl()
    xmlFilePath  = "src/test/scala/com/hashmap/resources/catalogTest.xml"
    catalogService = new CatalogService(xmlFilePath,catalogDao,xmlService)
    catalogService.buildCatalog()
  }

  //already one item present in catalog
  @Test
  def testSchedulerWithOneItemDelta(): Unit ={
    val xmlFilePath  = "src/test/scala/com/hashmap/resources/catalogTemp.xml"

    val time = new Timer()
    time.schedule(com.hashmap.service.SchedulerService(xmlFilePath,xmlService,catalogService),500,10000)
    Thread.sleep(1000)

    Assert.assertTrue(catalogService.getCatalog().size == 2)
  }
}
