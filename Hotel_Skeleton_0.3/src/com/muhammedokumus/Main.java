package com.muhammedokumus;




public class Main {

    public static void main(String[] args){
        ManagementSystem hotel = new ManagementSystem();
        hotel.initUsers("Files/users.csv");
        hotel.initRooms("Files/rooms.csv");
        hotel.loginUser("user1","111");
        hotel.loginUser("use333","111");
        hotel.loginUser("user1","112");
    }
}
