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
public class Neighborhood {
    
    String neighborhood;
    String zipcode;
    
    //constructor
    public Neighborhood(String neighborhood, String zipcode){
        
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        
        
    }
    
    //setter and getter for neighborhood's name
    
    public String getNeighborhood(){
        
        return neighborhood;
    }
    
    public void setNeighborhood(String neighborhood){
        
        this.neighborhood = neighborhood;
        
    }
    
        //setter and getter for neighborhood zipcode
    
    public String getZipcode(){
        
        return zipcode;
    }
    
    public void setZipcode(String zipcode){
        
        this.zipcode = zipcode;
        
    }
    
}
