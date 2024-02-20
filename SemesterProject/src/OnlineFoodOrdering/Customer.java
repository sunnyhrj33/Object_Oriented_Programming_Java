package OnlineFoodOrdering;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Customer {
    Scanner scanner = new Scanner(System.in);
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String address;
    int index = 1;
    private List<Order> orders = new ArrayList<>();

    public Customer(String userName, String password, String email, String address) {
        this.userId = index++;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", index=" + index +
                '}';
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Customer createNewCustomer() {
        Scanner sc = new Scanner(System.in);
        String un, pw, email, address;
        System.out.println("Please Enter Your Details");
        System.out.println();
        System.out.println("Enter Your UserName:");
        un = sc.nextLine();
        System.out.println("Enter Your Password:");
        pw = sc.nextLine();
        System.out.println("Enter Your Email:");
        email = sc.nextLine();
        System.out.println("Enter Your Address:");
        address = sc.nextLine();
        return new Customer(un, pw, email, address);
    }

    public void placeOrder(Menu menu,Scanner scanner) {
        Scanner sc = new Scanner(System.in);
        int foodItemId;
        int quantity;

        List<FoodItem> orderedItems = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        System.out.println("Enter -1 to finish your order.");
        while (true) {
            System.out.println("Enter the ID of the food item you want to order:");
            foodItemId = sc.nextInt();

            if (foodItemId == -1) {
                break;  // Exit the loop if -1 is entered
            }

            // Get the selected food item from the menu
            FoodItem selectedFoodItem = menu.getItem(foodItemId);

            if (selectedFoodItem == null) {
                System.out.println("Invalid food item ID. Please try again.");
                continue;
            }

            // Display the selected food item and ask for quantity
            System.out.println("Selected Item: " + selectedFoodItem.getItemName());
            System.out.println("Enter the quantity:");
            quantity = sc.nextInt();

            // Add the selected food item and its quantity to the lists
            orderedItems.add(selectedFoodItem);
            quantities.add(quantity);

            System.out.println("Item added to your order.");
        }
        Order currentOrder = new Order(this, orderedItems, quantities, 0.00, "Placed");
        orders.add(currentOrder);

        // Display the total bill for the customer's orders
        calculateTotalBill();
    }
        public void calculateTotalBill() {
        double totalBill = 0;
        for (Order order : orders) {
            totalBill += order.getTotalPrice();
        }
        System.out.println("Your total bill is: Rs" + totalBill);
    }
}
