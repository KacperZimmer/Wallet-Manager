package org.example.walletmanagement.Service;

import org.example.walletmanagement.Entity.Expense;
import org.example.walletmanagement.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void save(Expense expense) {
        expenseRepository.save(expense);
    }
    public Expense findbyId(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public void update(Expense expense) {
        this.expenseRepository.save(expense);
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }
    public void delete(Expense expense) {
        this.expenseRepository.delete(expense);
    }

}
