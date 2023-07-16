package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StockMovementException;
import com.masai.exception.StoreLocationException;
import com.masai.model.StockMovement;
import com.masai.model.StoreLocation;
import com.masai.repository.StockMovementRepository;
@Service
public class StockMovementServiceImpl implements StockMovementService{
	@Autowired
	private StockMovementRepository  StockMovementRepository;

	@Override
	public StockMovement createStockMovement(StockMovement stockMovement)throws StockMovementException {
		// TODO Auto-generated method stub
		System.out.println(stockMovement.toString());
		return StockMovementRepository.save(stockMovement);
		
	}

	@Override
	public StockMovement getMovementById(Long movementId) throws StoreLocationException {
		Optional<StockMovement> uOptional = StockMovementRepository.findById(movementId);
        if(uOptional.isEmpty()) {
        	throw null;
        }
        StockMovement si = uOptional.get();
        return si;
	}

}
