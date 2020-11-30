import { Component, Input, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Housing } from "../home-page/housing/housing";
import { HousingService } from "../service/home-page/housing-service.service";

@Component({
  selector: "app-housing-detail",
  templateUrl: "./housing-detail.component.html",
  styleUrls: ["./housing-detail.component.css"],
})
export class HousingDetailComponent implements OnInit {
  @Input() housing: Housing | undefined;

  constructor(private router: Router, private housingService: HousingService) {}

  ngOnInit(): void {}
  updateHouse() {
    this.housingService.updateHouse(this.housing.id, this.housing).subscribe(
      (data) => {
        this.router.navigate(["hr-home-page/house-manage"]);
      },
      (error) => {}
    );
  }
}
