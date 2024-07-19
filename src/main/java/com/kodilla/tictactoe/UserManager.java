package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private int idLoggedUser;
    private ArrayList<User> users;
    private FileWithUsers fileWithUsers;

    public UserManager(String nameOfFileWithUser) {
        fileWithUsers = new FileWithUsers(nameOfFileWithUser);
       this.users = fileWithUsers.loadUsersFromFile();
       this.idLoggedUser = 0;
    }
    public int getIdLoggedUser() {
        return idLoggedUser;
    }
    public void userRegistration(){
        Scanner input = new Scanner(System.in);
        String login, password, userName, userLastName;
        System.out.println("Please enter your name");
        userName = input.nextLine();
        System.out.println("Please enter your surname");
        userLastName = input.nextLine();
        System.out.println("Please enter your login");
        login = input.nextLine();

        int i = 0;
        int sizeUsers = users.size();

        while(i<sizeUsers){
            if(users.get(i).getLogin().equals(login)){
                System.out.println("This login exist.Please choose another one");
                login = input.nextLine();
                i=0;
            } else{
                i++;
            }
        }
        System.out.println("Please enter your password");
        password = input.nextLine();

        int userId;
        if(users.isEmpty()){
            userId = 1;
        } else {
            userId = users.get(users.size()-1).getUserId()+1;
        }
        User newUser = new User(userId, login, password, userName, userLastName);
        users.add(newUser);

        for(User user : users){
            System.out.println(user.toString());
        }

        fileWithUsers.saveAllUsersToTheFile(users);

    }
    public void userLogIn(){

    }




}
