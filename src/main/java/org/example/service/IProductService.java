package org.example.service;

import org.example.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;

    public void save(Product product);
}
