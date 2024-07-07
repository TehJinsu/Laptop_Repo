package com.example.moviedb;

public class Movie {

    public int id;
    public String name, director, genre;
    public int releaseYear;
    public double rating;

    public Movie() {
    }

    public Movie (int id, String name, String director, String genre, int releaseYear, double rating) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " (" + releaseYear + ")";
    }

    @Override
    public int compareTo(Movie movie) {
        //sort by name
        return toString().compareTo(movie.toString());
    }


}
