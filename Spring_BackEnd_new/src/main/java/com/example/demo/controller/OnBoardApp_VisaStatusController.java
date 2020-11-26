package com.example.demo.controller;

import com.example.demo.pojo.OnBoardApp_Employee;
import com.example.demo.pojo.OnBoardApp_VisaStatus;
import com.example.demo.pojo.Test;
import com.example.demo.service.OnBoardApp_PersonService;
import com.example.demo.service.OnBoardApp_VisaStatusService;
import com.example.demo.storage.StorageFileNotFoundException;
import com.example.demo.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.storage.StorageFileNotFoundException;
import com.example.demo.storage.StorageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@CrossOrigin()
@RestController
public class OnBoardApp_VisaStatusController {
    private OnBoardApp_VisaStatusService onBoardApp_visaStatusService;

    @Autowired
    public void setVisaStatusService(OnBoardApp_VisaStatusService onBoardApp_visaStatusService) {
        this.onBoardApp_visaStatusService = onBoardApp_visaStatusService;
    }

    @RequestMapping(value = "/onboard-visa-status", method = RequestMethod.POST)
    ResponseEntity<?> addVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus) {
        this.onBoardApp_visaStatusService.addVisaStatus(visaStatus.getID(),visaStatus.getVisaType(),visaStatus.getActive(), visaStatus.getCreateUser());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-visa-status/update/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updateVisaStatus(@RequestBody OnBoardApp_VisaStatus visaStatus, @PathVariable("id") Integer ID) {
        this.onBoardApp_visaStatusService.updateVisaStatus(ID,visaStatus.getVisaType(),visaStatus.getActive(), visaStatus.getCreateUser());
        return ResponseEntity.ok(new JwtResponse("okay"));
    }

    @RequestMapping(value = "/onboard-visa-status/list", method = RequestMethod.GET)
    public List<OnBoardApp_VisaStatus> getOnBoardApp_VisaStatusList(){
        return this.onBoardApp_visaStatusService.getAllVisaStatus();
    }

    @RequestMapping(value = "/onboard-visa-status/{id}", method = RequestMethod.GET)
    public OnBoardApp_VisaStatus getContactByIdWithVariableName(@PathVariable("id") Integer ID) {
        return this.onBoardApp_visaStatusService.getVisaStatusByID(ID);
    }

    /*
    Upload and download file with multipart
     */
    /*private final StorageService storageService;

    @Autowired
    public OnBoardApp_VisaStatusController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/upload")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/upload";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }*/
    /*
    =========================================================
     */
}
