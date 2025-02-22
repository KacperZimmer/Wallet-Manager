package org.example.walletmanagement.Controller;

import lombok.Getter;
import org.example.walletmanagement.Entity.Category;
import org.example.walletmanagement.Entity.Expense;
import org.example.walletmanagement.Service.CategoryService;
import org.example.walletmanagement.Service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping ("/expenses/delete/{id}")
    public String delete(@PathVariable Long id){

        Expense expense1 = expenseService.findbyId(id);
        this.expenseService.delete(expense1);

        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String trackExpenses(Model model) {

        Expense expense = new Expense();
        List<Category> categoryList = this.categoryService.findAll();
        List<Expense> expenseList = this.expenseService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("expensesList", expenseList);
        model.addAttribute("expense", expense);

        return "Expenses/track_expenses";
    }
    @GetMapping("expenses/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Expense expense = expenseService.findbyId(id);
        model.addAttribute("expense", expense);
        model.addAttribute("categoryList", this.categoryService.findAll());


        return "Expenses/edit";
    }

    @PutMapping("expenses/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Expense expense){

        this.expenseService.update(expense);
        expense.setId(id);

        return "redirect:/expenses";
    }
    @GetMapping("/expenses/add_category")
    public String addCategory(Model model){

        Category category = new Category();

        model.addAttribute("category", category);

        return "Expenses/add_category";
    }

    @PostMapping("/expenses")
    public String addExpense(@ModelAttribute("expense") Expense expense){

        expenseService.save(expense);
        return "redirect:/expenses";
    }


    @PostMapping("/expenses/add_category")
    public String addCategory(@ModelAttribute("category") Category category){


        this.categoryService.save(category);
        return "redirect:/expenses";
    }

}
