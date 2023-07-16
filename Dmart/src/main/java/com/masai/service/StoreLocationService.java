package com.masai.service;

import com.masai.exception.StockItemNotFoundException;
import com.masai.exception.StoreLocationException;
import com.masai.model.StockItem;
import com.masai.model.StoreLocation;

public interface StoreLocationService {
	  public StoreLocation addStoreLocation(StoreLocation storeLocation)throws StoreLocationException;
	  public StoreLocation updateStoreLocation(StoreLocation storeLocation,Long id) throws StoreLocationException;
	  public String deleteLocation(Long locationId) throws StoreLocationException;
	  public StoreLocation getLocationById(Long locationId)throws StoreLocationException;

}
