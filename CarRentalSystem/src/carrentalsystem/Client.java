/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

/**
 *
 * @author DELL
 */
public class Client extends Person {
    
    //Car rentedCar;
    
   String rentedCar;
   long phoneNumber;

    public Client() {
    }

    

    
    public Client(String rentedCar) {
        this.rentedCar = rentedCar;
    }
    

    public Client(int id, String firstName,String lastName ,long phoneNumber) {
        super(id, firstName,lastName);
          this.phoneNumber =  phoneNumber;
          
        
    }
    
   
    
    
    
    
    
}
