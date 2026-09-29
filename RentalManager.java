// ============================================================
//  RentalManager.java
//  This is the "brain" of the project. It stores all the data
//  and does all the work. It uses ALL FOUR data structures.
//
//  Shared file. Method owners are marked in comments:
//    Member 1 -> arrays (vehicle storage)
//    Member 3 -> HashMap (search) + TreeMap (sorted)
//    Member 4 -> LinkedList (rental records) + rent/return/charges
// ============================================================

import java.util.LinkedList;   // for rental records
import java.util.HashMap;      // for fast search by vehicle ID
import java.util.TreeMap;      // for automatically sorted vehicles
import java.util.Map;          // used when looping over maps

public class RentalManager {

    // ---------- 1) ARRAY : stores all vehicles (Member 1) ----------
    private Vehicle[] vehicles = new Vehicle[100]; // can hold up to 100
    private int count = 0;                          // how many added so far

    // ---------- 2) HASHMAP : search a vehicle by its ID (Member 3) ----------
    private HashMap<String, Vehicle> vehicleMap = new HashMap<>();

    // ---------- 3) TREEMAP : same vehicles but always sorted by ID (Member 3) ----------
    private TreeMap<String, Vehicle> sortedVehicles = new TreeMap<>();

    // ---------- 4) LINKEDLIST : stores every rental record (Member 4) ----------
    private LinkedList<Rental> rentalRecords = new LinkedList<>();

    // Constructor: add some sample vehicles so the app is not empty
    public RentalManager() {
        addVehicle(new Vehicle("V101", "Swift",     "Car",  1500));
        addVehicle(new Vehicle("V102", "Fortuner",  "Car",  4000));
        addVehicle(new Vehicle("V103", "Activa",    "Bike", 400));
        addVehicle(new Vehicle("V104", "Bullet",    "Bike", 800));
        addVehicle(new Vehicle("V105", "Innova",    "Car",  3000));
    }

    // ============================================================
    //  MEMBER 1 : add a vehicle into the ARRAY
    //  (we also copy it into the HashMap and TreeMap so all three
    //   structures stay in sync)
    // ============================================================
    public void addVehicle(Vehicle v) {
        vehicles[count] = v;              // store in array
        count++;                          // move to next empty slot
        vehicleMap.put(v.getVehicleId(), v);      // store in HashMap
        sortedVehicles.put(v.getVehicleId(), v);  // store in TreeMap
    }

    // Show ALL vehicles from the ARRAY (Member 1)
    public String getAllVehicles() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += vehicles[i] + "\n";
        }
        return result;
    }

    // Show only AVAILABLE vehicles from the ARRAY (Member 1)
    public String getAvailableVehicles() {
        String result = "";
        for (int i = 0; i < count; i++) {
            if (vehicles[i].isAvailable()) {
                result += vehicles[i] + "\n";
            }
        }
        if (result.equals("")) result = "No vehicles available right now.";
        return result;
    }

    // ============================================================
    //  MEMBER 3 : SEARCH a vehicle by ID using the HASHMAP (fast!)
    // ============================================================
    public Vehicle searchVehicle(String id) {
        return vehicleMap.get(id);   // returns the vehicle, or null if not found
    }

    // ============================================================
    //  MEMBER 3 : show all vehicles in SORTED order using the TREEMAP
    // ============================================================
    public String getSortedVehicles() {
        String result = "";
        // TreeMap automatically keeps keys (IDs) in sorted order
        for (Map.Entry<String, Vehicle> entry : sortedVehicles.entrySet()) {
            result += entry.getValue() + "\n";
        }
        return result;
    }

    // ============================================================
    //  MEMBER 4 : RENT a vehicle
    //  Steps: find vehicle -> check availability -> mark rented ->
    //         calculate charge -> save record in LinkedList
    // ============================================================
    public String rentVehicle(String id, String customerName, int days) {
        Vehicle v = searchVehicle(id);           // uses HashMap search

        if (v == null) {
            return "Vehicle ID " + id + " not found.";
        }
        if (!v.isAvailable()) {
            return v.getName() + " is already rented.";
        }

        double charge = calculateCharge(v, days); // calculate money
        v.setAvailable(false);                     // mark as rented

        // create a record and add it to the LinkedList
        Rental record = new Rental(id, customerName, days, charge);
        rentalRecords.add(record);

        return "Rented " + v.getName() + " to " + customerName
                + " for " + days + " day(s).\nTotal charge = Rs." + charge;
    }

    // ============================================================
    //  MEMBER 4 : RETURN a vehicle (make it available again)
    // ============================================================
    public String returnVehicle(String id) {
        Vehicle v = searchVehicle(id);

        if (v == null) {
            return "Vehicle ID " + id + " not found.";
        }
        if (v.isAvailable()) {
            return v.getName() + " was not rented.";
        }

        v.setAvailable(true);   // now free again
        return v.getName() + " returned successfully.";
    }

    // ============================================================
    //  MEMBER 4 : calculate rental charge = rate per day * number of days
    // ============================================================
    public double calculateCharge(Vehicle v, int days) {
        return v.getRatePerDay() * days;
    }

    // ============================================================
    //  MEMBER 4 : show all rental records from the LINKEDLIST
    // ============================================================
    public String getRentalRecords() {
        if (rentalRecords.isEmpty()) {
            return "No rentals done yet.";
        }
        String result = "";
        int no = 1;
        for (Rental r : rentalRecords) {
            result += no + ". " + r + "\n";
            no++;
        }
        return result;
    }
}
