// ============================================================
//  Rental.java
//  OWNER: Member 2 (Customer & Rental records)
//  One "Rental" object = one rental transaction (one bill).
//  These objects are stored in a LinkedList (see RentalManager).
// ============================================================

public class Rental {

    private String vehicleId;    // which vehicle was rented
    private String customerName; // who rented it
    private int days;            // for how many days
    private double charge;       // total money to pay

    // Constructor
    public Rental(String vehicleId, String customerName, int days, double charge) {
        this.vehicleId = vehicleId;
        this.customerName = customerName;
        this.days = days;
        this.charge = charge;
    }

    // Getters
    public String getVehicleId()    { return vehicleId; }
    public String getCustomerName() { return customerName; }
    public int getDays()            { return days; }
    public double getCharge()       { return charge; }

    public String toString() {
        return customerName + " rented " + vehicleId + " for " + days
                + " day(s) = Rs." + charge;
    }
}
