package com.aibyte.arch.pattern.creation.loan;

import static com.aibyte.arch.pattern.creation.loan.Loan.createRCTL;
import static com.aibyte.arch.pattern.creation.loan.Loan.createRevolver;
import static com.aibyte.arch.pattern.creation.loan.Loan.createTermLoan;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import org.junit.jupiter.api.Test;

class CapitalCalculationTests {

  @Test
  void should_pass_term_loan_no_payments() {
    double commitment = 1000.0;
    int riskRating = 2;
    Date maturity = new Date();
    Loan termLoan = createTermLoan(commitment, riskRating, maturity);
    assertNotNull(termLoan);
  }

  @Test
  void should_pass_term_loan_with_risk_adjusted_capital_strategy() {
    double commitment = 1000.0;
    int riskRating = 2;
    Date maturity = new Date();
    CapitalStrategy capitalStrategy = new CapitalStrategyTermLoan();
    Loan termLoan = createTermLoan(capitalStrategy, commitment,
        riskRating, maturity);
    assertNotNull(termLoan);
  }

  @Test
  void should_pass_revolver_loan() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Loan revolverLoan = createRevolver(commitment, outstanding,
        riskRating, maturity);
    assertNotNull(revolverLoan);
  }

  @Test
  void should_pass_revolver_loan_with_risk_adjusted_capital_strategy() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    CapitalStrategy capitalStrategy = new CapitalStrategyRevolver();
    Loan revolverLoan = createRevolver(capitalStrategy, commitment,
        outstanding, riskRating, maturity);
    assertNotNull(revolverLoan);
  }

  @Test
  void should_pass_rctl_loan() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Date expiry = new Date();
    Loan rctlLoan = createRCTL(commitment, outstanding, riskRating,
        maturity, expiry);
    assertNotNull(rctlLoan);
  }


  @Test
  void should_pass_rctl_loan_with_risk_adjusted_capital_strategy() {
    double commitment = 1000.0;
    double outstanding = 1.0;
    int riskRating = 2;
    Date maturity = new Date();
    Date expiry = new Date();
    CapitalStrategy capitalStrategy = new CapitalStrategyRCTL();
    Loan rctlLoan = createRCTL(capitalStrategy, commitment,
        outstanding, riskRating, maturity, expiry);
    assertNotNull(rctlLoan);
  }
}