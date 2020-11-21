package com.example.demo.controller;

import com.example.demo.pojo.Facility;
import com.example.demo.pojo.OnBoardApp_Address;
import com.example.demo.service.FacilityService;
import com.example.demo.service.OnBoardApp_ApplicationWorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class FacilityController {

   private FacilityService facilityService;

    @Autowired
    public void setFacilityService(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @RequestMapping(value = "/onboard-facility", method = RequestMethod.POST)
    ResponseEntity<?> addFacility(@RequestBody Facility facility) {
        Random random = new Random();
        int ID = random.nextInt();
        this.facilityService.addFacility(ID,facility.getType(),facility.getDescription(),facility.getQuantity(),
                facility.getHouseID());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @PostMapping("/onboard-facility/update/{id}")
    void updateFacility(@RequestBody Facility facility, @PathVariable("id") Integer ID) {
        this.facilityService.updateFacility(ID, facility.getType(), facility.getDescription(),
                facility.getQuantity(), facility.getHouseID());
    }


    @GetMapping("/onboard-facility/list")
    public List<Facility> getAllFacilities(){
        List<Facility> facilityList = this.facilityService.getAllFacilities();
        return facilityList;
    }

    @GetMapping("/onboard-facility/{id}")
    @ResponseBody
    public Facility getFacilityByID(@PathVariable("id") Integer ID) {
        return this.facilityService.getFacilityByID(ID);
    }
}
