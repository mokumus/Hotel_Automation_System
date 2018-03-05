package com.muhammedokumus;

/**
 * Holds room information.
 */
class Room {
    private final int roomNumber;
    private boolean isBooked;

    public Room(int roomNumber, boolean isBooked){
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
    }

    public Room(int roomNumber, String isBooked){

        this.roomNumber = roomNumber;
        this.isBooked =  isBooked.equals("empty") ? false:true;
    }

    /**
     * @return
     * Returns the calling objects room number.
     */
    public int getRoomNumber(){
        return roomNumber;
    }

    /**
     * Sets the calling objects availability to true or false according to boolean parameter.
     * @param yesOrNo
     */
    public void setBooked(boolean yesOrNo){
        isBooked = yesOrNo;
    }

    @Override
    public String toString(){
        String temp = "";
        temp = (isBooked) ? "Booked" : "Available";
        return "Room " + roomNumber + ": " + temp;
    }

}
