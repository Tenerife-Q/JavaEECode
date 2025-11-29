package com.list_.exercise;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 19:58
 */
public class Movie {
    private String name;
    private double score;
    private String actor;
    private double price;

    public Movie() {}

    public Movie(String name, double score, String actor, double price) {
        this.name = name;
        this.score = score;
        this.actor = actor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", actor='" + actor + '\'' +
                ", price=" + price +
                '}';
    }
}
