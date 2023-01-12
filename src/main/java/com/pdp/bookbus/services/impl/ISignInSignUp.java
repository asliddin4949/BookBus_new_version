package com.pdp.bookbus.services.impl;

import com.pdp.bookbus.model.Role;
import com.pdp.bookbus.model.User;
import com.pdp.bookbus.services.interfaces.SignInSignUp;
import com.pdp.bookbus.storage.Storage;

import java.math.BigDecimal;
import java.util.Scanner;

public class ISignInSignUp implements SignInSignUp {
    private static SignInSignUp signInSignUp;
    public static SignInSignUp getInstance(){
        if (signInSignUp==null){
            signInSignUp=new ISignInSignUp();
        }
        return signInSignUp;
    }
    @Override
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("User_Name: ");
            String userName = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            User user = Storage.userList.stream().filter(user1 ->
                            user1.getUsername().equals(userName) && user1.getPassword().equals(password))
                    .findFirst().orElse(null);
            if (user == null) {
                System.out.println("User_Name or Password is incorrect!");
                break;
            }else {
                if(user.getRole().equals(Role.ADMIN)){

                }
                if(user.getRole().equals(Role.DRIVER)){

                }
                if(user.getRole().equals(Role.USER)){

                }
            }
        }
    }

    @Override
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter User_Name: ");
            String userName = scanner.nextLine();
            User user = Storage.userList.stream().filter(user1 ->
                    user1.getPassword().equals(userName)).findFirst().orElse(null);
            if(user!=null){
                System.out.println("This User_Name is registered!");
            }else {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                User user1 = new User(User.getCurrentId(), name, userName, password, Role.USER, BigDecimal.ZERO, true);
                Storage.userList.add(user1);
                System.out.println("Registration completed successfully!");
                break;
            }
        }
    }
}
