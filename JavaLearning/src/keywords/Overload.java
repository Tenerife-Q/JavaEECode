package keywords;

//方法重载  同类下方法名相同 参数不同
public class Overload {
    public static void main(String[] args) {
        fun(5,6.4);
    }

    public static void fun(int a,int b){
        System.out.println(a+b);
    }

    public static void fun(int a,double b){
        System.out.println(a+b);
    }
}
