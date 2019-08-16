package com.model;

import javax.persistence.*;

@Entity
@Table(name = "calculatorresult")

public class Result {
    private long id;
    private Double result;

    private int periodStr1;
    private double amountFromSaleStr2;
    private double amountNoOperInStr3;
    private boolean placeToWorkStr4;
    private boolean existBenefitsStr5;
    private boolean widowSingleFosterGuardianStr6;
    private int numberChildUnderEighteenStr7;
    private int numberDisableChildStr8;
    private int numberDependentsStr9;
    private double amountInsurancePemiumStr10;
    private double amountGetFirstPaidEducationStr11;
    private double amountForConstructHouseStr12;
    private double amountEntreprenActivitiesStr13;

    public Result() {
    }

    public Result(Double result) {
        this.result = result;
    }

    public Result(Double result, int periodStr1, double amountFromSaleStr2, double amountNoOperInStr3, boolean placeToWorkStr4, double amountEntreprenActivitiesStr13) {
        this.result = result;
        this.periodStr1 = periodStr1;
        this.amountFromSaleStr2 = amountFromSaleStr2;
        this.amountNoOperInStr3 = amountNoOperInStr3;
        this.placeToWorkStr4 = placeToWorkStr4;
        this.amountEntreprenActivitiesStr13 = amountEntreprenActivitiesStr13;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "result", nullable = false)
    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public int getPeriodStr1() {
        return periodStr1;
    }

    public void setPeriodStr1(int periodStr1) {
        this.periodStr1 = periodStr1;
    }

    public double getAmountFromSaleStr2() {
        return amountFromSaleStr2;
    }

    public void setAmountFromSaleStr2(double amountFromSaleStr2) {
        this.amountFromSaleStr2 = amountFromSaleStr2;
    }

    public double getAmountNoOperInStr3() {
        return amountNoOperInStr3;
    }

    public void setAmountNoOperInStr3(double amountNoOperInStr3) {
        this.amountNoOperInStr3 = amountNoOperInStr3;
    }

    public boolean isPlaceToWorkStr4() {
        return placeToWorkStr4;
    }

    public void setPlaceToWorkStr4(boolean placeToWorkStr4) {
        this.placeToWorkStr4 = placeToWorkStr4;
    }

    public boolean isExistBenefitsStr5() {
        return existBenefitsStr5;
    }

    public void setExistBenefitsStr5(boolean existBenefitsStr5) {
        this.existBenefitsStr5 = existBenefitsStr5;
    }

    public boolean isWidowSingleFosterGuardianStr6() {
        return widowSingleFosterGuardianStr6;
    }

    public void setWidowSingleFosterGuardianStr6(boolean widowSingleFosterGuardianStr6) {
        this.widowSingleFosterGuardianStr6 = widowSingleFosterGuardianStr6;
    }

    public int getNumberChildUnderEighteenStr7() {
        return numberChildUnderEighteenStr7;
    }

    public void setNumberChildUnderEighteenStr7(int numberChildUnderEighteenStr7) {
        this.numberChildUnderEighteenStr7 = numberChildUnderEighteenStr7;
    }

    public int getNumberDisableChildStr8() {
        return numberDisableChildStr8;
    }

    public void setNumberDisableChildStr8(int numberDisableChildStr8) {
        this.numberDisableChildStr8 = numberDisableChildStr8;
    }

    public int getNumberDependentsStr9() {
        return numberDependentsStr9;
    }

    public void setNumberDependentsStr9(int numberDependentsStr9) {
        this.numberDependentsStr9 = numberDependentsStr9;
    }

    public double getAmountInsurancePemiumStr10() {
        return amountInsurancePemiumStr10;
    }

    public void setAmountInsurancePemiumStr10(double amountInsurancePemiumStr10) {
        this.amountInsurancePemiumStr10 = amountInsurancePemiumStr10;
    }

    public double getAmountGetFirstPaidEducationStr11() {
        return amountGetFirstPaidEducationStr11;
    }

    public void setAmountGetFirstPaidEducationStr11(double amountGetFirstPaidEducationStr11) {
        this.amountGetFirstPaidEducationStr11 = amountGetFirstPaidEducationStr11;
    }

    public double getAmountForConstructHouseStr12() {
        return amountForConstructHouseStr12;
    }

    public void setAmountForConstructHouseStr12(double amountForConstructHouseStr12) {
        this.amountForConstructHouseStr12 = amountForConstructHouseStr12;
    }

    public double getAmountEntreprenActivitiesStr13() {
        return amountEntreprenActivitiesStr13;
    }

    public void setAmountEntreprenActivitiesStr13(double amountEntreprenActivitiesStr13) {
        this.amountEntreprenActivitiesStr13 = amountEntreprenActivitiesStr13;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", result=" + result +
                ", periodStr1=" + periodStr1 +
                ", amountFromSaleStr2=" + amountFromSaleStr2 +
                ", amountNoOperInStr3=" + amountNoOperInStr3 +
                ", placeToWorkStr4=" + placeToWorkStr4 +
                ", existBenefitsStr5=" + existBenefitsStr5 +
                ", widowSingleFosterGuardianStr6=" + widowSingleFosterGuardianStr6 +
                ", numberChildUnderEighteenStr7=" + numberChildUnderEighteenStr7 +
                ", numberDisableChildStr8=" + numberDisableChildStr8 +
                ", numberDependentsStr9=" + numberDependentsStr9 +
                ", amountInsurancePemiumStr10=" + amountInsurancePemiumStr10 +
                ", amountGetFirstPaidEducationStr11=" + amountGetFirstPaidEducationStr11 +
                ", amountForConstructHouseStr12=" + amountForConstructHouseStr12 +
                ", amountEntreprenActivitiesStr13=" + amountEntreprenActivitiesStr13 +
                '}';
    }
}
