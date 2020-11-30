import { Component, OnInit } from "@angular/core";
import { TestServiceService } from "./test-service.service";

@Component({
  selector: "app-test-upload",
  templateUrl: "./test-upload.component.html",
  styleUrls: ["./test-upload.component.css"],
})
export class TestUploadComponent implements OnInit {
  files: any[];
  constructor(private uploadService: TestServiceService) {}

  ngOnInit() {}

  onFileChange(event) {
    this.files = event.target.files;
    console.log(event);
    //clear the selected file
  }

  uploadFile(event) {
    this.uploadService.uploadFile(event.target.value);
    //clear the selected file
    event.target.value = null;
  }
}
