package org.example.model;

public class Movie {
    private static int moviesCount = 0;

    private int id;
    private String title;
    private String genre;
    private int year;

    public Movie(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.id = moviesCount++;
    }

    public String getInfo() {
        return title + " (жанр: " + genre + ", " + year + ")";
    }

    public String getInfoWithId() {
        return "ID=" + id + " " + title + " (жанр: " + genre + ", " + year + ")";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (year != movie.year) return false;
        if (!title.equals(movie.title)) return false;
        return genre.equals(movie.genre);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + year;
        return result;
    }
}
