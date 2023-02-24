/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1.model.Address;

/**
 *
 * @author marcin
 */
public class Address {
    private String city;
    private String streetAndNumber;
    private String postCode;
    
    Address(){
        
    }
    public Address(String city, String streetAndNumber, String postCode){
        this.city = city;
        this.streetAndNumber = streetAndNumber;
        this.postCode = postCode;
    }
    public String getCity(){
        return city;
    }
    public String getStreetAndNumber(){
        return streetAndNumber;
    }
    public String getPostCode(){
        return postCode;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    public void setStreetAndNumber(String streetAndNumber){
        this.streetAndNumber = streetAndNumber;
    }
    public void setPostCode(String postCode){
        this.postCode = postCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(this.city == ((Address)obj).city && this.streetAndNumber == ((Address)obj).streetAndNumber
            && this.postCode == ((Address)obj).postCode)
            return true;
        return false;
    }
}
