package Chapter4.Example8;

public class Circular { 
    Circle bottom; //Circular组合了Circle，声明一个对象bottom，默认值为null，注意组合的时候不要用new
    double height;
    void setBottom(Circle c) { //实参传值给c赋给bottom
       bottom = c;
    }
    void setHeight(double h) {
       height = h;
    }
    double getVolme() {
       if(bottom == null)  //没有传值时
          return -1;
       else
          return bottom.getArea()*height/3.0; //如果不是空值，计算圆锥体积
    }
    double getBottomRadius() {  //查看底部半径,使用Circle类的方法
       return bottom.getRadius();
    }
    public void setBottomRadius(double r){
       bottom.setRadius(r);
    } 
}
