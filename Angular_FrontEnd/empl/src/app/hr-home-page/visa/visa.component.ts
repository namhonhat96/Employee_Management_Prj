import { Component, OnInit } from "@angular/core";
import {
  animate,
  state,
  style,
  transition,
  trigger,
} from "@angular/animations";

@Component({
  selector: "app-visa",
  templateUrl: "./visa.component.html",
  styleUrls: ["./visa.component.css"],
  animations: [
    trigger("detailExpand", [
      state(
        "collapsed",
        style({ height: "0px", minHeight: "0", display: "none" })
      ),
      state("expanded", style({ height: "*" })),
      transition(
        "expanded <=> collapsed",
        animate("225ms cubic-bezier(0.4, 0.0, 0.2, 1)")
      ),
    ]),
  ],
})
export class VisaHRComponent implements OnInit {
  dataSource = ELEMENT_DATA;
  columnsToDisplay = [
    "Name",
    "Work Authorization",
    "Expiration Date",
    "DayLeft",
  ];
  expandedElement: PeriodicElement;
  constructor() {}

  ngOnInit() {}
}

export interface PeriodicElement {
  Name: string;
  DayLeft: number;
  WorkAuthorization: number;
  ExpirationDate: string;
  description: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  {
    DayLeft: 1,
    Name: "Hydrogen",
    WorkAuthorization: 1.0079,
    ExpirationDate: "H",
    description: `Hydrogen is a chemical element with symbol H and atomic number 1. With a standard
        atomic weight of 1.008, hydrogen is the lightest element on the periodic table.`,
  },
  {
    DayLeft: 2,
    Name: "Helium",
    WorkAuthorization: 4.0026,
    ExpirationDate: "He",
    description: `Helium is a chemical element with symbol He and atomic number 2. It is a
        colorless, odorless, tasteless, non-toxic, inert, monatomic gas, the first in the noble gas
        group in the periodic table. Its boiling point is the lowest among all the elements.`,
  },
  {
    DayLeft: 3,
    Name: "Lithium",
    WorkAuthorization: 6.941,
    ExpirationDate: "Li",
    description: `Lithium is a chemical element with symbol Li and atomic number 3. It is a soft,
        silvery-white alkali metal. Under standard conditions, it is the lightest metal and the
        lightest solid element.`,
  },
  {
    DayLeft: 4,
    Name: "Beryllium",
    WorkAuthorization: 9.0122,
    ExpirationDate: "Be",
    description: `Beryllium is a chemical element with symbol Be and atomic number 4. It is a
        relatively rare element in the universe, usually occurring as a product of the spallation of
        larger atomic nuclei that have collided with cosmic rays.`,
  },
];
