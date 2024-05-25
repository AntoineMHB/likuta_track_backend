package registration_of_users.login_signup.dto;

public class ExpenseDTO {
    private String expensename;
    private double amount;
    private String budgetcategory;

    // Getters and Setters

    public String getExpensename() {
        return expensename;
    }

    public void setExpensename(String expensename) {
        this.expensename = expensename;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBudgetcategory() {
        return budgetcategory;
    }

    public void setBudgetcategory(String budgetcategory) {
        this.budgetcategory = budgetcategory;
    }
}
