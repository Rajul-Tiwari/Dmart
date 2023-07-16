package com.masai.service;

import com.masai.exception.StockMovementException;
import com.masai.exception.StoreLocationException;
import com.masai.model.StockMovement;
import com.masai.model.StoreLocation;

public interface StockMovementService {
	public StockMovement createStockMovement(StockMovement stockMovement)throws StockMovementException;
	  public StockMovement getMovementById(Long movementId)throws StoreLocationException;

}
