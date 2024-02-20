

public class CircleTest{

    public static void main(String[] args) {

        Circle c1 = new Circle(0,0,20);
        Circle c2 = new Circle(0,0,10);
        

    System.out.println("The Area Of Circle 1 Is "+ c1.calArea());
    System.out.println("The Area Of Circle 2 Is "+ c2.calArea());
    System.out.println("The Circumference Of The Circle 1 Is "+c1.calCircumference());
    System.out.println("The Circumference Of The Circle 2 Is "+c2.calCircumference());

    Circle temp = Circle.getLargestCircle(c1,c2);
    temp.setRadius(5);
    System.out.println(temp.getRadius());
    System.out.println("The Area Of Circle 1 Is "+ c1.calArea());
    System.out.println("The Circumference Of The Circle 1 Is "+c1.calCircumference());
    System.out.println(c1);
    System.out.println(c2);

    c2.setRadius(15);

    double radius=c2.getRadius();
    System.out.println(radius);

    }






}