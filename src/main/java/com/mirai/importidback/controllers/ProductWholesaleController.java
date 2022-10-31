package com.mirai.importidback.controllers;


import com.mirai.importidback.entities.DomesticShipment;
import com.mirai.importidback.entities.ProductWholesale;
import com.mirai.importidback.services.IProductWholesaleService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productWholesale")
@CrossOrigin(origins="http://localhost:4200/")
@Api(tags = "productWholesale", value="Web Services of product wholesale")
public class ProductWholesaleController {

    private IProductWholesaleService productWholesaleService;

    public ProductWholesaleController(IProductWholesaleService productWholesaleService) {
        this.productWholesaleService = productWholesaleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductWholesale>> findAll(){
        try {
            List<ProductWholesale> productWholesale= productWholesaleService.getAll();
            if(productWholesale.size()>0)
                return new ResponseEntity<>(productWholesale, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductWholesale> findById(@PathVariable("id")Long id){
        try{
            Optional<ProductWholesale> productWholesale=productWholesaleService.getById(id);
            if(!productWholesale.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(productWholesale.get(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductWholesale> insertProductWholesale(@Valid @RequestBody ProductWholesale productWholesale){
        try{
            ProductWholesale productWholesaleNew= productWholesaleService.save(productWholesale);
            return ResponseEntity.status(HttpStatus.CREATED).body(productWholesaleNew);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductWholesale> updateProductWholesale(@PathVariable("id")Long id,@Valid @RequestBody ProductWholesale productWholesale){
        try{
            Optional<ProductWholesale> productWholesaleUpdate= productWholesaleService.getById(id);
            if(!productWholesaleUpdate.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            productWholesale.setId(id);
            productWholesaleService.save(productWholesale);
            return new ResponseEntity<>(productWholesale,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductWholesale> deleteDomesticShipment(@PathVariable("id")Long id){
        try{
            Optional<ProductWholesale> productWholesaleDelete=productWholesaleService.getById(id);
            if(!productWholesaleDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            productWholesaleService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
