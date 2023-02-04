package Cinema;

import java.util.Scanner;

public class CinemaTicketSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Cinema Ticket System");

        int movieChoice;
        do {
            System.out.println("Please select a movie to watch");
            System.out.println("1 - Paper Towns");
            System.out.println("2 - Money Heist");
            System.out.println("3 - Matrix");

            movieChoice = sc.nextInt();

            if (movieChoice < 1 || movieChoice > 3) {
                System.out.println("Invalid choice. Please select a movie from 1 to 3.");
            }
        } while (movieChoice < 1 || movieChoice > 3);

        Movie[] movies = {
                new Movie("The Dark Knight"),
                new Movie("Inception"),
                new Movie("Matrix")
        };

        Movie movie = movies[movieChoice - 1];

        System.out.println("You have selected " + movie.getMovieName() + ".");

        System.out.println("Please select a ticket type.");
        System.out.println("1 - Adult");
        System.out.println("2 - Child");
        System.out.println("3 - Student");
        System.out.println("4 - Family");

        int ticketTypeChoice = sc.nextInt();

        Ticket ticket = new Ticket(ticketTypeChoice);

        System.out.println("Ticket type chosen: " + ticket.getTicketType());
        System.out.println("Price: $" + ticket.getTicketPrice());

        System.out.println("Do you have a discount code? (yes/no)");
        String discountCodeAnswer = sc.next();

        if (discountCodeAnswer.equalsIgnoreCase("yes")) {
            System.out.println("Enter your discount code:");
            String discountCodeInput = sc.next();

            double discountedPrice = DiscountCode.applyDiscount(discountCodeInput, ticket.getTicketPrice());

            if (discountedPrice < ticket.getTicketPrice()) {
                ticket.setTicketPrice(discountedPrice);
                System.out.println("\n" + "Discount code applied. New ticket price: $" + ticket.getTicketPrice() * 0.6);
            } else {
                System.out.println("Invalid discount code. No discount applied.");
            }
        }

        if (discountCodeAnswer.equalsIgnoreCase("no")) {
            System.out.println("No discount applied.");
        }

        System.out.println("Thank you for using our Ticket System. Have a great event!");
    }
}

