package com.list_.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 20:03
 */
public class MovieService {
    //准备集合容器，存储全部上架电影数据
    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void start() {
        //准备操作界面
        while (true) {
            System.out.println("=========电影信息操作系统========");
            System.out.println("1. 上架");
            System.out.println("2. 下架");
            System.out.println("3. 查询");
            System.out.println("4. 封杀");
            System.out.println("5. 展示");
            System.out.println("6. 退出");
            System.out.println("亲你输入操作命令：");
            String command = sc.next();
            switch (command) {
                case "1":
                    addMovie();
                    break;
                case "2":
                    downMovie();
                    break;
                case "3":
                    queryMovie();
                    break;
                case "4":
                    deleteStar();
                    break;
                case "5":
                    System.out.println("退出成功");
                    return;
                case "6":
                    showAllMovies();
                default:
                    System.out.println("wrong...please try again");

            }
        }
    }

    //API
    private void showAllMovies() {
        System.out.println("show all movies: ");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private void deleteStar() {
        System.out.println("=============封杀明星=============");
        System.out.println("input star you want to delete: ");
        String star = sc.nextLine();

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(star)) {
                movies.remove(movie);
                System.out.println("successfully delete " + movie.getName());
                i--;
            }
        }
        //展示全部电影确认
        showAllMovies();
    }

    private void downMovie() {
        //下架电影
        System.out.println("=============下架电影=============");
        System.out.println("please enter the name of the movie you want to down: ");
        String name = sc.next();
        Movie m = queryMovieByName(name);
        if (m != null) {
            movies.remove(m);
            System.out.println(movies);
        } else {
            System.out.println("didn't find any movie with the name " + name);
        }
    }

    private void queryMovie() {
        //根据电影名称查询并展示
        System.out.println("=============查询电影=============");
        System.out.println("please input movie name:");
        String name = sc.nextLine();
        Movie m = queryMovieByName(name);
        if (m != null) {
            System.out.println(m);
        } else {
            System.out.println("doesn't exist");
        }

    }

    //根据电影名称查询并返回 API
    public Movie queryMovieByName(String n) {
        for (Movie m : movies) {
            if (m.getName().equals(n)) {
                return m;
            }
        }
        return null;
    }

    private void addMovie() {
        System.out.println("=============上架电影=============");

        Movie movie1 = new Movie("The Tenerife Sea", 10, "Tenerife", 998);
        Movie movie = new Movie();

        System.out.println("input name: ");
        movie.setName(sc.nextLine());
        System.out.println("input score: ");
        movie.setScore(sc.nextDouble());
        System.out.println("input actor: ");
        movie.setActor(sc.nextLine());
        System.out.println(("input price: "));
        movie.setPrice(sc.nextDouble());

        movies.add(movie1);
        movies.add(movie);
        System.out.println("上架成功");
    }
}
