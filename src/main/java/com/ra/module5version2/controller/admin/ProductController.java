package com.ra.module5version2.controller.admin;

import com.ra.module5version2.model.entity.Category;
import com.ra.module5version2.model.entity.Product;
import com.ra.module5version2.service.Category.CategoryService;
import com.ra.module5version2.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Value("${path-upload}")
    private String pathUpload;

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/product")
    public String index(Model model){
        List<Product> list = productService.getAll();
        model.addAttribute("list",list);
        return "admin/product/index";
    }
    @GetMapping("/add-new-product")
    public String add(Model model){
        Product product = new Product();
        product.setStatus(true);
        List<Category> listCategories = this.categoryService.getAll();
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("product",product);
        return "admin/product/add-new-product";
    }
    @PostMapping("/add-new-product")
    public String save(@ModelAttribute("product") Product product,@RequestParam("imageProduct") MultipartFile file){
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(pathUpload+fileName));
            // lưu tên file vào database
            product.setImage(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(this.productService.create(product)) {
            return "redirect:/admin/product";
        }else {
            return "admin/product/add-new-product";
        }
    }
    @GetMapping("/edit-product/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        Product product = this.productService.findById(id);
        List<Category> listCategories = this.categoryService.getAll();
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("product", product);
        return "admin/product/edit-product";
    }
    @PostMapping("/edit-product")
    public String update(@ModelAttribute("product") Product product){
        if(this.productService.update(product)) {
            return "redirect:/admin/product";
        }else {
            return "admin/product/add-new-product";
        }
    }
    @GetMapping("/delete-product/{id}")
    public String delete( @PathVariable("id") Long id){
        if(this.productService.delete(id)){
            return "redirect:/admin/product";
        }
        else {
            return "redirect:/admin/product";
        }

    }
}
