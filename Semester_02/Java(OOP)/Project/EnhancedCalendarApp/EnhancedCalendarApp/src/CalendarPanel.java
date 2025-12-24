import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

// CalendarPanel.java
// This class extends JPanel and contains the GUI components for the calendar.
class CalendarPanel extends JPanel implements ActionListener {
    private JComboBox<String> monthComboBox;
    private JSpinner yearSpinner;
    private JButton prevButton, nextButton; // Keep for quick navigation
    private JPanel daysPanel;
    private JTextArea eventsDisplayArea; // To show events for selected date

    private int currentMonth;
    private int currentYear;
    private EventStorage eventStorage; // Reference to event storage

    private JLabel selectedDayLabel = null; // To keep track of the currently selected day label

    public CalendarPanel(EventStorage storage) {
        this.eventStorage = storage;
        setLayout(new BorderLayout(10, 10)); // Add gaps between main panels
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        LocalDate today = LocalDate.now();
        currentMonth = today.getMonthValue();
        currentYear = today.getYear();

        // --- Top Panel for Month/Year Selection and Navigation ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5)); // Centered flow layout

        prevButton = new JButton("< Prev");
        prevButton.addActionListener(this);
        prevButton.setActionCommand("prev");
        topPanel.add(prevButton);

        // Month ComboBox
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        monthComboBox = new JComboBox<>(monthNames);
        monthComboBox.setSelectedIndex(currentMonth - 1); // Set to current month
        monthComboBox.addActionListener(this);
        topPanel.add(monthComboBox);

        // Year Spinner
        SpinnerModel yearModel = new SpinnerNumberModel(currentYear, 1900, 2100, 1); // Min, Max, Step
        yearSpinner = new JSpinner(yearModel);
        yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "####")); // Format as 4 digits
        yearSpinner.addChangeListener(e -> { // Use ChangeListener for JSpinner
            currentYear = (int) yearSpinner.getValue();
            drawCalendar();
        });
        topPanel.add(yearSpinner);

        nextButton = new JButton("Next >");
        nextButton.addActionListener(this);
        nextButton.setActionCommand("next");
        topPanel.add(nextButton);

        add(topPanel, BorderLayout.NORTH);

        // --- Calendar Grid Panel (Days of Week Header + Days) ---
        JPanel calendarGridPanel = new JPanel(new BorderLayout());
        calendarGridPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Days of Week Header
        JPanel weekDaysPanel = new JPanel(new GridLayout(1, 7));
        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String dayName : dayNames) {
            JLabel label = new JLabel(dayName, SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 12));
            if (dayName.equals("Sun") || dayName.equals("Sat")) {
                 label.setForeground(new Color(178, 34, 34)); // Firebrick for weekends
            } else {
                 label.setForeground(new Color(65, 105, 225)); // RoyalBlue for weekdays
            }
            weekDaysPanel.add(label);
        }
        calendarGridPanel.add(weekDaysPanel, BorderLayout.NORTH);

        // Calendar Days Grid
        daysPanel = new JPanel(new GridLayout(0, 7, 5, 5)); // 0 rows, 7 columns, with gaps
        daysPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding inside grid
        calendarGridPanel.add(daysPanel, BorderLayout.CENTER);

        add(calendarGridPanel, BorderLayout.CENTER);

        // --- Events Display Area ---
        eventsDisplayArea = new JTextArea();
        eventsDisplayArea.setEditable(false);
        eventsDisplayArea.setLineWrap(true);
        eventsDisplayArea.setWrapStyleWord(true);
        eventsDisplayArea.setBorder(BorderFactory.createTitledBorder("Events for Selected Date"));
        eventsDisplayArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        JScrollPane eventsScrollPane = new JScrollPane(eventsDisplayArea);
        eventsScrollPane.setPreferredSize(new Dimension(0, 120)); // Set preferred height

        add(eventsScrollPane, BorderLayout.SOUTH);

        // Initial drawing of the calendar
        drawCalendar();
    }

    /**
     * Draws or redraws the calendar grid for the currentMonth and currentYear.
     */
    private void drawCalendar() {
        daysPanel.removeAll(); // Clear previous days

        // Update month/year selectors to reflect current values
        monthComboBox.setSelectedIndex(currentMonth - 1);
        yearSpinner.setValue(currentYear);

        // Calculate first day of the month
        // Zeller's congruence returns 0 for Saturday, 1 for Sunday, ..., 6 for Friday.
        // We want 0 for Sunday, 1 for Monday, ..., 6 for Saturday.
        int firstDayOfWeekZeller = DateHelper.getDayOfWeek(1, currentMonth, currentYear);
        int firstDayOfWeek = (firstDayOfWeekZeller == 0) ? 6 : (firstDayOfWeekZeller - 1); // Adjust to 0=Sun, 6=Sat

        // Add empty labels for the leading spaces before the 1st day
        for (int i = 0; i < firstDayOfWeek; i++) {
            daysPanel.add(new JLabel("")); // Empty label for empty cell
        }

        // Add day numbers
        int daysInMonth = DateHelper.getDaysInMonth(currentMonth, currentYear);
        LocalDate today = LocalDate.now();

        for (int day = 1; day <= daysInMonth; day++) {
            JLabel dayLabel = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            dayLabel.setPreferredSize(new Dimension(40, 40)); // Fixed size for day cells
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            dayLabel.setOpaque(true);
            dayLabel.setBackground(Color.WHITE);
            dayLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

            LocalDate dateForThisCell = LocalDate.of(currentYear, currentMonth, day);

            // Highlight current day
            if (day == today.getDayOfMonth() && currentMonth == today.getMonthValue() && currentYear == today.getYear()) {
                dayLabel.setBackground(new Color(255, 255, 153)); // Light Yellow
                dayLabel.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0), 2)); // Orange border
            }

            // Indicate dates with events
            if (eventStorage.hasEvents(dateForThisCell)) {
                dayLabel.setBackground(new Color(204, 255, 204)); // Light Green for events
                dayLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2)); // Dark Green border
                // Add tooltip to show events on hover
                List<String> events = eventStorage.getEvents(dateForThisCell);
                String tooltipText = "<html><b>Events:</b><br>" +
                                     events.stream().map(s -> "- " + s).collect(Collectors.joining("<br>")) +
                                     "</html>";
                dayLabel.setToolTipText(tooltipText);
            }

            // Add Mouse Listener for clicking on days
            dayLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Reset previous selection highlight
                    if (selectedDayLabel != null) {
                        // Re-apply original background/border based on current day/event status
                        LocalDate prevSelectedDate = LocalDate.of(currentYear, currentMonth, Integer.parseInt(selectedDayLabel.getText()));
                        if (prevSelectedDate.equals(today)) {
                             selectedDayLabel.setBackground(new Color(255, 255, 153)); // Light Yellow
                             selectedDayLabel.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0), 2));
                        } else if (eventStorage.hasEvents(prevSelectedDate)) {
                             selectedDayLabel.setBackground(new Color(204, 255, 204)); // Light Green
                             selectedDayLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2));
                        } else {
                             selectedDayLabel.setBackground(Color.WHITE);
                             selectedDayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        }
                    }

                    // Highlight newly selected day
                    selectedDayLabel = (JLabel) e.getSource();
                    selectedDayLabel.setBackground(new Color(173, 216, 230)); // Light Blue for selection
                    selectedDayLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 139), 2)); // Dark Blue border

                    // Display events for the clicked date
                    int clickedDay = Integer.parseInt(selectedDayLabel.getText());
                    LocalDate clickedDate = LocalDate.of(currentYear, currentMonth, clickedDay);
                    displayEventsForDate(clickedDate);

                    // Open AddEventDialog on double click
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        e.consume(); // Consume the event to prevent single click logic from running twice
                        AddEventDialog dialog = new AddEventDialog((JFrame) SwingUtilities.getWindowAncestor(CalendarPanel.this), clickedDate);
                        dialog.setVisible(true); // Show the dialog

                        String newEvent = dialog.getEventDescription();
                        if (newEvent != null) {
                            eventStorage.addEvent(clickedDate, newEvent);
                            eventStorage.saveEventsToFile(); // Save immediately after adding
                            drawCalendar(); // Redraw to update event indicator
                            displayEventsForDate(clickedDate); // Update event list
                        }
                    }
                }
            });
            daysPanel.add(dayLabel);
        }

        // Add empty labels to fill the remaining cells in the last week if needed
        int totalCells = firstDayOfWeek + daysInMonth;
        int remainingCells = (7 * 6) - totalCells; // Max 6 rows * 7 days = 42 cells
        if (remainingCells < 0) {
             remainingCells = 0;
        }
        for (int i = 0; i < remainingCells; i++) {
            daysPanel.add(new JLabel(""));
        }

        revalidate(); // Re-layout the components
        repaint();    // Repaint the panel
        eventsDisplayArea.setText("Select a date to view/add events."); // Reset event display
    }

    /**
     * Displays all events for a given date in the eventsDisplayArea.
     * @param date The date to display events for.
     */
    private void displayEventsForDate(LocalDate date) {
        List<String> events = eventStorage.getEvents(date);
        StringBuilder sb = new StringBuilder();
        sb.append("Events for ").append(date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))).append(":\n");
        if (events.isEmpty()) {
            sb.append("No events for this date. Double-click to add one!");
        } else {
            for (int i = 0; i < events.size(); i++) {
                sb.append(String.format("%d. %s\n", (i + 1), events.get(i)));
            }
        }
        eventsDisplayArea.setText(sb.toString());
    }

    /**
     * Handles action events from the navigation buttons and month combo box.
     *
     * @param e The ActionEvent generated.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            currentMonth--;
            if (currentMonth < 1) {
                currentMonth = 12;
                currentYear--;
            }
        } else if (e.getSource() == nextButton) {
            currentMonth++;
            if (currentMonth > 12) {
                currentMonth = 1;
                currentYear++;
            }
        } else if (e.getSource() == monthComboBox) {
            currentMonth = monthComboBox.getSelectedIndex() + 1;
        }
        drawCalendar(); // Redraw the calendar with the new month/year
    }
}
