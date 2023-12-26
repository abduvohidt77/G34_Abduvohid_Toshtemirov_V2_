package service.impl;

import domain.Product;
import enums.ProductTypeEnum;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public Product addProduct(Product product) {
        PRODUCTS.add(product);
        return product;
    }

    @Override
    public void addNewType(Integer id, ProductTypeEnum typeEnum) {
        for (Product p : PRODUCTS) {
            if (p.getId().equals(id)) {
                p.setProductType(typeEnum);
            }
        }
        System.out.println("Something is going wrong, try again !");
    }

    @Override
    public void editType(Integer id, ProductTypeEnum typeEnum) {
        for (Product p : PRODUCTS) {
            if (p.getId().equals(id)) {
                p.setProductType(typeEnum);
            }
        }
        System.out.println("Something is going wrong, try again !");
    }

    @Override
    public void deleteProduct(Integer id) {
        for (Product p : PRODUCTS) {
            PRODUCTS.removeIf(product -> id.equals(p.getId()));
        }
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        for (Product p : PRODUCTS) {
            if(id.equals(p.getId())) {
                p.setProductType(product.getProductType());
                p.setProductName(product.getProductName());
            }
        }
    }

    @Override
    public void seeProductByType(String type) {
        List<String> TYPES = new ArrayList<>();
        for (ProductTypeEnum t : ProductTypeEnum.values()) {
            if(type.equalsIgnoreCase(t.toString())) {
                TYPES.add(type);
            }
        }
        System.out.println(TYPES);
    }

    @Override
    public String purchaseProduct(Integer id, Integer buyerID) {
        for (Product p : PRODUCTS) {
            if(p.getId().equals(id) && p.getOwnerID() == null) {
                p.setOwnerID(buyerID);
                System.out.println("Purchased succesfuelly !");
            }
        }
        return "Something is going wrong, try again later !";
    }

    @Override
    public void showAllProducts() {
        for (Product p : PRODUCTS) {
            System.out.println(p);
        }
    }
}
