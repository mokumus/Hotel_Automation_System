package com.muhammedokumus;

import java.util.Map;
/**
 * Short interface for User, Guest and Receptionist classes
 */
interface UserInterface {
    String getUserID();

    void bookRoom(Map<Room,Guest> rooms, Room aRoom, Guest aGuest);
}


