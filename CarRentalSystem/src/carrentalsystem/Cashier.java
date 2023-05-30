/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;

/**
 *
 * @author DELL
 */
public class Cashier extends Employee {

    Scanner input = new Scanner(System.in);

    //ganna's code
    ArrayList<Cashier> cashierList = new ArrayList<Cashier>();
    ArrayList<Car> carsList = carrentalsystem.CarRentalSystem.cars;
    int numOfAllCars = Car.getNumOfCars();
    int availableCars = numOfAllCars - Car.getNumOfRentedCars();

    Car cars = new Car();
    String name1;
    String password1;
    Client client = new Client();
    int choice;
    char answerForMenu;

    ArrayList<Cashier> c2 = new ArrayList<Cashier>();
    ArrayList<Client> client1 = carrentalsystem.CarRentalSystem.clients;

    Car car = new Car();

    ArrayList<Car> cars1 = new ArrayList<Car>();

    public Cashier() {

    }

    public Cashier(int id, String firstName, String lastName, String username, String password) {
        super(id, firstName, lastName, username, password);
    }

    public void displayMenu() {

        int option;
        System.out.println("Please choose one of the options below");

        System.out.println("1.Update cashier's credentials ");
        System.out.println("2.Add Client to the system");
        System.out.println("3.Update client's renting info");
        System.out.println("4.search car");
        System.out.println("5.Return a rented car");
        System.out.println("6.Dispaly all cars");
        System.out.println("7.Dispaly rented cars");
        System.out.println("8.Dispaly avilable cars");
        System.out.println("9.Quit");

        option = input.nextInt();
        switch (option) {
            case 1:
                updateCashierCredentials();
                break;

            case 2:
                addClient();
                break;
            case 3:
                updateClientRentingInfo();
                break;
            case 4:
                searchCars();
                break;
            case 5:
                returnRentedCar();
                break;

            case 6:
                displayAllCars();
                break;
            case 7:
                displayRentedCars();
                break;
            case 8:
                displayAvailableCars();
                break;
            case 9:
                System.out.println("System Closed!");
                break;
            default:
                System.err.println("Invalid Option");
                System.out.println("System Closed!");
        }

    }

    public void updateCashierCredentials() {
        cashierList = carrentalsystem.CarRentalSystem.cashierList;
        System.out.println("Enter your old Password to Update your Credentials");

        String password2 = input.next();

        for (Cashier cashier1 : cashierList) {

            if (cashier1.password.equals(password2)) {
                System.out.println("Available password");
                System.out.println("Press 1 to change your username OR press 2 to change password");
                choice = input.nextInt();
                switch (choice) {
                    case 1:

                        System.out.println("Enter new username");
                        String newUsername = input.next();
                        cashier1.username = newUsername;

                        break;

                    case 2:
                        System.out.println("Enter new password");
                        String p1 = input.next();
                        cashier1.password = p1;

                        break;
                }
                break;
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

    public void addClient() {

        char answer;
        int ID;

        do {
            System.out.println("your id:" + (client1.size() + 1));
            client.id = client1.size() + 1;
            System.out.print("Enter the  firstname of client:");
            client.firstName = input.next();

            System.out.print("Enter the  lastname of client:");
            client.lastName = input.next();

            System.out.println("Enter the phone number of client:");
            client.phoneNumber = input.nextLong();
            System.out.println("Cars available for renting");
            displayAvailableCarsForClient();
            System.out.println("Enter the id of the car chosen fo renting:");
            ID = input.nextInt();
            for (Car car : carsList) {
                if (car.getCarId() == ID) {
                    car.setIsCarRented(true);
                    availableCars = numOfAllCars - Car.getNumOfRentedCars();
                    car.setRentedBy(client.firstName + " " + client.lastName);
                    System.out.println("Enter the rent duration in days:");
                    String duration;
                    duration = input.next();
                    car.setRentDuration(duration);

                    break;
                }
            }

            client1.add(client);
            do {
                System.out.println("Do you want to add another client?(y/n)");
                answer = input.next().charAt(0);
                if (answer == 'N' || answer == 'n') {
                    break;
                } else {
                    System.err.println("Invalid answer");
                }
            } while (answer != 'n' && answer != 'N' && answer != 'Y' && answer != 'y');

        } while (answer == 'Y' || answer == 'y');
//        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Do you want to exit{y/n)");
        answerForMenu = input.next().charAt(0);
        if (answerForMenu == 'y' || answerForMenu == 'Y') {
            System.out.println("System closed.");
        } else {

            displayMenu();
        }
    }

    public void searchCars() {

        System.out.println("Enter the brand you want to search for");
        String brand;
        brand = input.next();
        for (Car cars11 : carsList) {
            if (cars11.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(cars11.getModel());
                System.out.println(cars11.getCarId());
                System.out.println(cars11.getCarLicensePlate());

            } else {

                break;
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

    public void updateClientRentingInfo() {
        boolean clientExists = false;
        Client clientCheck = null;
        System.out.println("Enter the firstname of client");
        String firstNameOfClient = input.next();
        System.out.println("Enter the lastname of client");
        String lastNameOfClient = input.next();
        for (Client client11 : client1) {
            if (client11.firstName.equals(firstNameOfClient) && client11.lastName.equals(lastNameOfClient)) {
                clientCheck = client11;
                clientExists = true;
            }

        }
        if (clientExists == true) {
            System.out.println(" Press 1 if you want to update phone number and 2 to update the car for renting");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new phone number");
                    int phone = input.nextInt();
                    clientCheck.phoneNumber = phone;
                    break;
                case 2:
                    System.out.println("Enter the model of old rented car");
                    String model;
                    model = input.next();
                    for (Car car10 : carsList) {
                        if (car10.getModel().equalsIgnoreCase(model)) {
                            car10.setIsCarRented(false);
                            break;
                        }

                    }

                    String newRentedCar;
                    System.out.println("Enter the name of new rented car to check if it in the system");
                    newRentedCar = input.next();
                    for (Car car10 : carsList) {
                        if (car10.getModel().equalsIgnoreCase(newRentedCar)) {
                            clientCheck.rentedCar = newRentedCar;
                            car10.setIsCarRented(true);

                            break;
                        }
                    }
                    break;
            }

        } else if (clientExists == false) {
            System.out.println("Not Found");
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

    public void returnRentedCar() {
        System.out.println("enter the firstname of client");
        String nameOfClientFirstName = input.next();
        System.out.println("enter the lastname of client");
        String nameOfClientLastName = input.next();
        for (Client client : client1) {
            if (client.firstName.equals(nameOfClientFirstName) && client.lastName.equals(nameOfClientLastName)) {
                System.out.println("welecome " + " " + client.firstName + " " + client.lastName);
                for (Car car : carsList) {
                    if (car.getRentedBy().equals(nameOfClientFirstName + " " + nameOfClientLastName)) {
                        System.out.println(car.getCarId());
                        System.out.println(car.getModel());
                        System.out.println(car.getRentDuration());
                        System.out.println("---------------------------------------------------------------------------------------");

                        double total;
                        total = car.getRentPerDay() * Integer.parseInt(car.getRentDuration());
                        System.out.println("Total Payment" + "  --------" + ":" + total);
                        break;

                    }

                }
                break;
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

    public void displayAvailableCarsForClient() {
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

    }

}
