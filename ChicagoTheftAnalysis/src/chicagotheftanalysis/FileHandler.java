
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicagotheftanalysis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Hashtable;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author corneliusoludeyi
 */
public class FileHandler {
    
    private static final String COMMA = ",";
     
    //the following variables contains the path to each of the csv files used in this project
     
    private static final String censusFileName = "src/doc/Census_Data_2012.csv";
    
    private static final String neighborhoodFileName = "src/doc/neighborhood.csv";
    
    private static final String wardFileName = "src/doc/ward_offices.csv";
    
    private static final String theftFileName = "src/doc/theft.csv";

    private static final String policeFileName = "src/doc/police_stations.csv";
     
     
     //there are the array indexes for census which contains record about average neighborhood income in Chicago
     
     private static final int COMMUNITY_AREA_NAME = 1;
     private static final int PER_CAPITA_INCOME = 7;
     
     //these are the array indexes for neighborhood
     
     private static final int NEIGHBORHOOD_NAME_INDEX = 0;
     private static final int NEIGHBORHOOD_ZIPCODE_INDEX = 1;
   
     
     
     //these are the array indexes for ward
     
     private static final int WARD_INDEX = 0;
     private static final int WARD_ALDERMAN_INDEX = 1;
     private static final int WARD_ZIP_INDEX = 5;

    //these are the array indexes for police station
    private static final int POLICE_STATION_WEBSITE_INDEX = 5;
    private static final int POLICE_STATION_PHONE_INDEX = 6;
    private static final int POLICE_STATION_LOCATION_INDEX = 9;
    private static final int POLICE_STATION_ADDRESS_INDEX = 1;
    private static final int POLICE_STATION_LOCATION_2_INDEX = 10;
    private static final int POLICE_STATION_LOCATION_3_INDEX = 11;
    private static final int POLICE_STATION_ZIP_INDEX = 4;

    //these are the array indexes for theft

    private static final int THEFT_PRIMARY_TYPE_INDEX = 5;
    private static final int CASE_NUMBER_INDEX = 0;
    private static final int DATE_INDEX = 2;
    private static final int DESCRIPTION_INDEX = 6;
    private static final int LATITUDE_INDEX = 17;
    private static final int LONGITUDE_INDEX = 18;
    private static final int LOCATION_INDEX = 19;
    private static final int ARREST_INDEX = 8;
    private static final int THEFT_WARD_INDEX = 11;
    
    
    //list are declared below for the data classes used in this application
    
    List<Neighborhood> neighborhoodList;
    
    List<Census> censusList;
    
    List<Ward> wardList;
    
    List<Theft> theftList;
    
    List<PoliceStation> policeList;
    
    
    
    BufferedReader reader; // for reading files
    
    String row = ""; //this string will be assigned the values one each row of files read
     
     // The data classes are declared below
     
     PoliceStation policeStation;
     
     Census census;
     
     Neighborhood neighborhood;
     
     Ward ward;
     
     Theft theft;
     
     
     //this is the default constructor 
     //list are being initialised in the constructor
     public FileHandler(){
         
        censusList = new ArrayList<Census>();
         
        neighborhoodList = new ArrayList<Neighborhood>();
          
        wardList = new ArrayList<Ward>();
                 
        theftList = new ArrayList<Theft>();
                  
        policeList = new ArrayList<PoliceStation>();
         
        reader = null;
         
     }

     //this method reads Census_Data_2012.csv file and returns a list which contains
     // the neighborhood name and per capita income

    public List<Census> readCensusFile(){
        
        //try and catch used to handle error
         try{
            
            
           reader = new BufferedReader(new FileReader(censusFileName)); 
           
           reader.readLine(); //skips the csv first line which is the header

            while ((row = reader.readLine()) != null) {

             //each line is read and partitioned into array. This is done using the comma which signifies a new data
                //this while loop continues to read until it reaches the end of the file
                String[] array = row.split(COMMA);

                if (array.length > 0) { //the if statement is excuted if the array isn't empty 

      
                    census = new Census(array[COMMUNITY_AREA_NAME], array[PER_CAPITA_INCOME]);

                    censusList.add(census); //added census class object to list

                }

             

            }//end of while loop
            
            
        }catch(Exception e){

            e.printStackTrace();
        }
        finally{
            
            try{
                
            reader.close();
            
            }catch(IOException ioe){
                
                ioe.printStackTrace();
                
            }
        }
        
        return censusList;
    }
       
    
    //this method returns as a list which contains name and zipcode of all neighborhoods in chicago
    
    public List<Neighborhood> readNeighborhoodFile(){
        
        //try and catch implemented
        try{
            
            
           reader = new BufferedReader(new FileReader(neighborhoodFileName));
           
           reader.readLine(); //skips the csv first line which is the header

            while ((row = reader.readLine()) != null) {


                String[] array = row.split(COMMA);

                if (array.length > 0) {


                    neighborhood = new Neighborhood(array[NEIGHBORHOOD_NAME_INDEX], 
                            array[NEIGHBORHOOD_ZIPCODE_INDEX]);

                    neighborhoodList.add(neighborhood); //added neighborhood class object to list

                }

             

            }//end of while loop
                      
            
        }catch(Exception e){

            e.printStackTrace();
        }
        finally{
            
            try{ //extra precaution
                
            reader.close();
            
            }catch(IOException ioe){
                ioe.printStackTrace();
                
            }
        }
        
        return neighborhoodList;
    }
       
//this method returns a list which contains zipcode, names and index of all wards in Chicago
    //this method is implemented because the theft data only contains ward numbers, neighborhood zipcodes
    // or neighborhood names were not included. Thus, this application converts ward number to zipcode and then
    // displays neighborhood name
    public List<Ward> readWardFile(){
        
      
        try{
            
            
           reader = new BufferedReader(new FileReader(wardFileName));
           
           reader.readLine(); //skips the csv first line which is the header

            while ((row = reader.readLine()) != null) {


                String[] array = row.split(COMMA);

                if (array.length > 0) {


                    ward = new Ward(array[WARD_INDEX], array[WARD_ALDERMAN_INDEX], array[WARD_ZIP_INDEX]);

                    wardList.add(ward); //added ward class object to list
                    
                    
                }

             

            }//end of while loop
            
            
        }catch(Exception e){

            e.printStackTrace();
        }
        finally{
            
            try{
            reader.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                
            }
        }
        
        
        return wardList;
    }

    //this method returns a list which contains theft case number, primary type o crime, date, description, arrest and ward index
    
    public List<Theft> readTheftFile(){    

        try {

           reader = new BufferedReader(new FileReader(theftFileName));
           
           reader.readLine(); //skips the csv first line which is the header

            while ((row = reader.readLine()) != null) {


                String[] array = row.split(COMMA);

                if (array.length > 0) {


                    theft = new Theft(array[THEFT_PRIMARY_TYPE_INDEX], array[CASE_NUMBER_INDEX], array[DATE_INDEX], 
                            array[DESCRIPTION_INDEX],  array[ARREST_INDEX],array[THEFT_WARD_INDEX]);

                    theftList.add(theft); //added Theft class object to list

                }

             

            }//end of while loop
            

        }catch(Exception e){

            e.printStackTrace();
        }
        finally{
            
            try{
            reader.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                
            }
        }

return theftList;
    }
    
 
    //this method returns a list which contains police station address, phone number and zipcode

    public List<PoliceStation> readPoliceStationFile(){

       
        try {

         reader = new BufferedReader(new FileReader(policeFileName));
           
           reader.readLine(); //skips the csv first line which is the header

            while ((row = reader.readLine()) != null) {

                String[] array = row.split(COMMA);

                if (array.length > 0) {


                    policeStation = new PoliceStation(array[POLICE_STATION_ADDRESS_INDEX], 
                            array[POLICE_STATION_PHONE_INDEX], array[POLICE_STATION_ZIP_INDEX]);


                    policeList.add(policeStation); //added the class object to list
                    
              

                }
                

            }//end of while loop
            
             
        }catch (Exception e){

            e.printStackTrace();

        }
        finally{
            
            try{
            reader.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                
            }
        }

        return policeList;
    }
    
    
}
