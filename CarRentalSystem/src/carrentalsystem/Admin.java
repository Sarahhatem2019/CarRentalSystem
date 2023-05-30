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
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Employee {

    ArrayList<Car> carsList = carrentalsystem.CarRentalSystem.cars;
    Car cars = new Car();
    int numOfAllCars = Car.getNumOfCars(); //this function returns number of cars in system
    int availableCars = numOfAllCars - Car.getNumOfRentedCars(); // to get the number of available cars

    Scanner input = new Scanner(System.in);
    char answerForMenu;

    public Admin() {
    }

    public Admin(int id, String firstName, String lastName, String username, String password) {
        super(id, firstName, lastName, username, password);

    }

    public void displayMenu() {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("Please choose one of the options below");
        System.out.println("1.Display all cars");
        System.out.println("2.Display rented cars");
        System.out.println("3.Display available cars");
        System.out.println("4.Add Car");
        System.out.println("5.Delete Car");
        System.out.println("6.Quit");

        option = input.nextInt();

        switch (option) {
            case 1:
                displayAllCars();
                break;

            case 2:
                displayRentedCars();
                break;

            case 3:
                displayAvailableCars();
                break;
            case 4:
                addCar();
                break;
            case 5:
                removeCar();
                break;
            case 6:
                System.out.println("System Closed");
                break;
            default:
                System.err.println("Invalid Option");
                System.out.println("System Closed!");
        }

    }

    public void displayAllCars() {

        System.out.println("All cars in system");
        System.out.println("Number of cars in system:" + numOfAllCars);

        for (Car c : carsList) {
            System.out.println("Car ID:" + c.getCarId());
            System.out.println("Car License Plate:" + c.getCarLicensePlate());
            System.out.println("Car Brand:" + c.getBrand());
            System.out.println("Car model:" + c.getModel());
            System.out.println("Car Rent Per Day:" + c.getRentPerDay());
            System.out.println("Car Deposit:" + c.getDeposit());
            System.out.println("Car Rent Duration:" + c.getRentDuration());
            System.out.println("---------------------------------------------------------------------------------------------------------------");
        }

        System.out.println("Number of available cars:" + availableCars + "                       " + "Number of rented cars:" + Car.getNumOfRentedCars());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Do you want to exit{y/n)");
        answerForMenu = input.next().charAt(0);
        if (answerForMenu == 'y' || answerForMenu == 'Y') {
            System.out.println("System closed.");
        } else {

            displayMenu();
        }

    }

    public void displayRentedCars() {
        System.out.println("Rented Cars");
        System.out.println("Number of rented cars in system:" + Car.getNumOfRentedCars());

        for (Car c : carsList) {

            if (c.isIsCarRented() == true) {
                System.out.println("Car ID:" + c.getCarId());
                System.out.println("Car License Plate:" + c.getCarLicensePlate());
                System.out.println("Car Brand:" + c.getBrand());
                System.out.println("Car model:" + c.getModel());
                System.out.println("Car Rent Per Day:" + c.getRentPerDay());
                System.out.println("Car Deposit:" + c.getDeposit());
               
                System.out.println("Car Rent Duration:" + c.getRentDuration());
               
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            }

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Do you want to exit{y/n)");
        answerForMenu = input.next().charAt(0);
        if (answerForMenu == 'y' || answerForMenu == 'Y') {
            System.out.println("System closed.");
        } else {

            displayMenu();
        }
    }

    public void displayAvailableCars() {
        System.out.println("Rented Cars");
        System.out.println("Number of available cars in system:" + availableCars);

        for (Car c : carsList) {

            if (c.isIsCarRented() == false) {
                System.out.println("Car ID:" + c.getCarId());
                System.out.println("Car License Plate:" + c.getCarLicensePlate());
                System.out.println("Car Brand:" + c.getBrand());
                System.out.println("Car model:" + c.getModel());
                System.out.println("Car Rent Per Day:" + c.getRentPerDay());
                System.out.println("Car Deposit:" + c.getDeposit());
                
                System.out.println("Car Rent Duration:" + c.getRentDuration());
                
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            }

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Do you want to exit{y/n)");
        answerForMenu = input.next().charAt(0);
        if (answerForMenu == 'y' || answerForMenu == 'Y') {
            System.out.println("System closed.");
        } else {

            displayMenu();
        }
    }

    public void addCar() {
        char answer;
        do {

            cars.setCarId(carsList.size() + 1);
            System.out.println("Car ID:" + (carsList.size() + 1));
            System.out.println("Enter car’s brand ");
            cars.setBrand(input.nextLine());
            System.out.println("Enter car’s Car License Plate ");
            cars.setCarLicensePlate(input.nextLine());
            System.out.println("Enter car’s Car Model ");
            cars.setModel(input.nextLine());
            System.out.println("Enter car’s Car rentPerDay ");
            cars.setRentPerDay(input.nextInt());
            System.out.println("Enter car Deposit ");
            cars.setDeposit(input.nextInt());

            numOfAllCars++;
            availableCars = numOfAllCars - Car.getNumOfRentedCars();
            carsList.add(cars);

            do {
                System.out.println("Do you want to add another car?(y/n)");
                answer = input.next().charAt(0);
                if (answer == 'N' || answer == 'n') {
                    break;
                } else {
                    System.err.println("Invalid answer");
                }
            } while (answer != 'n' && answer != 'N' && answer != 'Y' && answer != 'y');

        } while (answer == 'y' || answer == 'Y');

        displayMenu();

    }

    public void removeCar() {

        System.out.println("Enter car id that you want to remove: ");
        int x = input.nextInt();

        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getCarId() == x) {

                carsList.remove(i);
                numOfAllCars--;
                availableCars = numOfAllCars - Car.getNumOfRentedCars();

            }
        }

        displayMenu();
    }

}
