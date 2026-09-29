# Vehicle Rental Management System

A Java-based **Vehicle Rental Management System** developed using **Java Swing** and Java Collections/Data Structures. The application provides a simple graphical interface for managing vehicles, searching vehicles, checking availability, renting and returning vehicles, calculating rental charges, and viewing rental records.

## Project Overview

The Vehicle Rental Management System is designed to demonstrate practical use of **Object-Oriented Programming (OOP)** concepts and multiple data structures in Java.

The system maintains vehicle information and rental transactions while providing a user-friendly Swing GUI.

### Main Operations

- Display all vehicles
- Display available vehicles
- Search for a vehicle using Vehicle ID
- Display vehicles in sorted order
- Rent a vehicle
- Return a rented vehicle
- Calculate rental charges
- Store and display rental records

## Key Features

### 1. Vehicle Management
The system stores details such as:

- Vehicle ID
- Vehicle name
- Vehicle type
- Rental rate per day
- Availability status

Sample vehicles included in the application:

| Vehicle ID | Vehicle | Type | Rate/Day |
|---|---|---|---:|
| V101 | Swift | Car | Rs. 1500 |
| V102 | Fortuner | Car | Rs. 4000 |
| V103 | Activa | Bike | Rs. 400 |
| V104 | Bullet | Bike | Rs. 800 |
| V105 | Innova | Car | Rs. 3000 |

### 2. Vehicle Search
A `HashMap` is used to search vehicles quickly using their Vehicle ID.

Example:

```text
V101
```

returns the corresponding Swift vehicle.

### 3. Sorted Vehicle Display
A `TreeMap` stores vehicles using their IDs as keys. It automatically maintains the vehicles in sorted order.

### 4. Vehicle Rental
The user can enter:

- Vehicle ID
- Customer name
- Number of rental days

The system checks whether the vehicle exists and is available before renting it.

### 5. Rental Charge Calculation

The rental charge is calculated using:

```text
Total Charge = Rate Per Day × Number of Days
```

For example:

```text
Swift = Rs. 1500/day
Days = 3

Total Charge = 1500 × 3
             = Rs. 4500
```

### 6. Vehicle Return
After a vehicle is returned, its availability status changes from:

```text
Rented → Available
```

### 7. Rental Records
Every completed rental transaction is stored in a `LinkedList` and can be displayed using the **Rental Records** button.

## Technologies Used

- **Programming Language:** Java
- **GUI:** Java Swing
- **Data Structures:** Array, HashMap, TreeMap, LinkedList
- **Concepts:** OOP, Encapsulation, Constructors, Methods, Collections, Event Handling
- **IDE:** Any Java-supported IDE such as IntelliJ IDEA, Eclipse, NetBeans, or VS Code

## Data Structures Used

| Data Structure | Purpose |
|---|---|
| Array | Stores the collection of vehicles |
| HashMap | Fast vehicle search using Vehicle ID |
| TreeMap | Stores vehicles in sorted Vehicle ID order |
| LinkedList | Stores rental transaction records |

## Object-Oriented Programming Concepts

### Encapsulation
Vehicle, Customer, and Rental classes keep their data members private and provide public getter/setter methods where required.

Example:

```java
private String vehicleId;
private String name;
private double ratePerDay;
```

### Classes and Objects
The project is divided into separate classes such as:

- `Vehicle`
- `Customer`
- `Rental`
- `RentalManager`
- `RentalGUI`

Objects of these classes are created and used to manage the application.

### Constructors
Constructors initialize objects with the required information.

Example:

```java
public Vehicle(String vehicleId, String name, String type, double ratePerDay)
```

### Abstraction
The `RentalManager` class hides the internal data-management operations from the GUI. The GUI calls methods such as:

```java
rentVehicle()
returnVehicle()
searchVehicle()
getAvailableVehicles()
```

## Project Structure

```text
VehicleRentalManagementSystem/
│
├── Vehicle.java
├── Customer.java
├── Rental.java
├── RentalManager.java
├── RentalGUI.java
└── README.md
```

## Description of Classes

### `Vehicle.java`

Represents an individual vehicle.

It contains:

- Vehicle ID
- Vehicle name
- Vehicle type
- Rental rate
- Availability status

### `Customer.java`

Represents customer information.

It stores:

- Customer name
- Customer phone number

### `Rental.java`

Represents a single rental transaction.

It stores:

- Vehicle ID
- Customer name
- Number of days
- Total rental charge

### `RentalManager.java`

This is the main logic/data-management class.

It manages:

- Vehicle array
- HashMap
- TreeMap
- LinkedList
- Vehicle searching
- Vehicle sorting
- Renting
- Returning
- Charge calculation
- Rental records

### `RentalGUI.java`

Provides the graphical user interface using Java Swing.

The interface contains:

- Vehicle ID input
- Customer input
- Days input
- Show All button
- Available button
- Search button
- Rent button
- Return button
- Sorted button
- Rental Records button

## Application Workflow

```text
Start Application
       |
       v
RentalGUI
       |
       v
RentalManager
       |
       +----------------------+
       |                      |
       v                      v
Vehicle Data             Rental Records
       |                      |
       +----------+-----------+
                  |
                  v
        User selects operation
                  |
        +---------+---------+
        |         |         |
      Search     Rent     Return
        |         |         |
        v         v         v
     HashMap   LinkedList  Update
     Search     Record     Status
```

## How to Run

### Prerequisites

Make sure Java is installed.

Check Java:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

### Compile the Project

Open Terminal in the project folder and run:

```bash
javac *.java
```

### Run the Application

Run:

```bash
java RentalGUI
```

The Vehicle Rental Management System GUI will open.

## How to Use

### Search a Vehicle

1. Enter a Vehicle ID such as `V101`.
2. Click **Search**.
3. The vehicle information will be displayed.

### Rent a Vehicle

1. Enter the Vehicle ID.
2. Enter the customer name.
3. Enter the number of days.
4. Click **Rent**.
5. The system calculates the total charge.
6. The vehicle becomes unavailable.
7. The rental transaction is stored.

### Return a Vehicle

1. Enter the Vehicle ID.
2. Click **Return**.
3. The vehicle becomes available again.

### View Rental Records

Click **Rental Records** to display all rental transactions stored by the application.

## Error Handling

The application performs basic validation, including:

- Checking whether required fields are filled
- Checking whether the Vehicle ID exists
- Checking whether a vehicle is already rented
- Checking whether the number of days is a valid number
- Checking whether a vehicle is available before renting

## Screenshots

Add project screenshots to a `screenshots` folder and update this section.

Example:

```text
screenshots/
├── main-window.png
├── search.png
├── rental.png
└── rental-records.png
```

Then add images like:

```markdown
![Main Window](screenshots/main-window.png)
![Rental Screen](screenshots/rental.png)
```

## Future Enhancements

Possible improvements for future versions include:

- Add, update, and delete vehicles through the GUI
- Add customer management
- Add persistent database storage
- Add login/authentication
- Add rental dates and return dates
- Add payment management
- Add advanced validation
- Add vehicle categories and filters
- Add a more advanced dashboard
- Generate rental receipts

## Learning Outcomes

This project demonstrates practical implementation of:

- Java classes and objects
- Encapsulation
- Constructors
- Methods
- Arrays
- HashMap
- TreeMap
- LinkedList
- Java Swing
- Event handling
- Searching
- Sorting
- Basic input validation
- CRUD-style management operations
- Modular Java programming

## Author

**Kanishk Singh**

Vehicle Rental Management System — Java Project
