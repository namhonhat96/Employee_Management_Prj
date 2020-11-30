package com.example.demo.controller;

import com.example.demo.dao.FacilityReportDetailDAO;
import com.example.demo.pojo.FacilityReport;
import com.example.demo.pojo.FacilityReportDetail;
import com.example.demo.service.FacilityReportService;
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
public class FacilityReportDetailController {
    private FacilityReportDetailDAO facilityReportDetailDAO;

    @Autowired
    public void setFacilityReportDetailDAO(FacilityReportDetailDAO facilityReportDetailDAO) {
        this.facilityReportDetailDAO = facilityReportDetailDAO;
    }

    @RequestMapping(value = "/onboard-facility-report-detail", method = RequestMethod.POST)
    ResponseEntity<?> addFacilityReportDetail(@RequestBody FacilityReportDetail facilityReportDetail) {
        Random random = new Random();
        int ID = random.nextInt();
        int reportID = random.nextInt(1000);
        int employeeID = random.nextInt(1000);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String createDate = dateFormat.format(date);

        this.facilityReportDetailDAO.addFacilityReportDetail(ID,reportID, employeeID,facilityReportDetail.getComment(),
                createDate, createDate);
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-facility-detail/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?>  updateFacilityReportDetail(@RequestBody FacilityReportDetail facilityReportDetail, @PathVariable("id") Integer ID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String reportDate = dateFormat.format(date);
        this.facilityReportDetailDAO.updateFacilityReportDetail(ID, facilityReportDetail.getReportID(),
                facilityReportDetail.getEmployeeID(), facilityReportDetail.getComment(),
                facilityReportDetail.getCreateDate(),reportDate );
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-facility-detail/list", method = RequestMethod.GET)
    public List<FacilityReportDetail> getAllFacilityReportDetails(){
        List<FacilityReportDetail> facilityReportDetails = this.facilityReportDetailDAO.getAllFacilityReportDetails();
        return facilityReportDetails;
    }

    @RequestMapping(value = "/onboard-facility-detail/{id}", method = RequestMethod.GET)
    public FacilityReportDetail getFacilityReportByID(@PathVariable("id") Integer ID) {
        return this.facilityReportDetailDAO.getFacilityReportDetailByID(ID);
    }
    
    @RequestMapping(value = "/onboard-facility-detail/list/{id}", method = RequestMethod.GET)
    public List<FacilityReportDetail> getFacilityReportByReportID(@PathVariable("id") Integer ID) {
        return this.facilityReportDetailDAO.getFacilityReportDetailByReportID(ID);
    }
}
