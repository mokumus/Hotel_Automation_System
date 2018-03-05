package com.muhammedokumus;


import java.util.Map;

/**
 * Holds basic user methods and data.
 */
abstract class User implements UserInterface {

    final String userID;
    final String userPassword;

    User(){
        this.userID = null;
        this.userPassword = null;
    }

    User(String userID, String userPassword){
        this.userID = userID;
        this.userPassword = userPassword;
    }

    /**
     * @return
     * Returns ID of the calling User object.
     */
    public String getUserID(){
        return userID;
    }

    /**
     * @return
     * Returns password of the calling User object.
     */
    protected String getPassword(){
        return userPassword;
    }

    /**
     * Takes Map of rooms(aka logbook for hotel), if the target room  (Room aRoom) is available marks it a reserved,
     * and marks guest (Guest aGuest) for that room number.
     * @param rooms
     * @param aRoom
     * @param aGuest
     */
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
