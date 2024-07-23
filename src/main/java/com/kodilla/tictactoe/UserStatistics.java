package com.kodilla.tictactoe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserStatistics {
    int userId;
    int howManyPlayed=0;
    int howManyWins=0;
    int howManyLoses=0;
    int howManyDraws=0;
    private final String NAME_OF_FILE_WITH_STATISTICS;

    public UserStatistics( String NAME_OF_FILE_WITH_STATISTICS) {
        this.NAME_OF_FILE_WITH_STATISTICS = NAME_OF_FILE_WITH_STATISTICS;

    }

    public void loadUserStatistics(){

        Path path = Paths.get("e:/"+NAME_OF_FILE_WITH_STATISTICS);

        try (Stream<String> stream = Files.lines(path)) {

            stream.forEach(userStatistics -> {
                String[] split = userStatistics.split(";");
                if(split[0].equals(String.valueOf(userId))){
                    setHowManyPlayed(Integer.parseInt(split[1]));
                    setHowManyWins(Integer.parseInt(split[2]));
                    setHowManyLoses(Integer.parseInt(split[3]));
                    setHowManyDraws(Integer.parseInt(split[4]));
                }
            });

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public void saveUserStatisticsToFile(String userStatisticsString) {
        Path path = Paths.get("e:/"+NAME_OF_FILE_WITH_STATISTICS);

       try{
           List<String> usersStatistics = Files.lines(path)
                   .filter(line -> {
                       String[] split = line.split(";");
                       if(split[0].equals(String.valueOf(userId))){
                           return false;
                       }
                       return true;
                   })
                   .collect(Collectors.toList());
           try{
               Files.write(path, usersStatistics, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
           } catch (IOException e){
               System.out.println("Error: " + e);
           }
       } catch (IOException e){
           System.out.println("Error: " + e);
       }


        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.append(userStatisticsString);
        } catch (IOException e) {
            System.out.println("Error has happened " + e);
        }
    }

    @Override
    public String toString() {
        return ""+userId +";"+ howManyPlayed +";"+
                 howManyWins +";"+
                 howManyLoses +";"+
                 howManyDraws +"\n";

    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHowManyPlayed() {
        return howManyPlayed;
    }
    public void setHowManyPlayed(int howManyPlayed) {
        this.howManyPlayed = howManyPlayed;
    }

    public int getHowManyWins() {
        return howManyWins;
    }

    public void setHowManyWins(int howManyWins) {
        this.howManyWins = howManyWins;
    }

    public int getHowManyLoses() {
        return howManyLoses;
    }

    public void setHowManyLoses(int howManyLoses) {
        this.howManyLoses = howManyLoses;
    }

    public int getHowManyDraws() {
        return howManyDraws;
    }

    public void setHowManyDraws(int howManyDraws) {
        this.howManyDraws = howManyDraws;
    }
}
