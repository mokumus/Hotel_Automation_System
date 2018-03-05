package com.muhammedokumus;


import javafx.util.Pair;
/**
 * Main class for hard coded tests.
 */
class Main {

    public static void main(String[] args){
        int fails = 0;
        ManagementSystem hotel = new ManagementSystem();
        hotel.initUsers("Files/users.csv");
        hotel.initRooms("Files/rooms.csv");


        String ID = "user3";
        String pass = "333";


        Pair<User,Integer> scRes = hotel.loginUser(ID,pass);

        while(scRes.getValue() == 0){
            fails++;
            if(fails < 2){
                scRes = hotel.loginUser(ID,pass);
            }
            else if(fails >= 2){
                System.out.println("Too many failed attempts.");
                System.exit(0);
            }
        }
        if(scRes.getValue() == 1){
            hotel.guestLogged((Guest) scRes.getKey());
            //interface for guest
        }
        else if(scRes.getValue() == 2){
            //interface for receptionist
        }

    }
}
