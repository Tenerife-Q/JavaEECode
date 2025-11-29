package person;
public class Test4 {
    public static void main(String[] args) {
        int a = 5;
        fun(a);
        System.out.println(a);
    }
    //基本数据类型 值传递 与引用传递不同 是将a的值赋给b
    public static void fun(int b){
        b = 10;//这里后面又改成了b = 10
        System.out.println(b);
    }
}
