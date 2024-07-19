package com.kodilla.tictactoe;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileWithUsers {
    private final String NAME_OF_FILE_WITH_USERS;

    public FileWithUsers(String NAME_OF_FILE_WITH_USERS) {
        this.NAME_OF_FILE_WITH_USERS = NAME_OF_FILE_WITH_USERS;
    }

    public void saveAllUsersToTheFile(ArrayList<User> users) {
        File saveFile = new File(NAME_OF_FILE_WITH_USERS);

        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(saveFile));
            oos.writeObject(users);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<User>  loadUsersFromFile() {
        File loadFile = new File(NAME_OF_FILE_WITH_USERS);
        ArrayList<User> users = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadFile));
            Object readArray = ois.readObject();
            if(readArray instanceof ArrayList<?>) {
                users.addAll((ArrayList) readArray);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

//    public void addUserToTheFile(User user) {
//        Path path = Paths.get("e:/"+NAME_OF_FILE_WITH_USERS);
//        String userString = user.toString();
//        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {
//            writer.append(userString);
//        } catch (IOException e) {
//            System.out.println("Error has happened " + e);
//        }
//    }
}
