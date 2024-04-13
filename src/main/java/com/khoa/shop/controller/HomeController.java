package com.khoa.shop.controller;

import com.khoa.shop.entity.ProductEntity;
import com.khoa.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class HomeController {

    @Autowired
    ProductService service;

    //all product
    private String getAllProduct(Model model){
        List<ProductEntity> product = service.getAllProduct();
        return "";
    }



}
