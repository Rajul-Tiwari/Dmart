package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.StoreLocation;
@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long>{

}
