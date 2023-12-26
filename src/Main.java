import domain.Product;
import domain.User;
import enums.ProductTypeEnum;
import service.ProductService;
import service.UserService;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scInt = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static ProductService productService = new ProductServiceImpl();

    public static void main(String[] args) {
        printHello();
        while (true) {
            printLogMenu();
            System.out.print("So what you gonna do? :");
            int put = scInt.nextInt();
            switch (put) {
                case 1 -> {
                    System.out.print("Enter your name : ");
                    String name = scStr.nextLine();
                    System.out.print("Enter your phone number : ");
                    String phone = scStr.nextLine();
                    System.out.print("Create a new password : ");
                    String password = scStr.nextLine();
                    User user = new User(name, password, phone);
                    var regUser = userService.register(user);
                    if (regUser != null) {
                        printUserMenu(regUser);
                    }
                    System.out.println("Something is going wrong try again !");
                } case 2 -> {
                    System.out.print("Enter your phone number : ");
                    String phoneNumber = scStr.nextLine();
                    System.out.print("Enter your password : ");
                    String password = scStr.nextLine();
                    var login = userService.login(phoneNumber, password);
                    if (login) {
                        printOwnerMenu();
                    }
                    System.out.println("Something is gone wrong ! ");
                } default -> System.out.println("Enter only given numbers : ");
            }
        }
    }

    private static void printOwnerMenu() {
        while (true) {
            printOwnerUses();
            System.out.print("What you gonna do? : ");
            int put = scInt.nextInt();
            switch (put) {
                case 1 -> {
                    productService.showAllProducts();
                    System.out.print("Enter a id of product : ");
                    int id = scInt.nextInt();
                    ProductTypeEnum.showAllTypes();
                    System.out.print("Enter a index to set type : ");
                    int index = scInt.nextInt();
                    productService.addNewType(id, ProductTypeEnum.setProductTypeByIndex(index));
                    System.out.println("Succeesfuelly !");
                } case 2 -> {
                    productService.showAllProducts();
                    System.out.print("Enter a id of product : ");
                    int id = scInt.nextInt();
                    ProductTypeEnum.showAllTypes();
                    System.out.print("Enter a index to set type : ");
                    int index = scInt.nextInt();
                    productService.editType(id, ProductTypeEnum.setProductTypeByIndex(index));
                    System.out.println("Succeesfuelly !");
                } case 3 -> {
                    System.out.print("Enter a product name :");
                    String name = scStr.nextLine();
                    ProductTypeEnum.showAllTypes();
                    System.out.print("Enter an index to set a new type : ");
                    int index = scInt.nextInt();
                    Product product = new Product(name, ProductTypeEnum.setProductTypeByIndex(index));
                    productService.addProduct(product);
                } case 4 -> {
                    productService.showAllProducts();
                    System.out.print("Enter a product id to delete it : ");
                    int id = scInt.nextInt();
                    productService.deleteProduct(id);
                } case 5 -> {
                    productService.showAllProducts();
                    System.out.print("Enter an id of product to update : ");
                    int id = scInt.nextInt();
                    System.out.print("Enter a product name : ");
                    String name = scStr.nextLine();
                    ProductTypeEnum.showAllTypes();
                    System.out.print("Enter an index to set type : ");
                    int index = scInt.nextInt();
                    Product product = new Product(name, ProductTypeEnum.setProductTypeByIndex(index));
                    productService.updateProduct(id, product);
                }
                default -> System.out.println("Enter only given menu's numbers.");
            }
        }
    }

    private static void printOwnerUses() {
        System.out.println("""
                |=== Owner Menu ===|
                1.Set type
                2.Edit type
                3.Add product
                4.Delete Product
                5.Edit product
                
                0.Back to Register menu
                |=================|
                """);
    }

    private static void printUserMenu(User loggedUser) {
        while (true) {
            printCustomerMenu();
            System.out.print("What you gonna do? : ");
            int put = scInt.nextInt();
            if (put == 0) break;
            switch (put) {
                case 1 -> {
                    ProductTypeEnum.showAllTypes();
                    System.out.print("Enter a type name to see products by this type : ");
                    String type = scStr.nextLine();
                    productService.seeProductByType(type);
                } case 2 -> {
                    productService.showAllProducts();
                    System.out.print("Enter an id of product to buy : ");
                    int id = scInt.nextInt();
                    productService.purchaseProduct(id, loggedUser.getId());
                } default -> System.out.println("Enter given numbers in menu !");
            }
        }
    }
    private static void printCustomerMenu() {
        System.out.println("""
                |=== Customer Menu ===|
                                
                1.See all products by type
                2.Purchase product
                                
                0.Back to register menu
                                
                |====================|
                """);
    }

    private static void printLogMenu() {
        System.out.println("""
                |==== Log/Reg Menu ===|
                                
                1.Register
                2.Login(if you have an account)
                                
                0.Exit
                |=====================|
                """);
    }

    private static void printHello() {
        System.out.println("Welcome to our Online Shop !");
    }
}