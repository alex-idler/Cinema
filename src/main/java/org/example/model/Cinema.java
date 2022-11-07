package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cinema {
    private List<Session> sessionList;
    private List<Movie> movieList;
    public Cinema() {
        initialize();
    }

    private void initialize() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Avatar", "Adventure", 2009));
        movieList.add(new Movie("The Lord of the Rings", "Adventure", 2001));
        movieList.add(new Movie("Groundhog Day", "Comedy", 1993));
        movieList.add(new Movie("Bridget Jones’s Diary", "Romantic comedy", 2001));
        movieList.add(new Movie("The Prestige", "Thriller", 2006));

        sessionList = new ArrayList<>();
        sessionList.add(new Session(movieList.get(0), LocalDateTime.of(2022, 11, 10, 10, 20)));
        sessionList.add(new Session(movieList.get(0), LocalDateTime.of(2022, 11, 10, 14, 00)));
        sessionList.add(new Session(movieList.get(0), LocalDateTime.of(2022, 11, 10, 18, 00)));
        sessionList.add(new Session(movieList.get(1), LocalDateTime.of(2022, 11, 11, 9, 10)));
        sessionList.add(new Session(movieList.get(2), LocalDateTime.of(2022, 11, 11, 13, 40)));
        sessionList.add(new Session(movieList.get(3), LocalDateTime.of(2022, 11, 11, 17, 00)));
        sessionList.add(new Session(movieList.get(4), LocalDateTime.of(2022, 11, 12, 10, 30)));
        sessionList.add(new Session(movieList.get(4), LocalDateTime.of(2022, 11, 12, 14, 00)));
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Movie getMovieById(int id) {
        for(Movie movie : movieList) {
            if(movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(String title, String genre, int year) {
        movieList.add(new Movie(title, genre, year));
    }

    public void addSession(int movieId, int year, int month, int day, int hour, int minute) {
        sessionList.add(new Session(getMovieById(movieId), LocalDateTime.of(year, month, day, hour, minute)));
    }
}
