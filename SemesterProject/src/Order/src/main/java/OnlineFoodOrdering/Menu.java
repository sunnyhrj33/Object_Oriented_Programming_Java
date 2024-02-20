package OnlineFoodOrdering;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private ArrayList<FoodItem> menuItems;

    public Menu()
    {
        this.menuItems = new ArrayList<>();
    }

    public void addItem(FoodItem item)
    {
        menuItems.add(item);
    }
    public void removeItem(FoodItem item)
    {
        menuItems.remove(item);
    }
    public static void displayMenu()
    {
        System.out.println("Menu:");
        System.out.println("ID\tName\tPrice\tDescription");
        for(FoodItem item: Methods.getFoodItemList())
        {
            System.out.println(item.getItemId()+"\t"+item.getItemName()+"\t"+ item.getItemPrice()+"\t"+item.getItemDescription());
        }
    }
    public static void displayFoodItemsByCategory(ArrayList<FoodItem> foodItems, FoodItemType category)
    {
        System.out.println("Food Items in the " + category + " category:");
        for (FoodItem foodItem : foodItems)
        {
            if (foodItem.getFoodItemType() == category)
            {
                System.out.println("- " + foodItem.getItemName());
            }
            else
                System.out.println("No Items Found");
            break;
        }
    }

    public FoodItem getItem(int itemId)
    {
        for (FoodItem item : menuItems )
        {
            if (item.getItemId() == itemId)
            {
                return item;
            }
        }
        return null;
    }
    public ArrayList<FoodItem> getMenuItems()
    {
        return menuItems;
    }

    public void setMenuItems(ArrayList<FoodItem> menuItems)
    {
        this.menuItems = menuItems;
    }
}
