import {ResultService} from "../service/result.service";
import {Result} from "../models/result";
import {Router} from "@angular/router";
import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: "app-result-list",
  templateUrl: "./result-list.component.html",
  styleUrls: ["./result-list.component.css"]
})
export class ResultListComponent implements OnInit {
  results: Result[];
  jobCheck = false;
  taxCheck = false;
  tax: Result[];
  public formForPay: FormGroup;


  constructor(private resultService: ResultService,
              private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formForPay = this.formBuilder.group({
      taxCheck: new FormControl(""),
      jobCheck: new FormControl(""),
    })
    this.showList();
  }

  showList() {
    this.resultService.getResultsList().subscribe((data) => {
      console.log(data);
      this.results = data;
    });
  }

  showFiltredList() {
    this.resultService.getFilterResult().subscribe((data) => {
      console.log(data);
      this.results = data;
    });
  }

  jobFilter() {
    if (!this.jobCheck) {
      this.results = this.results.filter((result) => result.placeToWorkStr4 === true);
      console.log(this.results);
    } else if (this.jobCheck && !this.taxCheck) {
      this.showList();
    }

  }

  filter() {
    // if (this.formForPay.controls.taxCheck.value == "1") {
    //   this.resultService.getFilterResult().subscribe((result) => {
    //     this.results = result;
    //   });
    // } else if (this.formForPay.controls.taxCheck.value == "2") {
    //   this.resultService.getFilterResult1().subscribe((result) => {
    //     this.results = result;
    //   });
    // } else if (this.formForPay.controls.taxCheck.value == "3") {
    //   this.resultService.getFilterResult2().subscribe((result) => {
    //     this.results = result;
    //   });
    // }
    this.resultService.sendToFilter((this.formForPay.controls.taxCheck.value)).subscribe((data => {
      console.log(data);
      this.resultService.getFilterResult().subscribe((result) => {
        this.results = result;
      });
    }))
  }

}
