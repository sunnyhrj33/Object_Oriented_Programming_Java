package OnlineFoodOrdering;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int input=0;
        System.out.println("Welcome To Food-Hub");
        System.out.println("Enter 1 To Log In");
        System.out.println("Enter 2 To Register");
        System.out.println("Enter 3 To Login As An Admin");
        while (input > -1)
        {

            System.out.println("Enter -1 To Exit");
            while (true) {
                try {
                    input = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Selection");
                    System.out.println("Please Select Again");
                    sc.nextLine();
                }
            }

           switch (input)
          {
               case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
              case 3:
                    case3();
                    break;
            }

        }

    }
public static void case1(){

        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        System.out.println("Enter Your Credentials");
        System.out.println("Enter Your User-Name:");
        username = sc.nextLine();
        System.out.println("Enter Your Password:");
        password = sc.nextLine();

        if(Methods.ifUserPresent(username,password) == true ){

            System.out.println("You Have Successfully Logged In");
            System.out.println("You Can Order Food From The Menu");
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter 1 To Select From Starters");
            System.out.println("Enter 2 To Select From Main-Course");
            System.out.println("Enter 3 To Select From Deserts");
            System.out.println("Enter 4 To Select From Whole Menu");
            System.out.println("Enter 0 To Go Back");
            int input = sc.nextInt();
            switch (input){
                case 0:
                    Main.main();
                    break;
                case 1:
                    Menu.displayFoodItemsByCategory(Methods.getFoodItemList(),FoodItemType.STARTERS);
                    Methods.takeOrder();
                    Methods.printArrayList();
                    Methods.getBill();
                    break;
                case 2:
                    Menu.displayFoodItemsByCategory(Methods.getFoodItemList(),FoodItemType.MAINCOURSE);
                    Methods.takeOrder();
                    Methods.printArrayList();
                    Methods.getBill();
                    break;
                case 3:
                    Menu.displayFoodItemsByCategory(Methods.getFoodItemList(),FoodItemType.DESERTS);
                    Methods.takeOrder();
                    Methods.printArrayList();
                    Methods.getBill();
                    break;
                case 4:
                    Menu.displayMenu();
                    Methods.takeOrder();
                    Methods.printArrayList();
                    Methods.getBill();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }



        }
        else {
            System.out.println("Sorry You Are Not Registered");
        }
}
public static void case2()
    {
        //Customer.createNewCustomer();
        Methods.getCustomerArrayList().add(Customer.createNewCustomer());
        //System.out.println(Methods.getCustomerArrayList());
        System.out.println("You Have Successfully Registered");
    }
    public static void case3(){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        System.out.println("Enter Your Credentials");
        System.out.println("Enter Your Admin-Name:");
        username = sc.nextLine();
        System.out.println("Enter Your Admin Password:");
        password = sc.nextLine();
        if (Methods.ifAdminPresent(username,password)==true){
            System.out.println("You Have Successfully Entered As An Admin");
            System.out.println("Enter 1 To Add Item To The Menu");
            System.out.println("Enter 2 to Remove Item From The Menu");
            int input1 = sc.nextInt();
            switch (input1) {
                case 1:
                    FoodItem item = FoodItem.createNewFoodItem();
                    Methods.getFoodItemList().add(item);
                    System.out.println("The Following Item Has Been Added");
                    System.out.println(item);
                    break;
                case 2:
                    Menu.displayMenu();
                    System.out.println("Enter The Id Of Item You Want To Remove");
                    int removeId= sc.nextInt()-1;
                    sc.nextLine();
                    //Methods.getFoodItemList().remove(removeId);
                    FoodItem item2 = Methods.getFoodItemList().remove(removeId);
                    System.out.println("The Following Item Has Been Removed:");
                    System.out.println(item2);
                    System.out.println("The Updated Menu Is:");
                    Menu.displayMenu();
                    break;


            }
        }
    }
}