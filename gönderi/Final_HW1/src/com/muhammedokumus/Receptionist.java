package com.muhammedokumus;

import java.util.Map;

/**
 * Extended from User class, intended for employee use.
 */

class Receptionist extends User{



    public Receptionist(String receptionistID, String receptionistPassword){
        super(receptionistID, receptionistPassword);
    }



    public void checkInTheGuest(){

    }

    public void checkOutTheGuest(){

    }


    public void bookRoom(Map<Room,Guest> rooms, Room aRoom, Guest aGuest){
        if(rooms.putIfAbsent(aRoom,aGuest)== null){
            System.out.println("You booked room no: " + aRoom.getRoomNumber() + "!");
        }
        else{
            System.out.println("Room no: " + aRoom.getRoomNumber() + " is already booked!");
        }
    }

}
