import { Component, OnInit } from "@angular/core";
import { Housing } from "src/app/housing";
import { HousingService } from "src/app/housing.service";
import { MessageService } from "src/app/message.service";

@Component({
  selector: "app-housing",
  templateUrl: "./housing.component.html",
  styleUrls: ["./housing.component.css"],
})
export class HousingsComponent implements OnInit {
  selectedHousing: Housing | undefined;

  housing: Housing[] | undefined;

  constructor(
    private housingService: HousingService,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.getHousing();
  }

  onSelect(housing: Housing): void {
    this.selectedHousing = housing;
    this.messageService.add(
      `HousingComponent: Selected housing id=${housing.id}`
    );
  }

  getHousing(): void {
    this.housingService
      .getHousing()
      .subscribe((housing) => (this.housing = housing));
  }
}
