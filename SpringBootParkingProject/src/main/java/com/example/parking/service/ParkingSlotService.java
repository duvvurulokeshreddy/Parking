package com.example.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.ParkingSlot;
import com.example.parking.repository.ParkingSlotRepository;

@Service
public class ParkingSlotService    {
	
	@Autowired
	 private ParkingSlotRepository parkingSlotRepository;
	
	public List<ParkingSlot> getAvailableSlots() {
        return parkingSlotRepository.findByAvailable(true);
    }

    public ParkingSlot bookSlot(Long id) {
        ParkingSlot slot = parkingSlotRepository.findById(id).orElseThrow(() -> new RuntimeException("Slot not found"));
        if (!slot.isAvailable()) {
            throw new RuntimeException("Slot is already booked");
        }
        slot.setAvailable(false);
        return parkingSlotRepository.save(slot);
    }
	
}
//findById(id).orElseThrow(() -> new RuntimeException("Slot not found"));