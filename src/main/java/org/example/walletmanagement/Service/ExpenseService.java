package org.example.walletmanagement.Service;

import org.example.walletmanagement.Entity.Expense;
import org.example.walletmanagement.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void save(Expense expense) {
        expenseRepository.save(expense);
    }
}
