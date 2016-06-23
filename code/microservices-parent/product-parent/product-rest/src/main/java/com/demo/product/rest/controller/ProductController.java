package com.demo.product.rest.controller;

import com.demo.product.domain.entity.Product;
import com.demo.product.domain.repository.ProductRepository;
import com.demo.product.rest.constant.ApiConstants;
import com.shedhack.thread.context.annotation.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imamchishty on 23/06/2016.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @ThreadContext // writes to the xxx-audit.log
    @RequestMapping(path = ApiConstants.API_PRODUCT + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> get(@PathVariable("id") long id){
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

}
