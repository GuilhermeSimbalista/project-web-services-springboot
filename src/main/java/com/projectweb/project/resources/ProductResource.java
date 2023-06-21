package com.projectweb.project.resources;

import com.projectweb.project.entities.Product;
import com.projectweb.project.repositories.ProductRepository;
import com.projectweb.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Metodo para encontrar produto passando um filtro como nome ou id ou cpf

    @GetMapping
    public List<Product> find ( Product filtro) {
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Product> example = Example.of(filtro, matcher);
        return productRepository.findAll(example);

    }
}
