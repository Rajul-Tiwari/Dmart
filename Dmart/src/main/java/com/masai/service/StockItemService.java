package com.masai.service;

import com.masai.exception.StockItemNotFoundException;

import com.masai.model.StockItem;


public interface StockItemService {
	 public StockItem createStockItem(StockItem stockItem) throws StockItemNotFoundException;
	 public StockItem updateStockItem(StockItem stockItem,Long id) throws StockItemNotFoundException;
	 public StockItem getStockItemById(Long stockItemId)throws StockItemNotFoundException;
	 public String deleteItem(Long stockId) throws StockItemNotFoundException;

}
