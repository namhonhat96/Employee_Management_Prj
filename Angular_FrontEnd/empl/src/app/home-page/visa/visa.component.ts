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
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  selectedFile = null;
  changeImage = false;

  constructor(private service: VisaService, private router: Router) { }

  ngOnInit(): void {
    this.service.getVisaByID(1).subscribe((data) => {
      this.info$ = data;
    });

    
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

  downloadFile(){
    const link = document.createElement('a');
    link.setAttribute('target', '_blank');
    link.setAttribute('href', '_File_Saved_Path');
    link.setAttribute('download', 'file_name.pdf');
    document.body.appendChild(link);
    link.click();
    link.remove();
  }

  change($event) {
    this.changeImage = true;
  }

  changedImage(event) {
    this.selectedFile = event.target.files[0];
  }
  
  upload() {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.service.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        alert('File Successfully Uploaded');  
      }
    

    this.selectedFiles = undefined;
      }
    );
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
}  