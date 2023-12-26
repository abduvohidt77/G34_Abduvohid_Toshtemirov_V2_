package enums;

public enum ProductTypeEnum {
    TECHNIC_TECHNOLOGY(1),
    FOOD(2),
    JEWELLERY(3),
    TOYS(4),
    CLOTHES(5);
    private final int index;

    ProductTypeEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static void showAllTypes() {
        for (ProductTypeEnum p:ProductTypeEnum.values()) {
            System.out.println(p.getIndex() + ". " + p.name());
        }
    }
    public static ProductTypeEnum setProductTypeByIndex(int index) {
        for (ProductTypeEnum p : ProductTypeEnum.values()) {
            if(index == p.getIndex()) return p;
        }
        return CLOTHES;
    }
}
