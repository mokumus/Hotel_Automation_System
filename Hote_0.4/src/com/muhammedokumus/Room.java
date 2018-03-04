package com.muhammedokumus;

public class Room {
    private int roomNumber;
    private boolean isBooked;

    public Room(int roomNumber, boolean isBooked){
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
    }

    public Room(int roomNumber, String isBooked){

        this.roomNumber = roomNumber;
        this.isBooked =  isBooked.equals("empty") ? false:true;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public void setBooked(boolean yesOrNo){
        isBooked = yesOrNo;
    }

    @Override
    public String toString(){
        String temp = new String();
        temp = (isBooked == true) ? "Booked" : "Available";
        return "Room " + roomNumber + ": " + temp;
    }

}
