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
import java.util.Date;
public class Car {
   private int carId; 
  private String carLicensePlate;
  private String brand;
  private String model;
  private double rentPerDay;
  private double deposit;
  private String rentDuration;
  private boolean isCarRented = false;
  private String rentedBy = "none";
   private static int numOfCars = 0;
  private static int numOfRentedCars = 0;

 
  // overloading constructors
    public Car(int carId) {
        this.carId = carId;
        numOfCars++;
        
        
        
    }

    public Car(int carId, String carLicensePlate, String brand, String model, double rentPerDay,double deposit) {
        this(carId);
        this.carLicensePlate = carLicensePlate;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.deposit = deposit;

    }

    public Car() {

    }
    
   

    public Car(int carId, String carLicensePlate, String brand,String model ,double rentPerDay, double deposit, String rentDuration) {
        this(carId,carLicensePlate,brand, model,rentPerDay,deposit);
        
        this.rentDuration = rentDuration;
        
     
    }

    public Car(int carId, String carLicensePlate, String brand,String model ,double rentPerDay, double deposit,String rentDuration, String rentedBy){
       this(carId,carLicensePlate,brand,model ,rentPerDay,deposit,rentDuration);
        this.rentedBy = rentedBy;

    }
    
    
      //setters and getters to adjust data
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    

    public String getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(String rentDuration) {
        this.rentDuration = rentDuration;
    }

    

    public boolean isIsCarRented() {
        
        return isCarRented;
    }

    public void setIsCarRented(boolean isCarRented) {
        this.isCarRented = isCarRented;
       numOfRentedCars++;
    }

    public static int getNumOfRentedCars() {
        return numOfRentedCars;
    }


    public static void setNumOfCars(int numOfCars) {
        Car.numOfCars = numOfCars;
    }

    public static void setNumOfRentedCars(int numOfRentedCars) {
        Car.numOfRentedCars = numOfRentedCars;
    }


    public static int getNumOfCars() {
        return numOfCars;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(String rentedBy) {
        this.rentedBy = rentedBy;
    }

   
  
  
  
  
  }
  
  
  
    

