package service;

import domain.Product;
import enums.ProductTypeEnum;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> PRODUCTS = new ArrayList<>();

    Product addProduct(Product product);
    void addNewType(Integer id, ProductTypeEnum typeEnum);
    void editType(Integer id, ProductTypeEnum typeEnum);
    void deleteProduct(Integer id);
    void updateProduct(Integer id, Product product);
    void seeProductByType(String type);
    String purchaseProduct(Integer id, Integer buyerID);
    void showAllProducts();
}
