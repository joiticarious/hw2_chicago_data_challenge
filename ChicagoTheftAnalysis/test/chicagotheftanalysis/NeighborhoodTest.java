/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicagotheftanalysis;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author corneliusoludeyi
 */
public class NeighborhoodTest {
    
    String neighborhood = "My hood";
    String neighborhood_zip = "60611";
    
    String primary_type = "THEFT";
    String case_number = "120398";
    String date = "06/14/2015 11:07 AM";
    String description = "Stole $500";
    String arrest = "TRUE";
    String ward_index = "24";
    
    String ward_name = "My ward";
    String ward_zip = "60612";
    
    String COMMUNITY_AREA_NAME = "China Town";
    String PER_CAPITA_INCOME = "10921";
    
    String station_address = "3510 S Michigan Ave";
    String station_phone = "312-747-8210";
    String station_zip = "IL 60653";
    
    Theft theft;
    
    Neighborhood instance;
    
    Ward ward;
    
    Census census;
    
    PoliceStation station;
    
    public NeighborhoodTest() {
        
         instance = new Neighborhood(neighborhood,neighborhood_zip);
        
         theft = new Theft(primary_type,case_number,date,description,arrest,ward_index);
         
         ward = new Ward(ward_index,ward_name,ward_zip);
         
         census = new Census(COMMUNITY_AREA_NAME,PER_CAPITA_INCOME);
         
         station = new PoliceStation(station_address,station_phone,station_zip);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNeighborhood method, of class Neighborhood.
     */
    @Test
    public void testGetNeighborhood() {
        System.out.println("getNeighborhood");
        String expResult = neighborhood;
        String result = instance.getNeighborhood();
        assertEquals(expResult, result);
      
    }


    /**
     * Test of getZipcode method, of class Neighborhood.
     */
    @Test
    public void testGetZipcode() {
        System.out.println("getZipcode");
        String expResult = neighborhood_zip;
        String result = instance.getZipcode();
        assertEquals(expResult, result);
      
    
    }
    
      @Test
    public void testGetPrimaryType(){
        
        System.out.println("getPtimaryType");
        String expResult = "THEFT";
        String result = theft.getPrimaryType();
        assertEquals(expResult, result);
        
    }
    
        @Test
    public void testGetCaseNumber(){
        
        System.out.println("getCaseNumber");
        String expResult = case_number;
        String result = theft.getCaseNumber();
        assertEquals(expResult, result);
        
    }
    
           @Test
    public void testGetDate(){
        
        System.out.println("getDate");
        String expResult = date;
        String result = theft.getDate();
        assertEquals(expResult, result);
        
    }
    
           @Test
    public void testGetDescription(){
        
        System.out.println("getDescription");
        String expResult = description;
        String result = theft.getDescription();
        assertEquals(expResult, result);
        
    }
    
           @Test
    public void testGetArrest(){
        
        System.out.println("getArrest");
        String expResult = arrest;
        String result = theft.getArrest();
        assertEquals(expResult, result);
        
    }
    
           @Test
    public void testGetWard(){
        
        System.out.println("getCaseNumber");
        String expResult = ward_index;
        String result = theft.getWard();
        assertEquals(expResult, result);
        
    }
    
             @Test
    public void testWardIndex(){
        
        System.out.println("getWard");
        String expResult = ward_index;
        String result = ward.getWard();
        assertEquals(expResult, result);
        
    }
    
             @Test
    public void testGetName(){
        
        System.out.println("getAlderman");
        String expResult = ward_name;
        String result = ward.getAlderman();
        assertEquals(expResult, result);
        
    }
    
             @Test
    public void testGetZipCode(){
        
        System.out.println("getZipcode");
        String expResult = ward_zip;
        String result = ward.getZipcode();
        assertEquals(expResult, result);
        
    }
    
               @Test
    public void testCommunityAreaName(){
        
        System.out.println("getCommunity_Area_Name");
        String expResult = COMMUNITY_AREA_NAME;
        String result = census.getCommunity_Area_Name();
        assertEquals(expResult, result);
        
    }
    
               @Test
    public void testPerCapitaIncome(){
        
        System.out.println("getPer_Capita_Income");
        String expResult = PER_CAPITA_INCOME;
        String result = census.getPer_Capita_Income();
        assertEquals(expResult, result);
        
    }
    
                 @Test
    public void testPoliceStationAddress(){
        
        System.out.println("getPoliceStationAddress()");
        String expResult = station_address;
        String result = station.getAddress();
        assertEquals(expResult, result);
        
    }
    
                 @Test
    public void testPoliceStationPhone(){
        
        System.out.println("getPoliceStationPhone");
        String expResult = station_phone;
        String result = station.getPhone();
        assertEquals(expResult, result);
        
    }
    
                 @Test
    public void testPoliceStationZip(){
        
        System.out.println("getPoliceStationZip");
        String expResult = station_zip;
        String result = station.getZip();
        assertEquals(expResult, result);
        
    }
    
}

