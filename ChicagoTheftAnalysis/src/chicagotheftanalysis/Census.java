/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chicagotheftanalysis;

/**
 *
 * @author corneliusoludeyi
 */
public class Census {
    
    String COMMUNITY_AREA_NAME;
    String PER_CAPITA_INCOME;
    
    //constructor
    public Census(String CAN, String PCI){
        
        this.COMMUNITY_AREA_NAME = CAN;
        this.PER_CAPITA_INCOME = PCI;
        
    }
    
    //setter and getter for COMMUNITY_AREA_NAME
    
    public String getCommunity_Area_Name(){
        
        return COMMUNITY_AREA_NAME; 
    }
    
    public void setCommunity_Area_Name(String CAN){
        
        this.COMMUNITY_AREA_NAME = CAN;
    }
    
    
    
     //setter and getter for PER_CAPITA_INCOME
    
      public String getPer_Capita_Income(){
        
        return PER_CAPITA_INCOME;
    }
    
    public void setPer_Capita_Income(String PCI){
        
        this.PER_CAPITA_INCOME = PCI;
    }
    
}
