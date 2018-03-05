package com.muhammedokumus;

/**
 * Main class for hard coded tests.
 */
class Main {

    public static void main(String[] args){
        int fails = 0;
        ManagementSystem hotel = new ManagementSystem();
        hotel.initUsers("Files/users.csv");
        hotel.initRooms("Files/rooms.csv");


        String ID = "user3";
        String pass = "333";


        Pair<User,Integer> scRes = hotel.loginUser(ID,pass);

        while(scRes.getValue() == 0){
            fails++;
            if(fails < 2){
                scRes = hotel.loginUser(ID,pass);
            }
            else if(fails >= 2){
                System.out.println("Too many failed attempts.");
                System.exit(0);
            }
        }
        if(scRes.getValue() == 1){
            hotel.guestLogged((Guest) scRes.getKey());
            //interface for guest
        }
        else if(scRes.getValue() == 2){
            //interface for receptionist
        }
    }
}
/*
    void testLoginUser() {
        ManagementSystem hotel = new ManagementSystem();
        hotel.initUsers("Files/users.csv");
        hotel.initRooms("Files/rooms.csv");

        String testID = "WrongName";
        String testPass = "Wrong Password";

        Pair<User,Integer> scRes = hotel.loginUser(testID,testPass);

        System.out.println("Expected: " + scRes.getKey() + "Actual: " + null);


        String rightID = "user1";
        String wrongPass = "123";
        String rightPass = "111";

        scRes = hotel.loginUser(rightID,wrongPass);

        //assertEquals(scRes.getKey(),null)

        scRes = hotel.loginUser(rightID,rightPass);

        //assertEquals(scRes.getValue(), 1);
    }
*/