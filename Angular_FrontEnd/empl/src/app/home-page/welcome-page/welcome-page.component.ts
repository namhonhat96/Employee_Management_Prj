import { NameService } from './../../service/home-page/name-service.service';
import { Name } from './../personal-info/name';
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-welcome-page",
  templateUrl: "./welcome-page.component.html",
  styleUrls: ["./welcome-page.component.css"],
})
export class WelcomePageComponent implements OnInit {
  user: Name | any;
  constructor(private nameService: NameService) {}
  ngOnInit(): void {
    this.nameService.getNameByID(1).subscribe((data) => {
      this.user = data;
    });
  }
}
