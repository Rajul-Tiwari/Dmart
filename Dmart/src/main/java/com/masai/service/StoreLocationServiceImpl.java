package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StoreLocationException;

import com.masai.model.StoreLocation;
import com.masai.repository.StoreLocationRepository;
@Service
public class StoreLocationServiceImpl implements StoreLocationService {
	@Autowired
	private StoreLocationRepository storeLocationRepository;

	@Override
	public StoreLocation addStoreLocation(StoreLocation storeLocation) throws StoreLocationException {
		// TODO Auto-generated method stub
		return storeLocationRepository.save(storeLocation);
	}

	@Override
	public StoreLocation updateStoreLocation(StoreLocation storeLocation, Long id) throws StoreLocationException {
		Optional<StoreLocation> u=storeLocationRepository.findById(id);
		if(u.get()!=null) {
			u.get().setLocation(storeLocation.getLocation());
			
			
			
		}
		storeLocationRepository.save(u.get());
		return u.get();
	}

	@Override
	public String deleteLocation(Long locationId) throws StoreLocationException {
		StoreLocation u=storeLocationRepository.findById(locationId).orElseThrow(()->new RuntimeException("Does not exist") );
		storeLocationRepository.delete(u);
		return "Successfully deleted";
	}

	@Override
	public StoreLocation getLocationById(Long locationId) throws StoreLocationException {
		Optional<StoreLocation> uOptional = storeLocationRepository.findById(locationId);
        if(uOptional.isEmpty()) {
        	throw null;
        }
        StoreLocation si = uOptional.get();
        return si;
	}
	
	

}
