package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.model.ParkingSlot;
import com.example.parking.service.ParkingSlotService;

@RestController
@RequestMapping("/api/parkingslots")
public class ParkingLotController {
	
	 @Autowired
	    private ParkingSlotService parkingSlotService;

	    @GetMapping("/available")
	    public List<ParkingSlot> getAvailableSlots() {
	        return parkingSlotService.getAvailableSlots();
	    }

	    @PostMapping("/book/{id}")
	    public ParkingSlot bookSlot(@PathVariable Long id) {
	        return parkingSlotService.bookSlot(id);
	    }


}
