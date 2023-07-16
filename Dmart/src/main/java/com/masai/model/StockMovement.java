package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockMovement {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "stock_item_id")
	    private StockItem stockItem;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "from_store_location_id")
	    private StoreLocation fromStoreLocation;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "to_store_location_id")
	    private StoreLocation toStoreLocation;

	   
	    private int quantity;
	    
	    private LocalDateTime time=LocalDateTime.now();

	   
	   

}
