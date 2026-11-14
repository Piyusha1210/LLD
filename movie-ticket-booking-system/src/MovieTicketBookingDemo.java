//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MovieTicketBookingDemo {
    public static void main(String[] args) {
        MovieTicketBookingSystem movieTicketBookingSystem = MovieTicketBookingSystem.getInstance();
        Movie endGame = new Movie("EndGame", 5.0);
        Movie dhurandhar = new Movie("Dhurandhar", 4.5);
        Movie dhurandhar2 = new Movie("Dhurandhar: The Revenge", 4.8);

        movieTicketBookingSystem.addMovie(endGame);
        movieTicketBookingSystem.addMovie(dhurandhar);
        movieTicketBookingSystem.addMovie(dhurandhar2);

        Theater nexusWhiteField = new Theater("Nexus WhiteField", "WhiteField");
        Theater nexusKormangala = new Theater("Nexus Kormanagala", "Kormangala");

        movieTicketBookingSystem.addTheatre(nexusWhiteField);
        movieTicketBookingSystem.addTheatre(nexusKormangala);

        Show show = new Show("Dhurandhar", 1000L, 1200L, 120L, 2, 10,
                10, 12, 1000, 500);

        Show show2 = new Show("Dhurandhar", 1300L, 1500L, 120L, 2, 10,
                10, 12, 1000, 500);

        movieTicketBookingSystem.addShow(dhurandhar, nexusWhiteField, show);
        movieTicketBookingSystem.addShow(dhurandhar, nexusWhiteField, show2);

        movieTicketBookingSystem.addShow(dhurandhar, nexusKormangala, show);
        movieTicketBookingSystem.addShow(dhurandhar, nexusKormangala, show2);

        movieTicketBookingSystem.getAvailableShows(dhurandhar);

        show.showAvailableSeats();

        Seat seat = show.getSeat("A7");
        movieTicketBookingSystem.bookTicket(dhurandhar, nexusWhiteField, show, seat);

        show.showAvailableSeats();
    }
}

/* Entities
* Movie
* Theater
* Show
*   timing
*   available seats
*   price
* */