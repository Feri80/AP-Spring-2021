/**
 * TicketMachine models a naive ticket machine that issues flat-fare tickets.
 * The price of a ticket is specified via the constructor. It is a naive machine
 * in the sense that it trusts its users to insert enough money before trying to
 * print a ticket. It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class TicketMachineBetter2 {
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //
    private int amountToRefund;

    /**
     * Create a machine that issues tickets of the given price. Note that the price
     * must be greater than zero, and there are no checks to ensure this.
     */
    public TicketMachineBetter2(int cost) {
        if (cost > 0)
            price = cost;
        else
            price = 10;
        amountToRefund = 0;
        balance = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return the amount of money already inserted for the next ticket.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Use a positive amount: " + amount);

        }
    }

    /**
     * Print a ticket. Update the total collected and reduce the balance to zero.
     */
    public void printTicket() {
        if (balance > price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            amountToRefund = balance - price;
            balance = price;
        }

        // Update the total collected with the balance.
        total = total + balance;
        // Clear the balance.
        balance = 0;
    }
    public void refundBalance()
    {
        if(amountToRefund > 0)
            System.out.println("Collect refund!");
        amountToRefund = 0;
    }
}
