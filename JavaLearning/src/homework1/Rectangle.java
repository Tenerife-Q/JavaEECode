package homework1;

public class Rectangle {
    double width;
    double height;

    public void area(){
        System.out.println("Area of Rectangle:" + width * height);
    }

    public void perimeter(){
        System.out.println("Perimeter of Rectangle:" + (width + height) * 2);
    }
}
