package com.muhammedokumus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    List<String[]> listOfRows = new ArrayList<>();

    public List<String[]> csvFileToRowsOfStrings(String filename){
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                listOfRows.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found. Please check Files folder under project for users.csv");
        } catch (IOException e) {
            System.out.println("User data could not be loaded. File format is wrong/corrupted.");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listOfRows;
    }
}
