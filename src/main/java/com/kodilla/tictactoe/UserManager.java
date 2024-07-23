package com.kodilla.tictactoe;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private int idLoggedUser;
    private List<User> users;
    private FileWithUsers fileWithUsers;
    private UserStatistics userStatistics;

    public UserManager(String nameOfFileWithUser, String nameOfFileWithUserStatistics) {
        fileWithUsers = new FileWithUsers(nameOfFileWithUser);
       this.users = fileWithUsers.loadUsersFromFile();
       this.idLoggedUser = 0;
       userStatistics = new UserStatistics(nameOfFileWithUserStatistics);
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
            userId = users.getLast().getUserId()+1;
        }
        String generatedHashedPassword = generateHashedPassword(password);

        User newUser = new User(userId, login, generatedHashedPassword, userName, userLastName);

        users.add(newUser);

        for(User user : users){
            System.out.println(user.toString());
        }

        fileWithUsers.saveAllUsersToTheFile(users);
    }
    public void userLogIn(){
        Scanner input = new Scanner(System.in);
        String login,password;
        System.out.println("Please provide your login");
        login = input.nextLine();
        int i=0;
        int sizeUsers = users.size();
        while(i<sizeUsers){
            if(users.get(i).getLogin().equals(login)){
                for(int attempts = 0; attempts < 3; attempts++){
                    System.out.println("Please enter your password. You have "+ (3-attempts)+" atempts");
                    password = input.nextLine();
                    String hashedPassword = generateHashedPassword(password);
                    if(users.get(i).getPassword().equals(hashedPassword)){
                        System.out.println("You have logged in\n");
                        idLoggedUser = users.get(i).getUserId();
                        userStatistics.setUserId(idLoggedUser);
                        userStatistics.loadUserStatistics();
                        return;
                    }
                }
                System.out.println("You entered 3 times wrong password. Get back to main menu");
            }
            i++;
        }
        System.out.println("There is no user with this login");
    }

    private String generateHashedPassword(String password){
        String generatedPassword = null;
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bytes.length; j++) {
                sb.append(Integer.toString((bytes[j] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public void showUserStatistics() {
        String show = "Played: "+userStatistics.getHowManyPlayed()+"\n"+
                "Won: "+userStatistics.getHowManyWins()+"\n"+
                "Lost: "+userStatistics.getHowManyLoses()+"\n"+
                "Draw: "+userStatistics.getHowManyDraws()+"\n";
        System.out.println(show);

    }

    public void increaseNumberOfWins() {
        userStatistics.setHowManyPlayed(userStatistics.getHowManyPlayed()+1);
        userStatistics.setHowManyWins(userStatistics.getHowManyWins()+1);
    }

    public void increaseNumberOfLoses() {
        userStatistics.setHowManyPlayed(userStatistics.getHowManyPlayed()+1);
        userStatistics.setHowManyLoses(userStatistics.getHowManyLoses()+1);
    }
    public void increaseNumberOfDraws() {
        userStatistics.setHowManyPlayed(userStatistics.getHowManyPlayed()+1);
        userStatistics.setHowManyDraws(userStatistics.getHowManyDraws()+1);
    }

    public void saveUserStatisticsToFile() {
        userStatistics.saveUserStatisticsToFile(userStatistics.toString());
    }
}

