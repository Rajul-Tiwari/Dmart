package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.exception.StockItemNotFoundException;
import com.masai.model.StockItem;
import com.masai.repository.StockItemRepository;
@Service
public class StockItemServiceImpl implements StockItemService {
	
	@Autowired
	private StockItemRepository stockItemRepository;

	@Override
	public StockItem createStockItem(StockItem stockItem) throws StockItemNotFoundException {
		
		return stockItemRepository.save(stockItem);
	}

	@Override
	public StockItem updateStockItem(StockItem stockItem,Long id) throws StockItemNotFoundException {
		Optional<StockItem> u=stockItemRepository.findById(id);
		if(u.get()!=null) {
			u.get().setName(stockItem.getName());
			u.get().setQuantity(stockItem.getQuantity());
			
			
		}
		stockItemRepository.save(u.get());
		return u.get();
	}

	@Override
	public String deleteItem(Long stockId) throws StockItemNotFoundException {
		StockItem u=stockItemRepository.findById(stockId).orElseThrow(()->new RuntimeException("Does not exist") );
		stockItemRepository.delete(u);
		return "Successfully deleted";
	}

	@Override
	public StockItem getStockItemById(Long stockItemId) throws StockItemNotFoundException {
		Optional<StockItem> uOptional = stockItemRepository.findById(stockItemId);
        if(uOptional.isEmpty()) {
        	throw null;
        }
        StockItem si = uOptional.get();
        return si;
	}

}
