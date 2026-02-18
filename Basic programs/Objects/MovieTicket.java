class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    MovieTicket(String movieName) {
        this.movieName = movieName;
    }
    void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully.");
    }
    void displayDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket("Inception");
        t1.bookTicket("A12", 250);
        t1.displayDetails();
    }
}
