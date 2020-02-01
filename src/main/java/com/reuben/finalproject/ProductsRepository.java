package com.reuben.finalproject;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository <Products,Integer>{
        public Products findByName(String name);
}
