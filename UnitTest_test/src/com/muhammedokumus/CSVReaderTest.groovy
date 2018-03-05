package com.muhammedokumus

class CSVReaderTest extends GroovyTestCase {
    void testCsvFileToRowsOfStrings() {
        //TEST FOR WRONG FILE NAME,
        String filename = "Files/testr.csv"

        CSVReader usersFile = new CSVReader();
        List<String[]> rawUserData;

        rawUserData = usersFile.csvFileToRowsOfStrings(filename);
        System.out.println("Expecting rawUserData to be empty on wrong input.")
        assertEquals([],rawUserData)

        //TEST FOR RANDOM FILE
        filename = "Files/test.csv"
        rawUserData = usersFile.csvFileToRowsOfStrings(filename);
        System.out.println(rawUserData);
        assertEquals(4,rawUserData.size());
    }
}
