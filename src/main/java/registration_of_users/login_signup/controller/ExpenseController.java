package registration_of_users.login_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registration_of_users.login_signup.dto.ExpenseDTO;
import registration_of_users.login_signup.model.Expense;
import registration_of_users.login_signup.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.findAll();
    }

    @GetMapping("/getExpenseById")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.findById(id);
        if (expense == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expense);
    }

    @PostMapping
    public Expense createExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setExpensename(expenseDTO.getExpensename());
        expense.setAmount(expenseDTO.getAmount());
        expense.setBudgetcategory(expenseDTO.getBudgetcategory());
        // Set user and budget here if needed
        return expenseService.save(expense);
    }

    @DeleteMapping("/deleteExpense")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
