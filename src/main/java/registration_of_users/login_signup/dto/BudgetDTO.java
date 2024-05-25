package registration_of_users.login_signup.dto;

public class BudgetDTO {
    private String budgetname;
    private double amount;

    // Getters and Setters

    public String getBudgetname() {
        return budgetname;
    }

    public void setBudgetname(String budgetname) {
        this.budgetname = budgetname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
