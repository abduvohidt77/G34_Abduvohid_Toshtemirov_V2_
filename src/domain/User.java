package domain;

import enums.UserRoleEnum;

import java.time.LocalDateTime;

public class User {
    private static int sequence = 0;

    {
        sequence++;
    }

    private Integer id = sequence;
    private String fullName;
    private String password;
    private String phoneNumber;
    private UserRoleEnum role;
    private LocalDateTime loggedAt;

    {
        role = UserRoleEnum.CUSTOMER;
        loggedAt = LocalDateTime.now();
    }

    public User() {
    }

    public User(String fullName, String password, String phoneNumber) {
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Full name - %s | password - %s | phone number - %s"
                .formatted(fullName, password, phoneNumber);
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        User.sequence = sequence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
