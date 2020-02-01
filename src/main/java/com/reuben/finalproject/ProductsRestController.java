package com.reuben.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsRestController {
    private PageCounter pageCounter;
    @Autowired
    public  ProductsRestController(PageCounter pageCounter){
        this.pageCounter = pageCounter;
    }
    @GetMapping("/currentcount")
    public String getPageCount(){
        return pageCounter.getPageCount().toString();
    }

}
