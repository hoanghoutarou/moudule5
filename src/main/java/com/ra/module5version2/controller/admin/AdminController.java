package com.ra.module5version2.controller.admin;

import com.ra.module5version2.model.entity.Product;
import com.ra.module5version2.model.entity.Role;
import com.ra.module5version2.model.entity.User;
import com.ra.module5version2.service.User.Role.RoleService;
import com.ra.module5version2.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String index() {
        return "redirect:/admin/";
    }

    @GetMapping("/")
    public String admin(){
        return "admin/index";
    }
    @GetMapping("/all-users")
    public String indexUser(Model model){
        List<User> list = userService.getAll();
        List<Role> listRoles = roleService.getAll();
        model.addAttribute("role", listRoles);
        model.addAttribute("list",list);
        return "admin/user/all-users";
    }
    @GetMapping("/delete-user/{id}")
    public String delete( @PathVariable("id") Long id){
        if(this.userService.delete(id)){
            return "redirect:/admin/all-users";
        }
        else {
            return "redirect:/admin/all-users";
        }

    }
}
