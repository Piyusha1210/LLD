public class Movie {
    private String movieName;
    private Double rating;

    public Movie(String movieName, Double rating) {
        this.movieName = movieName;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }
}
