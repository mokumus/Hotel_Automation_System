package com.muhammedokumus;


import java.util.Map;

public abstract class User implements UserInterface {

    protected String userID;
    protected String userPassword;

    public User(){
        this.userID = null;
        this.userPassword = null;
    }

    public User(String userID, String userPassword){
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID(){
        return userID;
    }

    protected String getPassword(){
        return userPassword;
    }


    public void bookRoom(Map<Room,Guest> rooms, Room aRoom, Guest aGuest){
        if(rooms.putIfAbsent(aRoom,aGuest)== null){
            System.out.println("You booked room no: " + aRoom.getRoomNumber() + "!");
        }
        else{
            System.out.println("Room no: " + aRoom.getRoomNumber() + " is already booked!");
        }
    }


    @Override
    public String toString(){
        return userID + " = " + userPassword;
    }



}
