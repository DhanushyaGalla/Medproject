package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorAppointmentApp {

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Doctor Appointment App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout()); // Use BorderLayout to place the title at the top
        
        // Title label with larger font and color change
        JLabel titleLabel = new JLabel("Doctor Appointment Booking", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Increased font size for title
        titleLabel.setForeground(Color.GREEN); // Change text color to green
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding around the title
        
        // Add the title at the top of the window
        frame.add(titleLabel, BorderLayout.NORTH);
        
        // Create a custom panel to set a background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\savan\\OneDrive\\Desktop\\image3.jpg");
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        // Set layout to GridBagLayout on the background panel
        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Margin between components

        // Create a font for labels
        Font labelFont = new Font("Arial", Font.BOLD, 30); // Increased font size for labels

        // Hospital locations dropdown
        JLabel locationLabel = new JLabel("Hospital Location:");
        locationLabel.setFont(labelFont);
        String[] locations = {"City Hospital", "Green Valley Hospital", "Sunrise Medical Center", "Blue Cross Clinic", "CareWell Hospital"};
        JComboBox<String> locationDropdown = new JComboBox<>(locations);

        // Doctor's name dropdown
        JLabel doctorNameLabel = new JLabel("Doctor's Name:");
        doctorNameLabel.setFont(labelFont);
        String[] doctors = {"Dr. John Smith", "Dr. Emily Davis", "Dr. Michael Johnson", "Dr. Sarah Brown", "Dr. Robert Wilson", "Dr. Linda White"};
        JComboBox<String> doctorDropdown = new JComboBox<>(doctors);

        // Patient's name
        JLabel patientNameLabel = new JLabel("Patient's Name:");
        patientNameLabel.setFont(labelFont);
        JTextField patientNameField = new JTextField(15);

        // Mobile number
        JLabel mobileLabel = new JLabel("Mobile Number:");
        mobileLabel.setFont(labelFont);
        JTextField mobileField = new JTextField(15);

        // Appointment date
        JLabel appointmentDateLabel = new JLabel("Appointment Date:");
        appointmentDateLabel.setFont(labelFont);
        JTextField appointmentDateField = new JTextField(15);

        // Patient address
        JLabel patientAddressLabel = new JLabel("Patient Address:");
        patientAddressLabel.setFont(labelFont);
        JTextField patientAddressField = new JTextField(15);

        // Pincode
        JLabel pincodeLabel = new JLabel("Pincode:");
        pincodeLabel.setFont(labelFont);
        JTextField pincodeField = new JTextField(15);

        // Specialist dropdown
        JLabel specialistLabel = new JLabel("Select a Specialist:");
        specialistLabel.setFont(labelFont);
        String[] specialists = {"Dermatology", "Gastroenterology", "Dentist", "Cardiology", "Orthopedics", "Neurology"};
        JComboBox<String> specialistDropdown = new JComboBox<>(specialists);

        // Create buttons for submit and reset
        JButton submitButton = new JButton("Book");
        JButton resetButton = new JButton("Reset");

        // Add action listener to handle submit button click
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect all the input data
                String location = (String) locationDropdown.getSelectedItem();
                String doctorName = (String) doctorDropdown.getSelectedItem();
                String patientName = patientNameField.getText();
                String mobile = mobileField.getText();
                String appointmentDate = appointmentDateField.getText();
                String patientAddress = patientAddressField.getText();
                String pincode = pincodeField.getText();
                String specialist = (String) specialistDropdown.getSelectedItem();

                // Show collected information in a popup dialog
                JOptionPane.showMessageDialog(frame,
                        "Appointment Details:\n" +
                                "Location: " + location + "\n" +
                                "Doctor's Name: " + doctorName + "\n" +
                                "Patient's Name: " + patientName + "\n" +
                                "Mobile: " + mobile + "\n" +
                                "Appointment Date: " + appointmentDate + "\n" +
                                "Address: " + patientAddress + "\n" +
                                "Pincode: " + pincode + "\n" +
                                "Specialist: " + specialist,
                        "Appointment Summary",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add action listener to handle reset button click
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all the text fields
                patientNameField.setText("");
                mobileField.setText("");
                appointmentDateField.setText("");
                patientAddressField.setText("");
                pincodeField.setText("");
                
                // Reset dropdowns to the first option
                locationDropdown.setSelectedIndex(0);
                doctorDropdown.setSelectedIndex(0);
                specialistDropdown.setSelectedIndex(0);
            }
        });

        // Setting up GridBagConstraints for layout
        
        // Row 1: Hospital Location
        gbc.gridx = 0; gbc.gridy = 0;
        backgroundPanel.add(locationLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        backgroundPanel.add(locationDropdown, gbc);
        
        // Row 2: Doctor's Name
        gbc.gridx = 0; gbc.gridy = 1;
        backgroundPanel.add(doctorNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        backgroundPanel.add(doctorDropdown, gbc);
        
        // Row 3: Patient's Name
        gbc.gridx = 0; gbc.gridy = 2;
        backgroundPanel.add(patientNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        backgroundPanel.add(patientNameField, gbc);
        
        // Row 4: Mobile Number
        gbc.gridx = 0; gbc.gridy = 3;
        backgroundPanel.add(mobileLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        backgroundPanel.add(mobileField, gbc);
        
        // Row 5: Appointment Date
        gbc.gridx = 0; gbc.gridy = 4;
        backgroundPanel.add(appointmentDateLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        backgroundPanel.add(appointmentDateField, gbc);
        
        // Row 6: Patient Address
        gbc.gridx = 0; gbc.gridy = 5;
        backgroundPanel.add(patientAddressLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        backgroundPanel.add(patientAddressField, gbc);
        
        // Row 7: Pincode
        gbc.gridx = 0; gbc.gridy = 6;
        backgroundPanel.add(pincodeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        backgroundPanel.add(pincodeField, gbc);
        
        // Row 8: Specialist
        gbc.gridx = 0; gbc.gridy = 7;
        backgroundPanel.add(specialistLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7;
        backgroundPanel.add(specialistDropdown, gbc);
        
        // Row 9: Submit Button
        gbc.gridx = 0; gbc.gridy = 8;
        backgroundPanel.add(submitButton, gbc);
        
        // Row 9: Reset Button
        gbc.gridx = 1; gbc.gridy = 8;
        backgroundPanel.add(resetButton, gbc);

        // Add background panel to the center
        frame.add(backgroundPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }
}
