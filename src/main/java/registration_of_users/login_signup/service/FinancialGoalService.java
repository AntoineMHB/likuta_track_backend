package registration_of_users.login_signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registration_of_users.login_signup.model.FinancialGoal;
import registration_of_users.login_signup.repository.FinancialGoalRepository;

import java.util.List;

@Service
public class FinancialGoalService {

    @Autowired
    private FinancialGoalRepository financialGoalRepository;

    public List<FinancialGoal> findAll() {
        return financialGoalRepository.findAll();
    }

    public FinancialGoal findById(Long id) {
        return financialGoalRepository.findById(id).orElse(null);
    }

    public FinancialGoal save(FinancialGoal financialGoal) {
        return financialGoalRepository.save(financialGoal);
    }

    public void deleteById(Long id) {
        financialGoalRepository.deleteById(id);
    }
}
