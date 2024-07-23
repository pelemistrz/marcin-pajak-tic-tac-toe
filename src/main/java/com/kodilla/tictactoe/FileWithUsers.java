package com.kodilla.tictactoe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWithUsers {
    private final String NAME_OF_FILE_WITH_USERS;

    public FileWithUsers(String NAME_OF_FILE_WITH_USERS) {
        this.NAME_OF_FILE_WITH_USERS = NAME_OF_FILE_WITH_USERS;
    }

    public void saveAllUsersToTheFile(List<User> users) {
        File saveFile = new File(NAME_OF_FILE_WITH_USERS);

        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(saveFile));
            oos.writeObject(users);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> loadUsersFromFile() {
        File loadFile = new File(NAME_OF_FILE_WITH_USERS);
        List<User> users = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadFile));
            Object readArray = ois.readObject();
            if(readArray instanceof List<?>) {
                List<User> userList = (List<User>) readArray;
                users.addAll(new ArrayList<>(userList));
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for(User user: users){
            System.out.println(user.toString());
        }

        return users;
    }
}
