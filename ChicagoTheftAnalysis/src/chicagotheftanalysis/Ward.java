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
public class Ward {
    
    String ward;
    String alderman;
    String zipcode;
    
    
    //constructor
    public Ward(String ward, String alderman, String zipcode){
        
        this.ward = ward;
        this.alderman = alderman;
        this.zipcode = zipcode;
        
        
    }
    
    //setter and getter for ward index
    
    public String getWard(){
        
        return ward;
    }
    
    public void setWard(String ward){
        
        this.ward = ward;
        
    }
    
    //setter and getter for alderman 
    
    public String getAlderman(){
        
        return alderman;
    }
    
    public void setAlderman(String alderman){
        
        this.alderman = alderman;
        
    }
    
    //setter and getter for ward zipcode
    
    public String getZipcode(){
        
        return zipcode;
    }
    
    public void setZipcode(String zipcode){
        
        this.zipcode = zipcode;
        
    }
    
}
