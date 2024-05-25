package registration_of_users.login_signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import registration_of_users.login_signup.dto.BudgetDTO;
import registration_of_users.login_signup.model.Budget;
import registration_of_users.login_signup.service.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.findAll();
    }

    @GetMapping("/getBudgetById")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
        Budget budget = budgetService.findById(id);
        if (budget == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(budget);
    }

    @PostMapping
    public Budget createBudget(@RequestBody BudgetDTO budgetDTO) {
        Budget budget = new Budget();
        budget.setBudgetname(budgetDTO.getBudgetname());
        budget.setAmount(budgetDTO.getAmount());
        // Set user here if needed
        return budgetService.save(budget);
    }

    @DeleteMapping("/deleteBudget")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
