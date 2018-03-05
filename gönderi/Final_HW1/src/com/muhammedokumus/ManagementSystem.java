package com.muhammedokumus;



import java.util.*;

/**
 * Action handler class for Guest and Receptionist
 */
class ManagementSystem {

    private final List<User> users = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();
    private final Map<Room, Guest> booked = new HashMap<>();

    /**
     * Takes an input file of users as an adress,  fills users array with Guest and Receptionist objects.
     * @param filename
     */
    public void initUsers(String filename){
        CSVReader usersFile = new CSVReader();
        List<String[]> rawUserData;

        rawUserData = usersFile.csvFileToRowsOfStrings(filename);

        for (String[] item : rawUserData) {
            if(item[2].equals("G")){
                users.add(new Guest(item[0],item[1]));
            }
            else if(item[2].equals("R")){
                users.add(new Receptionist(item[0],item[1]));
            }
        }
    }

    /**
     * Takes an input file of books as an adress, fills rooms array with Room objects.
     * @param filename
     */
    public void initRooms(String filename){
        CSVReader roomsFile = new CSVReader();
        List<String[]> rawRoomData;

        rawRoomData = roomsFile.csvFileToRowsOfStrings(filename);

        for (String[] item : rawRoomData) {
            rooms.add(new Room(Integer.parseInt(item[0]),item[1]));
        }
    }

    /**
     * Takes an User objects, prints message according to type of User(Guest or Receptionist).
     * @param aUser
     */
    private void welcomeMessage(User aUser){
        if(aUser instanceof Guest){
            System.out.print("Welcome, " + aUser.getUserID() + ".\n" +
                    "1-> Book a room.\n" +
                    "2-> Cancel reservation.\n" +
                    "3-> Log out.\n" +
                    ">");
        }
        else if(aUser instanceof Receptionist){
            System.out.print("Welcome, " + aUser.getUserID() + ".\n" +
                    "1-> Book a room.\n" +
                    "2-> Check in a guest.\n" +
                    "3-> Check out a guest.\n" +
                    "4-> Log out.\n" +
                    ">");
        }
    }

    /**
     * Takes userName and password as String, check if user is registered and has entered to correct combination.
     * @param userName
     * @param password
     * @return
     * On succesful login returns Pair(LoggedUser,Int), key value is required to pass tpe of the user to other methods.
     * On fail returns Pair(null,0).
     */
    public Pair loginUser(String userName, String password){
        for (User user : users) {
            if(user.userID.equals(userName) && user.userPassword.equals(password)) {
                if(user instanceof  Guest){
                    welcomeMessage(user);
                    return new Pair(user,1);
                }
                else if(user instanceof  Receptionist){
                    welcomeMessage(user);
                    return new Pair(user,2);
                }
            }
        }
        System.out.println("Wrong username or password.");
        return new Pair(null,0);
    }

    /**
     * guestLogged function takes a Guest object type parameter. Shows the methods which user can do, handles input flow.
     * Exits if the requested method number does not exists.
     * @param aGuest
     */
    public void guestLogged(Guest aGuest){
        Scanner sc = new Scanner(System.in);
        int i =  sc.nextInt();
        while(i <= 2 && i >= 1){
            switch (i){
                case 1:
                    System.out.print("Available rooms: " + rooms + "\nWhich room would you like to stay in?\n>");
                    int wantsNo = sc.nextInt();
                    while(wantsNo > rooms.size()){//RANGE CHECK
                        System.out.println("Room: " + wantsNo +" not found, please check room number.");
                        wantsNo = sc.nextInt();
                    }
                    aGuest.bookRoom(booked, rooms.get(wantsNo - 1), aGuest);
                    aGuest.setStayingInRoomNumber(wantsNo - 1); //UPDATE GUEST STATUS
                    rooms.get(wantsNo-1).setBooked(true); // UPDATE ROOM STATUS
                    break;
                case 2:
                    aGuest.cancelReservation(rooms); break;
                default:
                    System.out.println("Logging out.");
                    //IMPLEMENT METHOD THE SAVE NEW DATA
                    System.exit(1);
            }
            System.out.print(
                    "1-> Book a room.\n" +
                            "2-> Cancel reservation.\n" +
                            "3-> Log out.\n" +
                            ">");
            i =  sc.nextInt();
        }
    }

    /**
     * receptionistLogged function takes a Receptionist object type parameter. Shows the methods which user can do,
     * handles input flow. Exits if the requested method number does not exists.
     * @param aReceptionist
     */
    public void receptionistLogged(Receptionist aReceptionist){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i){
            case 1:
                aReceptionist.bookRoom(); break;
            case 2:
                aReceptionist.checkInTheGuest(); break;
            case 3:
                aReceptionist.checkOutTheGuest(); break;
            default:
                System.out.println("Logging out.");
                System.exit(1);
        }
    }
}
