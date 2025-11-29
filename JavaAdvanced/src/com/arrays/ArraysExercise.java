package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/20 17:16
 */
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("西游记",80.5);
        books[1] = new Book("红楼",12.3);
        books[2] = new Book("三国演义",65.9);
        books[3] = new Book("水浒英雄传",777.7);


        //(1)价格降序
        Arrays.sort(books,new Comparator(){

            @Override
            public int compare(Object o1,Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                double priceVar = b1.getPrice() - b2.getPrice();
                //只需要返回一个正数和负数 与数值大小无关
                //升序或是降序 只需要改变前后的 < > 的先后顺序
                if(priceVar < 0){
                    return 1;
                } else if (priceVar > 0){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        //(2)价格升序
        Arrays.sort(books,new Comparator(){

            @Override
            public int compare(Object o1,Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return (int)(b1.getPrice() - b2.getPrice());
            }
        });
        System.out.println(Arrays.toString(books));


        //(3)书名长度升序 需要变化方向 就可以交换b1b2顺序 用 b2 - b1
        Arrays.sort(books,new Comparator(){

            @Override
            public int compare(Object o1,Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return b1.getTitle().length() - b2.getTitle().length();
            }
        });
        System.out.println(Arrays.toString(books));


        //(4)Lambda表达式 代替匿名内部类实现接口 升序价格
        Arrays.sort(books, (o1, o2) -> {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
            return Double.compare(b1.getPrice(), b2.getPrice());
        });

        System.out.println(Arrays.toString(books));


        //(5)Lambda  应用于函数式接口 且此接口只有一个抽象类方法
        Arrays.sort(books, (o1, o2) -> {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
            // 例如按书名长度降序
            if (b1.getTitle().length() > b2.getTitle().length()) {
                return -1;
            } else if (b1.getTitle().length() < b2.getTitle().length()) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println(Arrays.toString(books));
    }
}

/**
 * Comparator 是个接口。
 * new Comparator() { ... } 是一个匿名内部类，它实现了这个接口。
 * 匿名内部类是类，不是接口。但它必须实现接口中的所有抽象方法。
 * 只需要考虑传回来的值是正数或是负数
 */

class Book{
    private String title;
    private double price;

    public Book( String title, double price) {
        this.price = price;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
