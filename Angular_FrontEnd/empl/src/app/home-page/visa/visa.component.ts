import { Observable } from 'rxjs';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { VisaService } from './../../service/home-page/visa-service.service';
import { Component, OnInit } from '@angular/core';
import { Visa } from './visa';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpResponse, HttpEventType } from '@angular/common/http';
@Component({
  selector: 'app-visa',
  templateUrl: './visa.component.html',
  styleUrls: ['./visa.component.css']
})
export class VisaComponent implements OnInit {
  info$: Visa | any;


  selectedFiles: FileList;
  progressInfos = [];
  message = '';

  fileInfos: Observable<any>;

  constructor(private service: VisaService, private router: Router) { }

  ngOnInit(): void {
    this.service.getVisaByID(1).subscribe((data) => {
      this.info$ = data;
    });

    this.fileInfos = this.service.getFiles();
  }

  updateVisa()
  {
    this.service.updateVisa(1, this.info$).subscribe(
      (data) => {
        this.router.navigate(['home-page-/visa']);
      },
      (error) => {}
    );
  }

  selectFiles(event) {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }

  uploadFiles() {
    this.message = '';
  
    for (let i = 0; i < this.selectedFiles.length; i++) {
      this.upload(i, this.selectedFiles[i]);
    }
  }

  upload(idx, file) {
    this.progressInfos[idx] = { value: 0, fileName: file.name };
  
    this.service.upload(file).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.fileInfos = this.service.getFiles();
        }
      },
      err => {
        this.progressInfos[idx].value = 0;
        this.message = 'Could not upload the file:' + file.name;
      });
  }

}  