package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.StockMovement;
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long>{

}
