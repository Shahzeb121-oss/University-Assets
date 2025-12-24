import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// EventStorage.java
// This class handles loading and saving events to a file.
class EventStorage {
    // Map to store events: Key = "YYYY-MM-DD", Value = List of event descriptions
    private Map<String, List<String>> events;
    private final String FILENAME = "calendar_events.txt"; // File to store events

    public EventStorage() {
        events = new HashMap<>();
        loadEventsFromFile(); // Load events when the storage is initialized
    }

    /**
     * Loads events from the specified file.
     * Each line in the file is expected to be in the format:YYYY-MM-DD:Event Description
     */
    private void loadEventsFromFile() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("Event file not found. Starting with empty events.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int colonIndex = line.indexOf(':');
                if (colonIndex != -1) {
                    String dateString = line.substring(0, colonIndex).trim();
                    String eventDescription = line.substring(colonIndex + 1).trim();
                    events.computeIfAbsent(dateString, k -> new ArrayList<>()).add(eventDescription);
                }
            }
            System.out.println("Events loaded successfully from " + FILENAME);
        } catch (IOException e) {
            System.err.println("Error loading events from file: " + e.getMessage());
        }
    }

    /**
     * Saves all events to the specified file.
     * Each event is written as a new line in the format:YYYY-MM-DD:Event Description
     */
    public void saveEventsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Map.Entry<String, List<String>> entry : events.entrySet()) {
                String dateString = entry.getKey();
                for (String eventDescription : entry.getValue()) {
                    writer.write(dateString + ":" + eventDescription);
                    writer.newLine();
                }
            }
            System.out.println("Events saved successfully to " + FILENAME);
        } catch (IOException e) {
            System.err.println("Error saving events to file: " + e.getMessage());
        }
    }

    /**
     * Adds an event for a specific date.
     * @param date The date (LocalDate) for which the event is added.
     * @param description The description of the event.
     */
    public void addEvent(LocalDate date, String description) {
        String dateString = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // Format as YYYY-MM-DD
        events.computeIfAbsent(dateString, k -> new ArrayList<>()).add(description);
        System.out.println("Event added for " + dateString + ": " + description);
    }

    /**
     * Retrieves all events for a specific date.
     * @param date The date (LocalDate) to get events for.
     * @return A List of event descriptions for the given date, or an empty list if no events.
     */
    public List<String> getEvents(LocalDate date) {
        String dateString = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return events.getOrDefault(dateString, new ArrayList<>());
    }

    /**
     * Checks if a specific date has any events.
     * @param date The date (LocalDate) to check.
     * @return true if the date has events, false otherwise.
     */
    public boolean hasEvents(LocalDate date) {
        String dateString = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return events.containsKey(dateString) && !events.get(dateString).isEmpty();
    }
}
