package com.muhammedokumus;

import java.util.Map;

public interface UserInterface {
    String getUserID();

    void bookRoom(Map<Room,Guest> rooms, Room aRoom, Guest aGuest);
}


