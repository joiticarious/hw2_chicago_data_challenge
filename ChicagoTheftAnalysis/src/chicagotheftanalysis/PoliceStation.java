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
public class PoliceStation {
    
    String address;
    String phone;
    String zip;

//constructor
    public PoliceStation(String address,  String phone,String zip){


        this.address = address;
        this.phone = phone;
        this.zip = zip;


    }

    //setter and getter for police station address

    public String getAddress(){


        return address;
    }

    public void setAddress(String address){

        this.address = address;
    }
    
  
    //setter and getter for police station phone number

    public String getPhone(){


        return phone;
    }

    public void setPhone(String phone){

        this.phone = phone;
    }
    
     //setter and getter for police station zip code

    public String getZip(){


        return zip;
    }

    public void setZip(String zip){

        this.zip = zip;
    }
    
}
