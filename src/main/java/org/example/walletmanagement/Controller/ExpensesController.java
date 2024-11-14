package org.example.walletmanagement.Controller;

import lombok.Getter;
import org.example.walletmanagement.Entity.Category;
import org.example.walletmanagement.Service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpensesController {

    CategoryService categoryService;

    ExpensesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/expenses")
    public String trackExpenses(){

        return "Expenses/track_expenses";
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
