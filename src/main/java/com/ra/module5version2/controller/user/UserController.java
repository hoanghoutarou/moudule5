package com.ra.module5version2.controller.user;

import com.ra.module5version2.model.entity.Category;
import com.ra.module5version2.service.Category.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/home")

public class UserController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String home(Model model, HttpSession session){
        List<Category> categories = categoryService.getAll();
        session.setAttribute("categories",categories);
        return "home/index";
    }
}
