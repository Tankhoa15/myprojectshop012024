package com.khoa.shop.controller;

import com.khoa.shop.entity.ProductEntity;
import com.khoa.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/product/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public String hienThi(Model model){
        List<ProductEntity> products = productService.getAll();
        model.addAttribute("products",products);
        return "views/product";
    }

    @GetMapping("view-create")
    public String viewCreate(){
        return "views/create";
    }

    @PostMapping("add")
    public String create(@ModelAttribute("product") ProductEntity product, Model model, BindingResult result){
        if (result.hasErrors()){
            return "views/create";
        }
        productService.create(product);
        List<ProductEntity> products = productService.getAll();
        model.addAttribute("products",products);
        return "redirect:/product/products";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Long id,Model model){
        ProductEntity product = productService.findById(id);
        model.addAttribute("product",product);
        return "views/update";
    }

    @PostMapping("update")
    public String update( @ModelAttribute("product") ProductEntity product, Model model, BindingResult result){
        if (result.hasErrors()){
            return "views/update";
        }
        List<ProductEntity> products = productService.getAll();
        model.addAttribute("products",products);
        productService.update(product);
        return "redirect:/product/products";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        productService.delete(id);
        return "redirect:/product/products";
    }
}
