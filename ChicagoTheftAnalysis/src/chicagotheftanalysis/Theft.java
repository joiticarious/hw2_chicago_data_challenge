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
public class Theft {
    
    String primary_type;
    String case_number;
    String date;
    String description;
    String arrest;
    String ward;

    //constructor
    public Theft(String primary_type, String case_number, String date, String description,  String arrest, String ward){

        this.primary_type = primary_type;
        this.case_number = case_number;
        this.date = date;
        this.description = description;
        this.arrest = arrest;
        this.ward = ward;

    }

    //set and get methods for Theft Primary Type

    public String getPrimaryType(){

        return primary_type;
    }

    public void setPrimaryType(String primary_type){

        this.primary_type = primary_type;
    }

    //get and set methods for Theft Case Number

    public String getCaseNumber(){

        return case_number;
    }

    public void setCaseNumber(String case_number){

        this.case_number = case_number;
    }

    //get and set methods for date of theft incidence

    public String getDate(){

        return date;
    }

    public void setDate(String primary_type){

        this.date = date;
    }

//setter and getter for theft description

    public String getDescription(){

        return description;
    }

    public void setDescription(String description){

        this.description = description;
    }

    //setter and getter for arrest
    public String getArrest(){

        return arrest;
    }

    public void setArrest(String arrest){

        this.arrest = arrest;
    }
    
     //setter and getter for theft ward index
    public String getWard(){

        return ward;
    }

    public void setWard(String ward){

        this.ward = ward;
    }
    
}
