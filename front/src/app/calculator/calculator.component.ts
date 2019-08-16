import {Component, OnInit} from "@angular/core";
import {Result} from "../models/result";
import {ResultService} from "../service/result.service";
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: "app-calculator",
  templateUrl: "./calculator.component.html",
  styleUrls: ["./calculator.component.css"]
})
export class CalculatorComponent implements OnInit {
  result: Result = new Result();
  checked = true;
  // tslint:disable-next-line:ban-types
  tax: Object;
  showMainContent: boolean;
  public formForPay: FormGroup;
  submitted = false;

  constructor(private resultService: ResultService,
              private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formForPay = this.formBuilder.group({
      periodStr1: new FormControl(null, [Validators.required]),
      amountFromSaleStr2: new FormControl(null, [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      amountNoOperInStr3: new FormControl(null, [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      placeToWorkStr4: new FormControl("", [Validators.required]),
      existBenefitsStr5: new FormControl("", [Validators.required]),
      widowSingleFosterGuardianStr6: new FormControl("", [Validators.required]),
      numberChildUnderEighteenStr7: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      numberDisableChildStr8: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      numberDependentsStr9: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      amountInsurancePemiumStr10: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      amountGetFirstPaidEducationStr11: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      amountForConstructHouseStr12: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
      amountEntreprenActivitiesStr13: new FormControl("", [Validators.required, Validators.pattern("[0-9]{1,20}")]),
    })
  }

  save() {
    this.resultService.createResult(this.result)
      .subscribe(
        (data) => {
          console.log(data);
          this.resultService.getCalculatedResult().subscribe((result) => {
            this.tax = result;
          });
        },
        error => console.log(error));
    this.result = new Result();
    this.formForPay.reset();
    this.submitted = true;
  }

  check() {
    if ((this.result.amountFromSaleStr2 + this.result.amountNoOperInStr3) >= this.result.amountEntreprenActivitiesStr13) {
      this.checked = true;
    } else {
      this.checked = false;
    }
    console.log(this.result.amountFromSaleStr2 + this.result.amountNoOperInStr3 >= this.result.amountEntreprenActivitiesStr13);
  }

  hidden(event) {
    this.showMainContent = event.value;
    console.log(this.showMainContent);
  }

  clearForm() {
    this.formForPay.reset();

  }

  isFormValid() {
    if (this.formForPay.valid || (this.showMainContent &&
      this.formForPay.controls.periodStr1.valid &&
      this.formForPay.controls.amountFromSaleStr2.valid &&
      this.formForPay.controls.amountNoOperInStr3.valid &&
      this.formForPay.controls.placeToWorkStr4.valid &&
      this.formForPay.controls.amountEntreprenActivitiesStr13.valid
    )) {
      return false;
    } else {
      return true;
    }
  }

}

