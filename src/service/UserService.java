package service;

import domain.Product;
import domain.User;
import enums.ProductTypeEnum;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<User> USERS = new ArrayList<>();

    boolean login(String phoneNumber, String password);
    User register(User user);
}
