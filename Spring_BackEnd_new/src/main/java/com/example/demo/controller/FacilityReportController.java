package com.example.demo.controller;

import com.example.demo.pojo.Facility;
import com.example.demo.pojo.FacilityReport;
import com.example.demo.service.FacilityReportService;
import com.example.demo.service.FacilityService;
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
public class FacilityReportController {
    private FacilityReportService facilityReportService;

    @Autowired
    public void setFacilityReportService(FacilityReportService facilityReportService) {
        this.facilityReportService = facilityReportService;
    }

    @RequestMapping(value = "/onboard-facility-report", method = RequestMethod.POST)
    ResponseEntity<?> addFacilityReport(@RequestBody FacilityReport facilityReport) {
        Random random = new Random();
        int ID = random.nextInt();
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String reportDate = dateFormat.format(date);
        String status = "OPEN";

        this.facilityReportService.addFacilityReport(ID,facilityReport.getTitle(), facilityReport.getEmployeeID(),
                reportDate, facilityReport.getDescription(), status);
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @PostMapping("/onboard-facility-report/update/{id}")
    void updateFacility(@RequestBody FacilityReport facilityReport, @PathVariable("id") Integer ID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String reportDate = dateFormat.format(date);
        this.facilityReportService.updateFacilityReport(ID, facilityReport.getTitle(), facilityReport.getEmployeeID(),
                reportDate, facilityReport.getDescription(), facilityReport.getStatus());
    }


    @GetMapping("/onboard-facility-report/list")
    public List<FacilityReport> getAllFacilityReports(){
        List<FacilityReport> facilityReportList = this.facilityReportService.getAllFacilityReports();
        return facilityReportList;
    }

    @GetMapping("/onboard-facility-report/{id}")
    @ResponseBody
    public FacilityReport getFacilityReportByID(@PathVariable("id") Integer ID) {
        return this.facilityReportService.getFacilityReportByID(ID);
    }
}
