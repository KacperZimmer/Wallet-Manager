package org.example.walletmanagement.Controller;

import lombok.Getter;
import org.example.walletmanagement.Entity.Category;
import org.example.walletmanagement.Entity.Expense;
import org.example.walletmanagement.Service.CategoryService;
import org.example.walletmanagement.Service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpensesController {

    CategoryService categoryService;
    ExpenseService expenseService;

    ExpensesController(CategoryService categoryService, ExpenseService expenseService) {
        this.categoryService = categoryService;
        this.expenseService = expenseService;
    }
    @GetMapping("/expenses/test")
    public String test(Model model){
        Expense expense1 = expenseService.findbyId(1L);
        model.addAttribute("expense1", expense1);

        return "Expenses/test";
    }


    @GetMapping("/expenses")
    public String trackExpenses(Model model) {

        Expense expense = new Expense();

        model.addAttribute("expense", expense);
        return "Expenses/track_expenses";
    }

    @PostMapping("/expenses")
    public String addExpense(@ModelAttribute("expense") Expense expense){

        expenseService.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/add_category")
    public String addCategory(Model model){

        Category category = new Category();

        model.addAttribute("category", category);

        return "Expenses/add_category";
    }


    @PostMapping("/expenses/add_category")
    public String addCategory(@ModelAttribute("category") Category category){


        this.categoryService.save(category);
        return "redirect:/expenses";
    }

}
