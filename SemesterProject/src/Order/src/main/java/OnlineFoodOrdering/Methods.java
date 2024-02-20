package OnlineFoodOrdering;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    public static ArrayList<Customer> customerArrayList = new ArrayList<>();
    private static ArrayList<FoodItem> orderArrayList = new ArrayList<>();
    private static ArrayList<FoodItem> FoodItemList = new ArrayList<>();
    //Order order = new Order();

    public static ArrayList<FoodItem> getOrderArrayList() {
        return orderArrayList;
    }

    public static ArrayList<FoodItem> getFoodItemList() {
        return FoodItemList;
    }

    public static ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }


    public static boolean ifUserPresent(String userName, String password) {
        for (Customer customer : customerArrayList) {
            if (customer.getUserName().equals(userName) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean ifAdminPresent(String adminName,String adminPassword){
        if (adminName.equals("admin") && adminPassword.equals("admin")){
            return true;
        }
        return false;
    }

    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter the number of the item you want to add to your order (0 to finish): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getOrderArrayList().add(getFoodItemList().get(0));
                    break;
                case 2:
                    getOrderArrayList().add(getFoodItemList().get(1));
                    break;
                case 3:
                    getOrderArrayList().add(getFoodItemList().get(2));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid item number.");
                    break;
            }
        } while (choice != 0);
        System.out.println("You Order Has Been Finalized");
    }

    //    public static void showOrder(){
//        for (getOrderArrayList().!= null){
//            System.out.println(getOrderArrayList());
//        }
//
//    }
    public static void printArrayList() {
        // Iterate over the elements and print them
        for (FoodItem item : getOrderArrayList()) {
            System.out.println(item);
        }

    }

    public static void getBill(){
        double bill = 0.0;
        for (FoodItem item : getOrderArrayList()){
            bill += item.getItemPrice();
        }
        System.out.println("Your Bill Is"+bill);
        double taxedBill = bill+(bill*0.17);
        System.out.println("Your Bill With 17%Tax Is"+taxedBill);
    }
}
