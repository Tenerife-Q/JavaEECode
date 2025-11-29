package Chapter4.Example8;

public class Circle { 
    double radius,area;  //半径，面积，默认值为0
    void setRadius(double r) { //调用setRadius(）改变半径值
        radius=r;
    } 
    double getRadius() { //调用getRadius()，返回查看半径值
        return radius;
    }
    double getArea(){
        area=3.14*radius*radius;
        return area;
    }
}
