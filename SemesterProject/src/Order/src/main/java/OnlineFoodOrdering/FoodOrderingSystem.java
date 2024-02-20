package OnlineFoodOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Menu menu = new Menu();

        Customer sunny = new Customer("sunny33","sunny123","sunnyhdxhd@gmail.com","113/H");
        Customer izza = new Customer("izza33","izza123","izzakhan@gmail.com","114/L");
        Methods.getCustomerArrayList().add(sunny);
        Methods.getCustomerArrayList().add(izza);

        FoodItem t1 = new FoodItem(1, "Burger", 5.99, "consisting of fillings—usually a patty of ground meat, typically beef—placed inside a sliced bun or bread roll", FoodItemType.MAINCOURSE);
        Methods.getFoodItemList().add(t1);
        FoodItem t2 = new FoodItem(2, "Pizza", 8.99, "flattened disk of bread dough topped with some combination of olive oil, oregano, tomato, olives, mozzarella or other cheese", FoodItemType.MAINCOURSE);
        Methods.getFoodItemList().add(t2);
        FoodItem t3 = new FoodItem(3, "Salad", 3.99, "Consisting of mixed ingredients, frequently vegetables", FoodItemType.MAINCOURSE);
        Methods.getFoodItemList().add(t3);
        //menu.displayMenu();
        //menu.removeItem(new FoodItem(2, "Pizza", 8.99, "flattened disk of bread dough topped with some combination of olive oil, oregano, tomato, olives, mozzarella or other cheese", FoodItemType.MainCourse));
        //menu.displayMenu();
        //menu.displayFoodItemsByCategory(menu.getMenuItems(),FoodItemType.Deserts);
        //menu.removeItem(t1);
        //menu.displayMenu();
        FoodItem t4 = new FoodItem(4, "Wraps", 6.79, "Tortilla Wrapped Around Zingered Chicken", FoodItemType.MAINCOURSE);
        //menu.addItem(t2);
        //menu.displayMenu();
        Order[] order = new Order[100];
        //List<Order> orders = new ArrayList<>();

        //orders.add(new Order(1, sunny, null, 740.5, "Placed"));
        //System.out.println(orders);
        Main main = new Main();
        main.main();


}}




