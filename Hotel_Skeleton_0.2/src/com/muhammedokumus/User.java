package com.muhammedokumus;



public abstract class User implements UserInterface {

    protected String userID;
    protected String userPassword;

    public User(String userID, String userPassword){
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID(){
        return userID;
    }

    protected String getPassword(){
        return userPassword;
    }


    @Override
    public String toString(){
        return userID + "," + userPassword;
    }

}
