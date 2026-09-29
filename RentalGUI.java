// ============================================================
//  RentalGUI.java
//  OWNER: Member 5 (Swing GUI + Testing)
//  This is the SCREEN the user sees, built with Java Swing.
//  It also contains main() -> the starting point of the program.
// ============================================================

import javax.swing.*;      // Swing components (JFrame, JButton, etc.)
import java.awt.*;         // layout and colors

public class RentalGUI {

    // one RentalManager object = our data + logic
    private RentalManager manager = new RentalManager();

    // input boxes the user types into
    private JTextField idField       = new JTextField(8);
    private JTextField nameField     = new JTextField(8);
    private JTextField daysField     = new JTextField(4);

    // big box where results are shown
    private JTextArea output = new JTextArea(15, 40);

    public RentalGUI() {

        // ---- main window ----
        JFrame frame = new JFrame("Vehicle Rental Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ---- TOP: input fields ----
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Vehicle ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Customer:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Days:"));
        inputPanel.add(daysField);

        // ---- CENTER: output area (inside a scroll bar) ----
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);

        // ---- BOTTOM: buttons ----
        JPanel buttonPanel = new JPanel();
        JButton showAllBtn    = new JButton("Show All");
        JButton availableBtn  = new JButton("Available");
        JButton searchBtn     = new JButton("Search");
        JButton rentBtn       = new JButton("Rent");
        JButton returnBtn     = new JButton("Return");
        JButton sortedBtn     = new JButton("Sorted");
        JButton recordsBtn    = new JButton("Rental Records");

        buttonPanel.add(showAllBtn);
        buttonPanel.add(availableBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(rentBtn);
        buttonPanel.add(returnBtn);
        buttonPanel.add(sortedBtn);
        buttonPanel.add(recordsBtn);

        // ---- add the three panels to the window ----
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ============================================================
        //  BUTTON ACTIONS : what happens when each button is clicked
        //  (each one just calls a method in RentalManager)
        // ============================================================

        showAllBtn.addActionListener(e ->
            output.setText(manager.getAllVehicles()));

        availableBtn.addActionListener(e ->
            output.setText(manager.getAvailableVehicles()));

        sortedBtn.addActionListener(e ->
            output.setText(manager.getSortedVehicles()));

        recordsBtn.addActionListener(e ->
            output.setText(manager.getRentalRecords()));

        searchBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            Vehicle v = manager.searchVehicle(id);
            if (v == null) {
                output.setText("Vehicle ID " + id + " not found.");
            } else {
                output.setText("Found:\n" + v);
            }
        });

        rentBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            String customer = nameField.getText().trim();
            String daysText = daysField.getText().trim();

            // simple checks so the app does not crash
            if (id.equals("") || customer.equals("") || daysText.equals("")) {
                output.setText("Please fill Vehicle ID, Customer and Days.");
                return;
            }
            try {
                int days = Integer.parseInt(daysText); // text -> number
                output.setText(manager.rentVehicle(id, customer, days));
            } catch (NumberFormatException ex) {
                output.setText("Days must be a number.");
            }
        });

        returnBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            output.setText(manager.returnVehicle(id));
        });

        // show the window
        frame.pack();
        frame.setLocationRelativeTo(null); // open in center of screen
        frame.setVisible(true);
    }

    // ============================================================
    //  main() : the program starts running from here
    // ============================================================
    public static void main(String[] args) {
        new RentalGUI();
    }
}
