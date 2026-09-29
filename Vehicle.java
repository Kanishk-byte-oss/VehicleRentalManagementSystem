// ============================================================
//  Vehicle.java
//  OWNER: Member 1 (Vehicle Management)
//  A simple class (OOP) that holds the information of one vehicle.
// ============================================================

public class Vehicle {

    // ---- Data members (variables of each vehicle) ----
    private String vehicleId;    // example: "V101"
    private String name;         // example: "Swift"
    private String type;         // example: "Car" / "Bike"
    private double ratePerDay;   // rent charge per day
    private boolean available;   // true = free, false = already rented

    // ---- Constructor: runs when we create a new Vehicle ----
    public Vehicle(String vehicleId, String name, String type, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.type = type;
        this.ratePerDay = ratePerDay;
        this.available = true;   // a new vehicle is available by default
    }

    // ---- Getters: used to READ the values ----
    public String getVehicleId() { return vehicleId; }
    public String getName()      { return name; }
    public String getType()      { return type; }
    public double getRatePerDay(){ return ratePerDay; }
    public boolean isAvailable() { return available; }

    // ---- Setter: used to CHANGE availability (rent / return) ----
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // ---- toString: how a vehicle looks when we print it ----
    public String toString() {
        String status = available ? "Available" : "Rented";
        return vehicleId + " | " + name + " (" + type + ") | Rs." + ratePerDay
                + "/day | " + status;
    }
}
