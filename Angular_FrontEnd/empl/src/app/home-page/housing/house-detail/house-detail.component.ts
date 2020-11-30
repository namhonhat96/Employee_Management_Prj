import { Name } from "./../../personal-info/name";
import { EmploymentService } from "./../../../service/home-page/employment-service.service";
import { NameService } from "./../../../service/home-page/name-service.service";
import { Housing } from "./../housing";
import { HousingService } from "./../../../service/home-page/housing-service.service";
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../employee";
import { ActivatedRoute, Params, Router } from "@angular/router";

@Component({
  selector: "app-house-detail",
  templateUrl: "./house-detail.component.html",
  styleUrls: ["./house-detail.component.css"],
})
export class HouseDetailComponent implements OnInit {
  employee$: Observable<Employee[]>;
  info$: Housing | any;
  employeeList: Name[] | any;
  housingService: any;
  housing: any;

  constructor(
    private service: HousingService,
    private nameService: NameService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.service.getHouseByID(1).subscribe((data) => {
      this.info$ = data;
    });

    this.nameService.getNameByHouseID(1).subscribe((data) => {
      this.employeeList = data;
    });
  }

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
