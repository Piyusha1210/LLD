import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTicketBookingSystem {
    List<Movie> movies;
    List<Theater> theaters;
    Map<Movie, List<Theater>> movieTheatreMap;
    Map<Theater, List<Show>> theaterShowMap;

    private static MovieTicketBookingSystem instance;

    private MovieTicketBookingSystem() {
        movies = new ArrayList<>();
        theaters = new ArrayList<>();
        movieTheatreMap = new HashMap<>();
        theaterShowMap = new HashMap<>();
    }

    public static MovieTicketBookingSystem getInstance() {
        if(instance == null) {
            instance = new MovieTicketBookingSystem();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movieTheatreMap.put(movie, new ArrayList<>());
    }

    public void addTheatre(Theater theater) {
        theaters.add(theater);
        theaterShowMap.put(theater, new ArrayList<>());
    }

    public void getMovies() {
        for(Movie movie: movies) {
            System.out.println(movie);
        }
    }

    public void getAvailableShows(Movie movie) {
        List<Theater> theaters = movieTheatreMap.get(movie);
        for(Theater theater : theaters) {
            System.out.println("Theatre: " + theater.getTheatreName());
            for(Show show: theaterShowMap.get(theater)) {
                System.out.println("Shows: " + show.getStartTime());
            }
        }
        System.out.println();
    }

    public void addShow(Movie movie, Theater theater, Show show) {
        boolean isPresent = false;
        for(Theater theater1: movieTheatreMap.get(movie)) {
            if(theater1.getTheatreName().equals(theater.getTheatreName())) {
                isPresent = true;
            }
        }
        if(!isPresent) {
            movieTheatreMap.get(movie).add(theater);
        }
        theaterShowMap.get(theater).add(show);
    }

    public void bookTicket(Movie movie, Theater theater, Show show, Seat seat) {
        if(seat.isAvailable()) {
            seat.book();
            System.out.println("Ticket booked successfully for " + movie.getMovieName() + " at " +
                    theater.getTheatreName() + " for show at " + show.getStartTime() + "\n");
        } else {
            System.out.println("Sorry, seat " + seat.getSeatNumber() + " is not available for booking." + "\n");
        }
    }
}
