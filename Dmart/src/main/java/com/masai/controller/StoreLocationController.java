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
import org.springframework.web.bind.annotation.RestController;


import com.masai.exception.StoreLocationException;

import com.masai.model.StoreLocation;
import com.masai.service.StoreLocationService;

@RestController
public class StoreLocationController {
	@Autowired
	private StoreLocationService storeLocationService;
	
	@PostMapping("store-location")
	 public ResponseEntity<StoreLocation> addStockItem(@RequestBody StoreLocation storeLocation) throws StoreLocationException {
		StoreLocation s = storeLocationService.addStoreLocation(storeLocation);
		System.out.println(storeLocation);
	        return new ResponseEntity<StoreLocation>(s, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("store-location/{storeLocationId}")
		public ResponseEntity<StoreLocation> updateLocation(@RequestBody StoreLocation storeLocation,@PathVariable Long storeLocationId) throws StoreLocationException{
		 StoreLocation u=storeLocationService.updateStoreLocation(storeLocation, storeLocationId);
			
			return new ResponseEntity<StoreLocation>(u,HttpStatus.ACCEPTED);
			
		}
	 
	 @GetMapping("store-location/{storeLocationId}")
		public ResponseEntity<StoreLocation> getItemByID(@PathVariable("stockId") Long stockId) throws StoreLocationException{
		 StoreLocation u=storeLocationService.getLocationById(stockId);
			
			return new ResponseEntity<StoreLocation>(u, HttpStatus.OK);
			
		}
	 
	 @DeleteMapping("store-location/{storeLocationId}")
		public ResponseEntity<String> deleteItemByID(@PathVariable("storeLocationId") Long storeLocationId) throws StoreLocationException{
			String u=storeLocationService.deleteLocation(storeLocationId);
		
			
			return new ResponseEntity<String>(u, HttpStatus.OK);
			
			
		}
	 
	 


}
