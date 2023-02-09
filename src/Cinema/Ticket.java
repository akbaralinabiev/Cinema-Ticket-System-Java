package Cinema;

public class Ticket {

    private String ticketType;
    private double ticketPrice;

    public Ticket(int ticketTypeChoice) {
        switch(ticketTypeChoice) {
            case 1:
                ticketType = "Adult";
                ticketPrice = 12.00;
                break;
            case 2:
                ticketType = "Child";
                ticketPrice = 8.00;
                break;
            case 3:
                ticketType = "Student";
                ticketPrice = 10.00;
                break;
            case 4:
                ticketType = "Family";
                ticketPrice = 35.00;
                break;
            default:
                System.out.println("\033[31mDefault guess!\033[0m");
        }
    }

    public Ticket(String ticketType, double ticketPrice) {
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketType() {
        return ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double discountedPrice) {

    }
}

