package com.ra.module5version2.controller.admin;

import com.ra.module5version2.model.entity.Category;
import com.ra.module5version2.service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String index(Model model){
        List<Category> list = categoryService.getAll();
        model.addAttribute("list",list);
        return "admin/category/index";
    }
    @GetMapping("/add-new-category")
    public String add(Model model){
        Category category = new Category();
        category.setStatus(true);

        model.addAttribute("category",category);
        return "admin/category/add-new-category";
    }
    @PostMapping("/add-new-category")
    public String save(@ModelAttribute("category") Category category){
        if(this.categoryService.create(category)) {

            return "redirect:/admin/category";
        }else {
            return "admin/category/add-new-category";
        }
    }
    @GetMapping("/edit-category/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);

        return "admin/category/edit-category";
    }
    @PostMapping("/edit-category")
    public String upadate(@ModelAttribute("category") Category category){
        if(this.categoryService.create(category)) {
            return "redirect:/admin/category";
        }else {
            return "admin/category/add-new-category";
        }
    }
    @GetMapping("/delete-category/{id}")
    public String delete( @PathVariable("id") Long id){
        if(this.categoryService.delete(id)){
            return "redirect:/admin/category";
        }
        else {
            return "redirect:/admin/category";
        }

    }
}
