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

    @Override
    public String toString(){
        String temp = new String();
        temp = (isBooked == true) ? "Booked" : "Available";
        return "Room " + roomNumber + ", " + temp;
    }

}
