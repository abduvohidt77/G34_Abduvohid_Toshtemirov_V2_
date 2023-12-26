package service.impl;

import domain.User;
import enums.UserRoleEnum;
import service.UserService;

public class UserServiceImpl implements UserService {
    static {
        User user = new User("Abduvohid", "A007", "007");
        user.setRole(UserRoleEnum.OWNER);
        USERS.add(user);
    }
    @Override
    public boolean login(String phoneNumber, String password) {
        for (User u : USERS) {
            if(phoneNumber.equalsIgnoreCase(u.getPhoneNumber())
                    && password.equalsIgnoreCase(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User register(User user) {
        if(isExistUser(user)) {
            return null;
        }
        USERS.add(user);
        return user;
    }

    private boolean isExistUser(User user) {
        for (User u : USERS) {
            if(user.getFullName().equalsIgnoreCase(u.getFullName())
                    && user.getPhoneNumber().equalsIgnoreCase(u.getPhoneNumber())
                    && user.getPassword().equalsIgnoreCase(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
