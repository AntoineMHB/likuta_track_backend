package registration_of_users.login_signup.dto;

import java.util.Date;

public class FinancialGoalDTO {
    private String nameOfGoal;
    private double targetAmount;
    private Date targetDate;
    private double currentAmount;
    private String notes;
    private Long userId;

    // Getters and Setters

    public String getNameOfGoal() {
        return nameOfGoal;
    }

    public void setNameOfGoal(String nameOfGoal) {
        this.nameOfGoal = nameOfGoal;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
