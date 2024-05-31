package com.aibyte.arch.pattern.creation.loan;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import org.junit.jupiter.api.Test;

class CapitalCalculationTests {

  @Test
  void should_pass_term_loan_no_payments() {
    double commitment = 1000.0;
    int riskRating = 2;
    Date maturity = new Date();
    Loan termLoan = new Loan(commitment, riskRating, maturity);
    assertNotNull(termLoan);
  }

  @Test
  void should_pass_term_loan_with_risk_adjusted_capital_strategy() {
    double commitment = 1000.0;
    int riskRating = 2;
    Date maturity = new Date();
    Loan termLoan = new Loan(new CapitalStrategyTermLoan(), commitment, riskRating, maturity, null);
    assertNotNull(termLoan);
  }

  @Test
  void should_pass_revolver_loan() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Loan revolverLoan = new Loan(commitment, outstanding, riskRating, maturity, null);
    assertNotNull(revolverLoan);
  }

  @Test
  void should_pass_revolver_loan_with_risk_adjusted_capital_strategy() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Loan revolverLoan = new Loan(new CapitalStrategyRevolver(), commitment, outstanding, riskRating,
        maturity, null);
    assertNotNull(revolverLoan);
  }

  @Test
  void should_pass_rctl_loan() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Date expiry = new Date();
    Loan rctlLoan = new Loan(commitment, outstanding, riskRating, maturity, expiry);
    assertNotNull(rctlLoan);
  }

  @Test
  void should_pass_rctl_loan_with_risk_adjusted_capital_strategy() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Date expiry = new Date();
    Loan rctlLoan = new Loan(new CapitalStrategyRCTL(), commitment, outstanding, riskRating,
        maturity, expiry);
    assertNotNull(rctlLoan);
  }
}