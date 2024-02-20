public class Test {
    public static void main(String[] args) {
        Product p1= new Product("LED",500,50,new Date(3,5,2003));
        Date d3 = new Date(30,5,2003);
        Product p2= new Product("Mouse",25,20,d3);
        System.out.println("Id\tName\t    Price\tQuantity\tMFG Date");
        System.out.println(p1);
        System.out.println(p2);
    }

}
