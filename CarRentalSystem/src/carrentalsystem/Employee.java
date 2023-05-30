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
public abstract class Employee extends Person {
    
     String password; 
     String username;

    public Employee() {
    }

    
    
     
    public Employee(int id, String firstName,String lastName ,String username, String password){
        super(id,firstName,lastName);
        this.password = password;
        this.username = username;
        
        
    }
}
