package com.muhammedokumus

import javafx.util.Pair

class ManagementSystemTest extends groovy.util.GroovyTestCase {


    void testLoginUser() {
        ManagementSystem hotel = new ManagementSystem();
        hotel.initUsers("Files/users.csv");
        hotel.initRooms("Files/rooms.csv");

        String testID = "WrongName";
        String testPass = "Wrong Password";

        Pair<User,Integer> scRes = hotel.loginUser(testID,testPass);

        assertEquals(scRes.getKey(),null)

        String rightID = "user1";
        String wrongPass = "123";
        String rightPass = "111";

        scRes = hotel.loginUser(rightID,wrongPass);

        assertEquals(scRes.getKey(),null)

        scRes = hotel.loginUser(rightID,rightPass);

        assertEquals(scRes.getValue(), 1);

    }


}
