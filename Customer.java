// ============================================================
//  Customer.java
//  OWNER: Member 2 (Customer & Rental records)
//  A simple class that holds the information of one customer.
// ============================================================

public class Customer {

    private String name;    // customer name
    private String phone;   // customer phone number

    // Constructor
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters
    public String getName()  { return name; }
    public String getPhone() { return phone; }

    public String toString() {
        return name + " (" + phone + ")";
    }
}
