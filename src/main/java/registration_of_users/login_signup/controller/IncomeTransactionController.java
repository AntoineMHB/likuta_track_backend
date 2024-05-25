package registration_of_users.login_signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registration_of_users.login_signup.dto.IncomeTransactionDTO;
import registration_of_users.login_signup.model.IncomeTransaction;
import registration_of_users.login_signup.service.IncomeTransactionService;
import registration_of_users.login_signup.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/income-transactions")
public class IncomeTransactionController {

    @Autowired
    private IncomeTransactionService incomeTransactionService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<IncomeTransaction> getAllIncomeTransactions() {
        return incomeTransactionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeTransaction> getIncomeTransactionById(@PathVariable Long id) {
        IncomeTransaction incomeTransaction = incomeTransactionService.findById(id);
        if (incomeTransaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(incomeTransaction);
    }

    @PostMapping
    public ResponseEntity<IncomeTransaction> createIncomeTransaction(@RequestBody IncomeTransactionDTO incomeTransactionDTO) {
        IncomeTransaction incomeTransaction = new IncomeTransaction();
        incomeTransaction.setSource_of_income(incomeTransactionDTO.getSourceOfIncome());
        incomeTransaction.setAmount(incomeTransactionDTO.getAmount());
        incomeTransaction.setDate(incomeTransactionDTO.getDate());

        // Retrieve and set the user (assuming user id is provided in DTO)
        if (incomeTransactionDTO.getUserId() != null) {
            incomeTransaction.setUser(userService.findById(incomeTransactionDTO.getUserId()));
        }

        IncomeTransaction savedIncomeTransaction = incomeTransactionService.save(incomeTransaction);
        return ResponseEntity.ok(savedIncomeTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncomeTransaction(@PathVariable Long id) {
        incomeTransactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
