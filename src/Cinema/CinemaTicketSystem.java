package Cinema;

import java.util.Scanner;

public class CinemaTicketSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\033[32mWelcome to the Cinema Ticket System!\033[0m");

        int movieChoice;
        do {
            System.out.println("\033[32mPlease select a movie to watch:\033[0m");
            System.out.println("1 - Paper Towns");
            System.out.println("2 - Money Heist");
            System.out.println("3 - Matrix");

            movieChoice = sc.nextInt();

            if (movieChoice < 1 || movieChoice > 3) {
                System.out.println("\033[31mInvalid choice. Please select a movie from 1 to 3 from the list.\033[0m");
            }
        } while (movieChoice < 1 || movieChoice > 3);

        Movie[] movies = {
                new Movie("Paper Towns"),
                new Movie("Money Heist"),
                new Movie("Matrix")
        };

        Movie movie = movies[movieChoice - 1];

        System.out.println("\u001B[32mYou have selected \u001B[0m" + movie.getMovieName());

        System.out.println("\u001B[32mPlease select a ticket type: \u001B[0m");
        System.out.println("1 - Adult");
        System.out.println("2 - Child");
        System.out.println("3 - Student");
        System.out.println("4 - Family");

        int ticketTypeChoice = sc.nextInt();

        Ticket ticket = new Ticket(ticketTypeChoice);

        System.out.println("\u001B[32mTicket type chosen: \u001B[0m" + ticket.getTicketType());
        System.out.println("Price: $" + ticket.getTicketPrice());

        System.out.println("\u001B[32mDo you have a discount code?\u001B[0m yes/no");
        String discountCodeAnswer = sc.next();


        while (!discountCodeAnswer.equalsIgnoreCase("yes") && !discountCodeAnswer.equalsIgnoreCase("no")) {
            System.out.println("\033[31mInvalid answer.\033[0m Please enter '\u001B[32myes\u001B[0m' or '\u001B[32mno\u001B[0m'");
            discountCodeAnswer = sc.next();
        }

        if (discountCodeAnswer.equalsIgnoreCase("yes")) {
            System.out.println("\u001B[32mEnter your discount code: \u001B[0m");
            String discountCodeInput = sc.next();

            double discountedPrice = DiscountCode.applyDiscount(discountCodeInput, ticket.getTicketPrice());

            while (discountedPrice >= ticket.getTicketPrice()) {
                System.out.println("\033[31mInvalid discount code. Please enter a valid discount code.\033[0m");
                discountCodeInput = sc.next();
                discountedPrice = DiscountCode.applyDiscount(discountCodeInput, ticket.getTicketPrice());
            }

            ticket.setTicketPrice(discountedPrice);
            System.out.println("\n\n" + "Discount code applied. \n\n\u001B[32mNew ticket price: \u001B[0m$" + ticket.getTicketPrice() * 0.6);
        }

        if (discountCodeAnswer.equalsIgnoreCase("no")) {
            System.out.println("No discount applied.");
            System.out.println("\u001B[32mYour ticket price:\u001B[0m$" + ticket.getTicketPrice());
        }


        System.out.println("\u001B[32mThank you for using our Ticket System. Have a great event!\u001B[0m");
    }
}

