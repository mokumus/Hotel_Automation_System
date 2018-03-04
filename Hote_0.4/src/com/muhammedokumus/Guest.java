package com.muhammedokumus;

import java.util.List;
import java.util.Map;

public class Guest extends User {

    private int stayingInRoomNumber;

    public Guest(){
        super();
        stayingInRoomNumber = 0;
    }
    public Guest(String guestID, String guestPassword){
        super(guestID,guestPassword);
    }

    public void setStayingInRoomNumber(int roomNo){
        stayingInRoomNumber = roomNo;
    }

    public void cancelReservation(List<Room> rooms){
        if(stayingInRoomNumber != 0){
            rooms.get(stayingInRoomNumber).setBooked(false);
        }
        stayingInRoomNumber = 0;

    }

    public void checkReservation(){

    }


}
