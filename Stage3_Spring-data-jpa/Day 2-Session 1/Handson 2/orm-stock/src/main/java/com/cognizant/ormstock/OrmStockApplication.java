package com.cognizant.ormstock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormstock.model.Stock;
import com.cognizant.ormstock.service.StockService;

@SpringBootApplication
public class OrmStockApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrmStockApplication.class);
	private static StockService stockService;

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(OrmStockApplication.class, args);
		LOGGER.info("Inside main");
		stockService=context.getBean(StockService.class);
		
		List<Stock> list=stockService.getTop3ByCode();
		for(Stock s:list) {
			System.out.println(s.toString());
		}
	}

}
