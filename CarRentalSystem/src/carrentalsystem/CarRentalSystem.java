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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem {

    /**
     * @param args the command line arguments
     */
    String rentDate;
    static char position;
    static String username;
    static String password;
    static ArrayList<Cashier> cashierList;
    static ArrayList<Admin> adminList;
    static ArrayList<Car> cars;
    static ArrayList<Client> clients;

    public static void main(String[] args) {

        Cashier cashier1 = new Cashier(1, "Ahmed", "Hossam", "AhmedCashier1", "Ahmed123#");
        Cashier cashier2 = new Cashier(2, "Ganna", "Khaled", "GannaCashier2", "Ganna456#");  // hard-coded cashier employees
        cashierList = new ArrayList<Cashier>();
        cashierList.add(cashier1);
        cashierList.add(cashier2);

        // Admin employees
        Admin admin1 = new Admin(1, "Mohammed", "Ahmed", "MohammedAdmin1", "Mohammed678#");
        Admin admin2 = new Admin(2, "Sarah", "Hatem", "SarahAdmin2", "Sarah910#");               // hard-coded admins
        adminList = new ArrayList<Admin>();
        adminList.add(admin1);
        adminList.add(admin2);

        Scanner input = new Scanner(System.in);

        //cars in system
        Car car1 = new Car(1, "505-KLV", "Kia", "Cadenza", 500.00, 30000.00);
        Car car2 = new Car(2, "606-ABC", "Kia", "Cerato", 400.00, 25000.00);
        Car car3 = new Car(3, "712-EFG", "Hyundai", "Elentra", 700.00, 30000.00);  // hard-coded cars
        Car car4 = new Car(4, "681-RYZ", "Nissan", "Qashqai", 800.00, 40000.00);
        Car car5 = new Car(5, "564-DCE", "Nissan", "sunny", 500.00, 20000.00);

        cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        Client client1 = new Client(1, "Adam", "Pane", 01001234567);
        Client client2 = new Client(2, "Mona", "Saad", 01111234567);  // hard-coded clients
        clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);

        System.out.println("Please,login");
        System.out.println("State your position,please.(C for cashier/ A for admin)");
        position = input.next().charAt(0);
        if (position == 'c' || position == 'C') {

            loginAsCashier();

        } else if (position == 'a' || position == 'A') {

            loginAsAdmin();
        }
    }

    public static void loginAsCashier() {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Username:");
            username = input.nextLine();
            System.out.println("Password:");
            password = input.nextLine();
            boolean isFound = false;
            char answer;

            // check access
            //check access
            for (Cashier cashier : cashierList) {
                if (username.equals(cashier.username) && password.equals(cashier.password)) {
//              cashier.menu();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.err.println("Invalid Credentials!");
                System.out.println("Try again?(y/n)");
                answer = input.next().charAt(0);
                if (answer == 'y' || answer == 'Y') {
                    System.out.println("Okay");
                } else if (answer == 'n' || answer == 'N') {
                    break;
                } else {
                    System.out.println("Invalid answer,choose Y or N!");
                }
            } else if (isFound) {
                System.out.println(" ");
                System.out.println("Welcome " + username);
                Cashier cashier = new Cashier();
                cashier.displayMenu();
                break;
            }
        }
    }

    public static void loginAsAdmin() {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Username:");
            username = input.nextLine();
            System.out.println("Password:");
            password = input.nextLine();
            boolean isFound = false;
            char answer;

            // check access
            for (Admin admin : adminList) {
                if (username.equals(admin.username) && password.equals(admin.password)) {
                    //admin.menu();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.err.println("Invalid Credentials!");
                System.out.println("Try again?(y/n)");
                answer = input.next().charAt(0);
                if (answer == 'y' || answer == 'Y') {
                    System.out.println("Okay");
                } else if (answer == 'n' || answer == 'N') {
                    break;
                } else {
                    System.out.println("Invalid answer,choose Y or N!");
                }
            } else if (isFound) {
                System.out.println("Welcome " + username);
                Admin admin = new Admin();
                admin.displayMenu();
                break;
            }
        }
    }

}
