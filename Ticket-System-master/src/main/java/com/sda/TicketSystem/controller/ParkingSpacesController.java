package com.sda.TicketSystem.controller;

import com.sda.TicketSystem.model.ParkingSpaceDTO;
import com.sda.TicketSystem.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/private")
public class ParkingSpacesController {

    private ParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpacesController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("/spaces")
    public String getAllSpaces(Model model) {
        List<ParkingSpaceDTO> parkingSpaceDTOS = parkingSpaceService.getAll();
        if (parkingSpaceDTOS.isEmpty()) {
            model.addAttribute("parking_spaces_message", "Empty Parking Spaces list !!!");
            model.addAttribute("parkingSpaceList", null);
        } else {
            model.addAttribute("parkingSpaceList", parkingSpaceDTOS);
        }
        return "parkingspaces";
    }
}
