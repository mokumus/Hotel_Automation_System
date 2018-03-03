package com.muhammedokumus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementSystem {

    private List<User> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private Map<Guest, Room> booked = new HashMap<>();


    public void initUsers(String filename){
        CSVReader usersFile = new CSVReader();
        List<String[]> rawUserData = new ArrayList<>();

        rawUserData = usersFile.csvFileToRowsOfStrings(filename);

        for (String[] item : rawUserData) {
            if(item[2].equals("G")){
                users.add(new Guest(item[0],item[1]));
            }
            else if(item[2].equals("R")){
                users.add(new Receptionist(item[0],item[1]));
            }
        }
    }

    public void initRooms(String filename){
        CSVReader roomsFile = new CSVReader();
        List<String[]> rawRoomData = new ArrayList<>();

        rawRoomData = roomsFile.csvFileToRowsOfStrings(filename);

        for (String[] item : rawRoomData) {
            rooms.add(new Room(Integer.parseInt(item[0]),item[1]));
        }
    }

    public void loginUser(String userName, String password){
        for (User user : users) {
            if(user.userID.equals(userName) && user.userPassword.equals(password)) {
                System.out.println("Logged in " + user);

                return;
            }
        }
        System.out.println("Wrong username or password.");
    }



}
