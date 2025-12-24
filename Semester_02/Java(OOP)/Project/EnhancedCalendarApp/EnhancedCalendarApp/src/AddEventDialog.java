import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// AddEventDialog.java
// A JDialog for adding a new event.
class AddEventDialog extends JDialog implements ActionListener {
    private JTextField eventDescriptionField;
    private JButton addButton;
    private JButton cancelButton;
    private String eventDescription = null; // Stores the description if added

    public AddEventDialog(JFrame parent, LocalDate date) {
        super(parent, "Add Event for " + date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")), true); // Modal dialog
        setLayout(new BorderLayout(10, 10));
        setSize(350, 150);
        setLocationRelativeTo(parent); // Center relative to parent frame

        // Input panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        inputPanel.add(new JLabel("Event Description:"));
        eventDescriptionField = new JTextField(20);
        inputPanel.add(eventDescriptionField);
        add(inputPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        addButton = new JButton("Add Event");
        addButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Make Enter key press trigger add event
        getRootPane().setDefaultButton(addButton);
    }

    /**
     * Returns the event description entered by the user.
     * @return The event description, or null if cancelled.
     */
    public String getEventDescription() {
        return eventDescription;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String description = eventDescriptionField.getText().trim();
            if (!description.isEmpty()) {
                eventDescription = description;
                dispose(); // Close the dialog
            } else {
                JOptionPane.showMessageDialog(this, "Please enter an event description.", "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            eventDescription = null; // Indicate cancellation
            dispose(); // Close the dialog
        }
    }
}
