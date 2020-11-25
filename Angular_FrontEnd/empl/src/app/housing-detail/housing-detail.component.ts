import { Component, Input, OnInit } from "@angular/core";
import { ActivatedRoute, Params, Router } from "@angular/router";
import { Housing } from "../housing";
import { HousingService } from "../housing.service";
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
    this.housingService
      .updateHouse(
        this.housing.id,
        this.housing.contactID,
        this.housing.address,
        this.housing.numberOfPerson
      )
      .subscribe(
        (data) => {
          this.router.navigate(["hr-home-page/house-manage"]);
        },
        (error) => {}
      );
  }
}
