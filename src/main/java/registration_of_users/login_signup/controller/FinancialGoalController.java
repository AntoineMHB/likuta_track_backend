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

import registration_of_users.login_signup.dto.FinancialGoalDTO;
import registration_of_users.login_signup.model.FinancialGoal;
import registration_of_users.login_signup.service.FinancialGoalService;
import registration_of_users.login_signup.service.UserService;

@RestController
@RequestMapping("/financial_goals")
public class FinancialGoalController {

    @Autowired
    private FinancialGoalService financialGoalService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<FinancialGoal> getAllFinancialGoals() {
        return financialGoalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialGoal> getFinancialGoalById(@PathVariable Long id) {
        FinancialGoal financialGoal = financialGoalService.findById(id);
        if (financialGoal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(financialGoal);
    }

    @PostMapping
    public ResponseEntity<FinancialGoal> createFinancialGoal(@RequestBody FinancialGoalDTO financialGoalDTO) {
        FinancialGoal financialGoal = new FinancialGoal();
        financialGoal.setName_of_goal(financialGoalDTO.getNameOfGoal());
        financialGoal.setTarget_amount(financialGoalDTO.getTargetAmount());
        financialGoal.setTarget_date(financialGoalDTO.getTargetDate());
        financialGoal.setCurrent_amount(financialGoalDTO.getCurrentAmount());
        financialGoal.setNotes(financialGoalDTO.getNotes());

        // Retrieve and set the user (assuming user id is provided in DTO)
        if (financialGoalDTO.getUserId() != null) {
            financialGoal.setUser(userService.findById(financialGoalDTO.getUserId()));
        }

        FinancialGoal savedFinancialGoal = financialGoalService.save(financialGoal);
        return ResponseEntity.ok(savedFinancialGoal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinancialGoal(@PathVariable Long id) {
        financialGoalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
