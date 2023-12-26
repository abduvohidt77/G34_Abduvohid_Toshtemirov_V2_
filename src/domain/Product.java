package domain;

import enums.ProductTypeEnum;

public class Product {
    private static int sequence = 0;
    {
        sequence++;
    }
    private Integer id = sequence;
    private String productName;
    private Integer ownerID;
    private ProductTypeEnum productType;
    {
        ownerID = null;
    }

    public Product() {
    }

    public Product(String productName, ProductTypeEnum productType) {
        this.productName = productName;
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Id - %s | Product name - %s | owner id - %s | product type - %s"
                .formatted(id, productName, ownerID, productType);
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductTypeEnum getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeEnum productType) {
        this.productType = productType;
    }
}
