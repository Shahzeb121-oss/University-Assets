import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

// CalendarAppGUI.java
// Main class to create and display the Java Swing Calendar application.
public class CalendarAppGUI extends JFrame{

    private EventStorage eventStorage; // Our event storage instance

    public CalendarAppGUI() {
        setTitle("SOLAR CALENDER");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Handle closing manually to save events
        setSize(700, 700); // Set a reasonable size for the window
        setLocationRelativeTo(null); // Center the window on the screen

        eventStorage = new EventStorage(); // Initialize event storage

        // Create an instance of CalendarPanel and add it to the frame
        CalendarPanel calendarPanel = new CalendarPanel(eventStorage);
        add(calendarPanel);

        // Add a WindowListener to save events when the application is closed
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                eventStorage.saveEventsToFile(); // Save events before closing
                dispose(); // Close the frame
                System.exit(0); // Exit the application
            }
        });

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(() -> {
            new CalendarAppGUI();
        });
    }
}
    