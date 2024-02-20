package OnlineFoodOrdering;
import java.util.Scanner;
public class FoodItem
{
    private int itemId;
    private String itemName;
    private double itemPrice;
    private String itemDescription;
    private FoodItemType foodItemType;


    public FoodItem(int itemId,String itemName,Double itemPrice,String itemDescription,FoodItemType foodItemType)
    {
        this.itemId=itemId;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.itemDescription=itemDescription;
        this.foodItemType=foodItemType;
    }

    public FoodItemType getFoodItemType() {
        return foodItemType;
    }

    public void setFoodItemType(FoodItemType foodItemType) {
        this.foodItemType = foodItemType;
    }

    public int getItemId()
    {
        return itemId;
    }

    public void setItemId(int itemId)
    {
        this.itemId = itemId;
    }

    public double getItemPrice()
    {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice)
    {
        this.itemPrice = itemPrice;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }
    public static FoodItem createNewFoodItem()
    {
        Scanner sc = new Scanner(System.in);
        String itemName;
        double price;
        FoodItemType foodItemType1;
        int i=4;
        System.out.println("Enter Item Details");
        System.out.println();
        System.out.println("Enter Item Name:");
        itemName = sc.nextLine();
        System.out.println("Enter Item Price:");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Item Description:");
        String description = sc.nextLine();
        System.out.println("Enter Item Category(Starters/MainCourse/Deserts):");
        foodItemType1 = FoodItemType.valueOf((sc.next().toUpperCase()));
        return new FoodItem(i,itemName,price,description,foodItemType1);
    }
    @Override
    public String toString() {
        return "FoodItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDescription='" + itemDescription + '\'' +
                ", foodItemType=" + foodItemType +
                '}';
    }
}
