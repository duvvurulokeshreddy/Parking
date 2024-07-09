package com.example.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.ParkingSlot;
import com.example.parking.service.ParkingSlotService;


public interface ParkingSlotRepository  extends JpaRepository<ParkingSlot, Long> {

	List<ParkingSlot> findByAvailable(boolean available);

	
}
