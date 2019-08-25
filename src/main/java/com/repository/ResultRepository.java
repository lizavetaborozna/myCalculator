package com.repository;

import com.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query(value = "select * from calculator.calculatorresult  order by id desc limit 1 ", nativeQuery = true)
    Result showFinalTax();


    @Query(value = "select * from calculator.calculatorresult  where calculatorresult.result between 0 and 300", nativeQuery = true)
    List<Result> taxFilter();

    @Query(value = "select * from calculator.calculatorresult  where calculatorresult.result between 300 and 500", nativeQuery = true)
    List<Result> taxFilter1();

    @Query(value = "select * from calculator.calculatorresult  where calculatorresult.result between 500 and 1000", nativeQuery = true)
    List<Result> taxFilter2();

    default Result calculator(Result r) {
        int periodStr1 = r.getPeriodStr1();
        double amountOfRevenueFromSaleStr2 = r.getAmountFromSaleStr2();
        double amountNonOperatingIncomeSelectedPeriodStr3 = r.getAmountNoOperInStr3();
        boolean availabilityOfPlaceToWorkStr4 = r.isPlaceToWorkStr4();
        boolean existenceRightBenefitsStr5 = r.isExistBenefitsStr5();
        boolean widowSingleParentFosterParentGuardianTrusteeStr6 = r.isWidowSingleFosterGuardianStr6();
        int numberChildrenUnderEighteenStr7 = r.getNumberChildUnderEighteenStr7();
        int numberDisabledChildrenStr8 = r.getNumberDisableChildStr8();
        int numberDependentsStr9 = r.getNumberDependentsStr9();
        double amountExpensesForPeriodInsurancePemiumStr10 = r.getAmountInsurancePemiumStr10();
        double amountExpensesPeriodGetFirstPaidEducationStr11 = r.getAmountGetFirstPaidEducationStr11();
        double amountExpensesForConstructPurchaseHousingStr12 = r.getAmountForConstructHouseStr12();
        double amountExpensesEntrepreneurialActivitiesStr13 = r.getAmountEntreprenActivitiesStr13();


        double stepOne = 0, stepTwo = 0, stepThree = 0, stepFour = 0, stepFive = 0, stepSix = 0, result = 0;

        if (availabilityOfPlaceToWorkStr4) {
            if (amountExpensesEntrepreneurialActivitiesStr13 > amountOfRevenueFromSaleStr2 + amountNonOperatingIncomeSelectedPeriodStr3) {
                throw new NumberFormatException();
            }
            result = (amountOfRevenueFromSaleStr2 + amountNonOperatingIncomeSelectedPeriodStr3 - amountExpensesEntrepreneurialActivitiesStr13) * 0.16;
            Result result1 = new Result(Math.round(result * 100.0) / 100.0, periodStr1, amountOfRevenueFromSaleStr2, amountNonOperatingIncomeSelectedPeriodStr3, availabilityOfPlaceToWorkStr4, amountExpensesEntrepreneurialActivitiesStr13);
            return result1;
        }
        if (!availabilityOfPlaceToWorkStr4) {
            if (amountExpensesEntrepreneurialActivitiesStr13 > amountOfRevenueFromSaleStr2 + amountNonOperatingIncomeSelectedPeriodStr3) {
                throw new NumberFormatException();
            }

            stepOne = amountOfRevenueFromSaleStr2 + amountNonOperatingIncomeSelectedPeriodStr3;
            if ((stepOne - amountExpensesEntrepreneurialActivitiesStr13) <= 15_020_000) {
                stepTwo = stepOne - (830_000 * periodStr1);
            } else if ((stepOne - amountExpensesEntrepreneurialActivitiesStr13) > 15_020_000) {
                stepTwo = stepOne;
            }

            if (stepTwo < 0) {
                stepTwo = 0;
            }

            if (existenceRightBenefitsStr5) {
                stepThree = stepTwo - (1_170_000 * periodStr1);
            } else if (!existenceRightBenefitsStr5) {
                stepThree = stepTwo;
            }

            if (stepThree < 0) {
                stepThree = 0;
            }

            if (widowSingleParentFosterParentGuardianTrusteeStr6 && numberChildrenUnderEighteenStr7 > 0 && numberDependentsStr9 > 0
                    && numberDisabledChildrenStr8 <= numberChildrenUnderEighteenStr7) {
                stepFour = stepThree - periodStr1 * 460_000 * (numberChildrenUnderEighteenStr7 + numberDependentsStr9);
            } else if (!widowSingleParentFosterParentGuardianTrusteeStr6 && numberChildrenUnderEighteenStr7 == 1
                    && numberDisabledChildrenStr8 == 0 && numberDependentsStr9 > 0) {
                stepFour = stepThree - periodStr1 * 240_000 * (numberChildrenUnderEighteenStr7 + numberDependentsStr9);
            } else if (!widowSingleParentFosterParentGuardianTrusteeStr6 && numberChildrenUnderEighteenStr7 == 1
                    && numberDisabledChildrenStr8 == 1 && numberDependentsStr9 > 0) {
                stepFour = stepThree - periodStr1 * ((numberChildrenUnderEighteenStr7 * 460_000) + (numberDependentsStr9 * 240_000));
            } else if (!widowSingleParentFosterParentGuardianTrusteeStr6 && numberChildrenUnderEighteenStr7 > 1 && numberDependentsStr9 > 0
                    && numberDisabledChildrenStr8 <= numberChildrenUnderEighteenStr7) {
                stepFour = stepThree - periodStr1 * 460_000 * (numberChildrenUnderEighteenStr7 + numberDependentsStr9);
            }

            if (stepFour < 0) {
                stepFour = 0;
            }

            if (amountExpensesForPeriodInsurancePemiumStr10 <= 16_000_000) {
                stepFive = stepFour - amountExpensesForPeriodInsurancePemiumStr10;
            } else if (amountExpensesForPeriodInsurancePemiumStr10 > 16_000_000) {
                stepFive = stepFour - 16_000_000;
            }

            if (stepFive < 0) {
                stepFive = 0;
            }

            stepSix = stepFive - (amountExpensesPeriodGetFirstPaidEducationStr11
                    + amountExpensesForConstructPurchaseHousingStr12
                    + amountExpensesEntrepreneurialActivitiesStr13);
            if (stepSix < 0) {
                stepSix = 0;
            }
            result = stepSix * 0.16;
        }
        Result result1 = new Result(Math.round(result * 100.0) / 100.0, periodStr1, amountOfRevenueFromSaleStr2,
                amountNonOperatingIncomeSelectedPeriodStr3, availabilityOfPlaceToWorkStr4,
                amountExpensesEntrepreneurialActivitiesStr13);
        return result1;
    }
}
