package com.reuben.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProductsController {
    private  ProductsRepository productsRepository;
    private PageCounter pageCounter;

    @Autowired
    public  ProductsController(ProductsRepository productsRepository, PageCounter pageCounter){
        this.productsRepository = productsRepository;
        this.pageCounter = pageCounter;
    }
    @GetMapping(path = "/addproduct")
    public String addProductTemplate(Model model){
        model.addAttribute("products",new Products());
        pageCounter.increamentPageCounter();
        return  "addproducts";
    }


    @GetMapping(path = "/")
    public  String getProducts(
            @RequestParam(value = "name",required = false) Optional<String> name,
            Model model){

        List<Products> products =new ArrayList<>();
        this.productsRepository.findAll().forEach(products::add);
        if(name.isPresent()){
            products = products.stream().filter(x->x.getName().contains(name.get())).collect(Collectors.toList());
        }
        model.addAttribute("products", products);
        pageCounter.increamentPageCounter();
        return "productslist";
    }

    @PostMapping(path="/add/product")
    public String addProduct(@Valid @ModelAttribute Products products, BindingResult bindingResult){
        System.out.println(bindingResult);
        if(bindingResult.hasErrors()){
            return "addproducts";
        }
        this.productsRepository.save(products);
        pageCounter.increamentPageCounter();
        return "successproducts";
    }
}
