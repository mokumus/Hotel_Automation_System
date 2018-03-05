package com.muhammedokumus;

import java.util.List;

/**
 * Extended from User class, intended for customer use.
 */
class Guest extends User {

    private int stayingInRoomNumber;

    public Guest(){
        super();
        stayingInRoomNumber = 0;
    }
    public Guest(String guestID, String guestPassword){
        super(guestID,guestPassword);
    }


    public void setStayingInRoomNumber(int roomNo){
        stayingInRoomNumber = roomNo + 1;
    }

    public void cancelReservation(List<Room> rooms){
        if(stayingInRoomNumber != 0){
            rooms.get(stayingInRoomNumber - 1).setBooked(false);
            System.out.println("Canceled reservation in room: " + rooms.get(stayingInRoomNumber-1).getRoomNumber() + ".");
        }
        else{
            System.out.println("No reservations found.");
        }
        stayingInRoomNumber = 0;
    }
}
