/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicagotheftanalysis;

import java.util.Scanner;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author corneliusoludeyi
 */
public class ChicagoTheftAnalysis {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] histogram = new int[183][2]; //183 records
        
        int[][] histogram2 = new int[53][2];
        
        String input;
        String y_or_n;
        
        int num = 0; //this integer displays the number of records in each section
        
        int occurence = 0; //this integer is assigned the number of police stations in each neighhorhood
        
        int num_of_theft = 0; //this integer if assigned the number of theft in each neighhorhood
     
        Scanner scan = new Scanner(System.in);
        
        //FileHandler class is is declared with handler being it's object
        FileHandler handler = new FileHandler();

      //this do-while loop runs until the user exits
        do{
            
         
        
        System.out.println("_____________________________________________________________________");
        System.out.println("|                    CHICAGO THEFT RATE ANALYSIS                    |");
        System.out.println("|___________________________________________________________________|");
        System.out.println("|                Input an option and press ENTER to view            |");
        System.out.println("|___________________________________________________________________|");
        System.out.println("|  1. List of Neighborhoods in Chicago                              |");
        System.out.println("|  2. List of Average incomes in each neighborhood                  |");
        System.out.println("|  3. List of thefts incidence in each neighborhood                 |");
        System.out.println("|  4. List of Police stations in Chicago                            |");
        System.out.println("|  5. Correlation between Crime rate and Average income             |");
        System.out.println("|  6. Correlation between Crime rate and Police station             |");
        System.out.println("|  7. Exit                                                          |");
        System.out.println("|___________________________________________________________________|");
        
        input = scan.nextLine(); //user's input is being read
        
        //switch case statement for user's input which handles all character inputs
        switch(input){
            
            case "1":
                
                      num = 0; //resets the value of num
                
                //list of neighborhoods in chicago
                System.out.println("         CHICAGO NEIGHBORHOODS          ");
                System.out.println("   Zip Code      | Neighborhood Name");
                System.out.println("--------------------------------------");
                
                //the readNeighborhoodFile() method returns list of all neighborhoods which is assigned to 
                //Neighborhood object named neighborhood in the for loop             
                
                for(Neighborhood neighborhood: handler.readNeighborhoodFile()){
                    
                    num++; //this is incremented for each loop 
                    
                    //the output is formatted to look good
                    
                    System.out.printf("%-4s %-14s %-15s %n",num+".",neighborhood.getZipcode(),neighborhood.getNeighborhood());
                    
                } //end of for loop
                
                break;
                
            case "2":
                
                //average income in neighborhoods
                
                      num = 0; //resets the value of num to zero
                
                System.out.println("      INCOME IN CHICAGO NEIGHBORHOODS  ");
                System.out.println("   Neighborhood Name          | Average income");
                System.out.println("----------------------------------------------");
                
                //readCensusFile() method returns list which contains average income in each neighborhood
                //this list is assigned to Census' object named census in the for loop
                
                for(Census census: handler.readCensusFile()){
                    
                    num++; //this is incremented for each loop 
                    
                    System.out.printf("%-4s %-27s %-15s %n",num+".",census.getCommunity_Area_Name(),census.getPer_Capita_Income());
                    
                }// end of for loop
                
                break;
                
            case "3":
                       
                
                //theft cases in neighborhoods
                
                num = 0; //resets the value of num
                
                System.out.println("                                 CHICAGO THEFT RECORD                                 ");
                System.out.println("     Case Number                     Date             Arrested  Ward Number   Description");
                System.out.println("-----------------------------------------------------------------------------------------");
                
                // readTheftFile() method returns list of all thefts in each neighorhood and the list is assigned to
                //Theft's object which is declared as theft in the for loop
                
                for(Theft theft: handler.readTheftFile()){
                    
                    num++; //this is incremented for each loop 
                    
                    System.out.printf("%-4s %-20s %-28s %-10s %-16s %-20s %n",num+".",theft.getCaseNumber(),theft.getDate(),theft.getArrest(),theft.getWard(),theft.getDescription() );
                    
                } //end of for loop
                
                break;
            case "4":
                
                
                //list of police stations
                
                      num = 0; //resets the value of num
                
                System.out.println("               POLICE STATION             ");
                System.out.println("   Zip code   Tel Number    Address");
                System.out.println("--------------------------------------------------------");
                
                // readPoliceStationFile() method returns list of all the police stations in Chicago and the list is
                //assignmed to PoliceStation class' object which is declared as station in the for loop
                
                for(PoliceStation station: handler.readPoliceStationFile())
                {
                    num++;//this is incremented for each loop 
                    
                    System.out.printf("%-3s %-8s %-14s %-40s %n",num+".",station.getZip(),station.getPhone(),station.getAddress());
                     
                }              //end of for loop  
                break;
                
            case "5":
                
                num = 0; //resets the value of num
                
                System.out.println("RELATIONSHIP BETWEEN CRIME RATE AND AVERAGE INCOME IN NEIGHBORHOODS");
                System.out.println("Neighborhood Name    Average Income    Number of Theft");
                System.out.println("-------------------------------------------------------------------");
                
                // In the first for loop readNeigborhoodFile() method returns list of all neighborhoods in chicago
               
                
                   for (Neighborhood neighborhood: handler.readNeighborhoodFile()){
                       
                        // Neghborhood names and zipcoded are assigned to String name and zipcode respectively
                       
                       String zipcode = neighborhood.getZipcode();
                       String name = neighborhood.getNeighborhood();
                       
                       //num_of_theft is reassigned value of zero at the beginning of each loop
                       
                       num_of_theft = 0;
                       
                       //each neighborhood's zipcode is used to calculate how many theft incidences occured 
                       // using a method declared as wardNoToZip() which returns lists of zipcode of where
                       //thefts occured in Chicago
                       
                       num_of_theft = Collections.frequency(wardNoToZip(), zipcode);
                       
                       // readCensusFile() method returns list of all estimated average income in each ward
                       //in Chicago which is assigned to Census's class objected declared was census
                       
                      for(Census census: handler.readCensusFile()){
                          
                          //the if statement checks if the neighborhood's name appears on census
                          //this is achieved by checking if each neighborhood's name corresponds with it's record
                          //in census which contains average incomes, neighborhood name e.t.c
                          
                          if(name.equals(census.getCommunity_Area_Name())){
                              
                              //53 records
                              
                               num++; //this is incremented for each loop 
                               
                                int looper = num-1;
                   
                   histogram2[looper][0] = Integer.valueOf(census.getPer_Capita_Income());
                   histogram2[looper] [1] = num_of_theft;
                               
                System.out.printf("%-4s %-24s %-10s %d  %n",num+".",neighborhood.getNeighborhood(),census.getPer_Capita_Income(),num_of_theft);
                                break; //this break makes the program run faster
                          }
                          
                          //if a neighborhood's record is not found in census, it is not displayed as it is
                          // irrelevant in this analysis

                      }
                       
                         
                   } //end of for loop
                   
                   System.out.println();
                   System.out.println("NEIGHBORHOOD INCOME VERSUS THEFT");
                   System.out.println(" Neighborhood Income   |   Theft incidences ");
                   System.out.println("---------------------------------------------");
                   
                   num=0;
                   
                   for(final int[] s: histogram2){
                       
                       num++;
                       
                       System.out.printf("%-4s %-30d %d %n",num+".",s[0],s[1]);
                   }
                   
                   
                     System.out.println();
                     System.out.println();
                     System.out.println("This is a low positive correlation.");
                     System.out.println("Average income of people in each neighborhood is not the major factor responsible for theft rate "); 
                     System.out.println("There might be other major factors that contributes to theft rate."); 
                     System.out.println("Likewise, there are not records of theft incidences in certain neighborhoods which.");
                     System.out.println("This however makes it almost impossible to make conclusion ");
                     System.out.println();
                     System.out.println();
                     System.out.println("Histogram");
                     System.out.println();
                   
                          Arrays.sort(histogram2, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                final int t1 = entry1[0];
                final int t2 = entry2[0];
                return Integer.valueOf(entry1[0]).compareTo(Integer.valueOf(entry2[0]));
            }
        });
               
               for(final int[] s: histogram2){
                   
                   int bar = s[1];
                //   String 
                   System.out.print(s[0]+" : ");
                   
                   for(int i=0;i<bar;i++){
                       
                       System.out.print("*");
                   }
                   System.out.println();
                   
                  // System.out.println(s[0]+" "+s[1]);
                   
               } //end of for loop
                   
                   
                   
                   
                
                break;
                      
            case "6":
                
                num = 0; //resets the value of num
    
                System.out.println("RELATIONSHIP BETWEEN CRIME RATE AND POLICE STATION");
                System.out.println("Neighborhood Name               Number of Police stations   Number of Theft");
                
                // readNieghhorhoodFile() method returns list of all neighborhoods and it's list is assigned to
                // Neighborhood class' object declared as neighborhood
                
                int zero=0;
                   int one=0;
                   int two=0;
                   int three=0;
                
               for (Neighborhood neighborhood: handler.readNeighborhoodFile()){
        
                   //gets zip code of the present neighborhood
                   String zipcode = neighborhood.getZipcode();
                                       
                   occurence = 0; // this is the counter for number of police stations in each neighborhood
                   
                   num_of_theft = 0; //this is the counter for number of theft incidence in each neighh=borhood
                   
                 //the counter is assigned value by check the frequency of each zipcode in policeZip() method.
                   // policeZip() method returns list of police station zipcodes
                   
                   occurence = Collections.frequency(policeZip(),zipcode);
                   
                   //the same is done here except it checks for number of theft in wardNoToZip() method
                   // which returns a list of all theft crimes
                   
                   num_of_theft = Collections.frequency(wardNoToZip(), zipcode);
                   
             
                        num++; // counter working
                        
                   
                   
                   int looper = num-1;
                   
                   histogram[looper][0] = occurence;
                   histogram[looper] [1] = num_of_theft;
                   
                   
                   
                  switch(occurence){
                      
                      case 0:
                          zero+=num_of_theft;
                          break;
                      case 1:
                          one+=num_of_theft;
                          break;
                      case 2:
                          two+=num_of_theft;
                          break;
                      case 3:
                          three+=num_of_theft;
                          break;
                      
                  }
                        
                System.out.printf("%-4s %-35s %-25s %d %n",num+".",neighborhood.getNeighborhood(),occurence,num_of_theft);
                

                     
                }//end of for loop 
               
               System.out.println();
               System.out.println();
               
               
               System.out.println("Police Station  Versus Theft occurences");
               System.out.println("Police Station    |    Theft     ");
               System.out.println("---------------------------------------");
               System.out.printf("%-25s %d %n","0",zero);
               System.out.printf("%-25s %d %n","1",one);
               System.out.printf("%-25s %d %n","2",two);
               
               
                System.out.println();
                       System.out.println();
                         System.out.println("This is a negative correlation as theft decreases when number of police stations increases");
                         System.out.println();
                       System.out.println();
                         
                
                break;
                
                // 7,E or e are the characters responsible for exiting the program
                
            case "7":
            case "e":
            case "E":
                
                //exit
                
                //The program displays a warning message exiting the program
                //the user is required to input y for YES or n for NO
                
                System.err.println("Exit Application?");
                System.err.println("YES (y) or NO (n)");
                
                y_or_n = scan.nextLine(); //the user's input is being assigned to y_or_n String
                
                //if the user input y or yes either in lower or uppercase, the program exits
                if(y_or_n.equalsIgnoreCase("y") || (y_or_n.equalsIgnoreCase("yes") )){
                    
                    System.exit(0);
                    
                }
                //the program return to menu if the user inputs n or no in either in upper or lowercase
                else if(y_or_n.equalsIgnoreCase("n") ||(y_or_n.equalsIgnoreCase("no")) ){
                    
                    return;
                    
                }
                else{ //if the user inputs another key, it breaks out and returns to menu
                    
                    break;
                }
                
                break;
                
                
            default:
                
                //when the user selects another character apart from 1 to 7, e or X
                //the program displays an error messsage
                
                System.err.println("Invalid selection! ");
                System.err.println("Enter a number between 1 and 7");
                
                break;
            
            
        }//end of switch statement
        
            
        } while(!input.equalsIgnoreCase("e") || !input.equals("7"));
        
   
    }//end of main method
    
    
   
    //this method returns a list which contains zipcodes for all police stations in chicago
    
    public static List<String> policeZip(){
        
        FileHandler handler = new FileHandler();
        
        List<String> zip_codes = new ArrayList<String>();
        
        for(PoliceStation station: handler.readPoliceStationFile()){
                       
                       String codes = station.getZip().toString();
                       
                       zip_codes.add(codes); //each zipcode value is added to zip_codes list
                         
                   }
        return zip_codes;
    } //end of policeZip method
    
    //this method returns a list which contains the ward number where theft occured in chicago
    //the theft dataset only contains ward number where incidence occured, zipcodes were not provided
    
    public static List<String> theftWardNo(){
        
         FileHandler handler = new FileHandler();
         
         List<String> wardList = new ArrayList<String>();
         
         for(Theft theft: handler.readTheftFile()){
             
             String ward = theft.getWard();
             wardList.add(ward); //each ward number is added to the wardList list 
 
         }//end of for loop
         
        
        return wardList;
    } //end of theftWardNo
    
    //this method return a list which contains zipcodes of each ward in chicago
    
    public static List<String> wardNoToZip(){
        
         FileHandler handler = new FileHandler();
         
         List<String> wardList = new ArrayList<String>();
              
         
         for(String wardNumber: theftWardNo()){

        
           for(Ward ward: handler.readWardFile()){
            
            if(wardNumber.equals(ward.getWard())){
                
                wardList.add(ward.getZipcode());
                break; //this break discontinues the loop when a record is found
               
            }// end of if statement
           
          
        } // end of inner for statement
   

    } //end of ouuter for loop 
         
       
        
        return wardList;
    } //end of wardNoToZip method
    
   
   
    
}
