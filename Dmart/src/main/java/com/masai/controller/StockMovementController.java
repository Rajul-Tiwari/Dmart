package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.StoreLocationException;
import com.masai.model.StockMovement;

import com.masai.service.StockMovementService;

@RestController
public class StockMovementController {
	@Autowired
	private StockMovementService StockMovementService;
	
	@PostMapping("stock-movement")
	 public ResponseEntity<StockMovement> addStockItem(@RequestBody StockMovement stockMovement) throws StoreLocationException {
		System.out.println(stockMovement);
		StockMovement createdStockItem = StockMovementService.createStockMovement(stockMovement);
		
	        return new ResponseEntity<>(createdStockItem, HttpStatus.CREATED);
	    }

}
