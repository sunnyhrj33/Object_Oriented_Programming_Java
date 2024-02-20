public class Circle {

    private int x;
    private int y;
    private double radius;


    Circle (int x,int y,double radius ){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }
    public void setX(int x){
        this.x=x;
    }
    public double getX(){
        return x;
    }
    public void setY(int y){
        this.y=y;
    }
    public double getY(){
        return y;
    }
    public void setRadius(double radius){
        if(radius>=0)
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public double calArea(){
        return Math.PI*radius*radius;
    }
    public double calCircumference(){
        return Math.PI*2*radius;
    }

    public static Circle getLargestCircle(Circle circle1,Circle circle2)
    {
        if (circle1.radius<circle2.radius)
            return circle2;
        else
            return circle1;
    }

    public Circle clone(){
        return new Circle(this.x,this.y,this.radius);
    }


    public String toString() {
        String circleDetails = String.format("%d,%d,%.2f", x, y, radius);
        return circleDetails;
    }
}
