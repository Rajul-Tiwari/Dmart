package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.masai.exception.StockItemNotFoundException;
import com.masai.model.StockItem;
import com.masai.service.StockItemService;

@RestController

public class StockItemController {
	 @Autowired
	 private  StockItemService stockItemService;
	 
	 @PostMapping("stock-items")
	 public ResponseEntity<StockItem> addStockItem(@RequestBody StockItem stockItem) throws StockItemNotFoundException {
	        StockItem createdStockItem = stockItemService.createStockItem(stockItem);
	        return new ResponseEntity<>(createdStockItem, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("stock-items/{stockId}")
		public ResponseEntity<StockItem> updateItem(@RequestBody StockItem stockItem,@PathVariable Long stockId){
		 StockItem u=stockItemService.updateStockItem(stockItem, stockId);
			
			return new ResponseEntity<StockItem>(u,HttpStatus.ACCEPTED);
			
		}
	 
	 @GetMapping("stock-items/{stockId}")
		public ResponseEntity<StockItem> getItemByID(@PathVariable("stockId") Long stockId){
		 StockItem u=stockItemService.getStockItemById(stockId);
			
			return new ResponseEntity<StockItem>(u, HttpStatus.OK);
			
		}
	 
	 @DeleteMapping("stock-items/{stockId}")
		public ResponseEntity<String> deleteItemByID(@PathVariable("stockId") Long stockId){
			String u=stockItemService.deleteItem(stockId);
		
			
			return new ResponseEntity<String>(u, HttpStatus.OK);
			
			
		}
	 
	 

}
