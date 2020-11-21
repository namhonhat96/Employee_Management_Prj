package com.example.demo.controller;


import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.House;
import com.example.demo.service.FacilityReportService;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@CrossOrigin()
@RestController
public class HouseController {

    private HouseService houseService;

    @Autowired
    public void setHouseService(HouseService houseService) {
        this.houseService = houseService;
    }

    @RequestMapping(value = "/house", method = RequestMethod.POST)
    ResponseEntity<?> addFacilityReport(@RequestBody House house) {
        Random random = new Random();
        int ID = random.nextInt();
        this.houseService.addHouse(ID,house.getContactID(), house.getAddress(),
                house.getNumberOfPerson());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @PostMapping("/house/update/{id}")
    void updateFacility(@RequestBody House house, @PathVariable("id") Integer ID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String reportDate = dateFormat.format(date);
        this.houseService.updateHouse(ID, house.getContactID(), house.getAddress(),
                house.getNumberOfPerson());
    }


    @GetMapping("/house/list")
    public List<House> getAllHouses(){
        List<House> houseList = this.houseService.getAllHouses();
        return houseList;
    }

    @GetMapping("/onboard-facility/{id}")
    @ResponseBody
    public House getHouseByID(@PathVariable("id") Integer ID) {
        return this.houseService.getHouseByID(ID);
    }

}
