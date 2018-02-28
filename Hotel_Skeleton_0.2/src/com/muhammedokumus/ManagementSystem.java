package com.muhammedokumus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementSystem {

    List<User> users = new ArrayList<>();
    Map<Guest, Room> rooms = new HashMap<>();

    public void initilizeUsers(String filename){
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {


                String[] temp = line.split(",");

                if(temp[2].equals("G")){
                    users.add(new Guest(temp[0],temp[1]));
                }
                else if(temp[2].equals("R")){
                    users.add(new Receptionist(temp[0],temp[1]));
                }
                else{
                    System.out.println("User data file format is wrong!");
                    //System.exit(0);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found. Please check Files folder under project for users.csv");
        } catch (IOException e) {
            System.out.println("User data could not be loaded. File format is wrong/corrupted.");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(users);
    }


}
