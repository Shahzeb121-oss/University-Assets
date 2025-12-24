// DateHelper.java
// This class provides static utility methods for date calculations.
class DateHelper {

    /**
     * Checks if a given year is a leap year.
     * A year is a leap year if it is divisible by 4, but not by 100,
     * unless it is also divisible by 400.
     *
     * @param year The year to check.
     * @return true if the year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Returns the number of days in a specific month of a given year.
     *
     * @param month The month (1-12).
     * @param year The year.
     * @return The number of days in the specified month.
     * @throws IllegalArgumentException if the month is not between 1 and 12.
     */
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:  // January
            case 3:  // March
            case 5:  // May
            case 7:  // July
            case 8:  // August
            case 10: // October
            case 12: // December
                return 31;
            case 4:  // April
            case 6:  // June
            case 9:  // September
            case 11: // November
                return 30;
            case 2:  // February
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
    }

    /**
     * Calculates the day of the week for a given date using Zeller's congruence.
     * The result is an integer where 0 = Saturday, 1 = Sunday, ..., 6 = Friday.
     *
     * @param day The day of the month (1-31).
     * @param month The month (1-12).
     * @param year The year.
     * @return An integer representing the day of the week (0=Saturday, 1=Sunday, ..., 6=Friday).
     * @throws IllegalArgumentException if the date is invalid.
     */
    public static int getDayOfWeek(int day, int month, int year) {
        // Adjust month and year for Zeller's congruence if month is January or February
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }

        int K = year % 100; // Year of the century
        int J = year / 100; // Century

        // Zeller's congruence formula
        // h = (q + floor(13*(m+1)/5) + K + floor(K/4) + floor(J/4) - 2*J) mod 7
        int h = (day + (13 * (month + 1)) / 5 + K + K / 4 + J / 4 - 2 * J) % 7;

        // Ensure the result is non-negative
        return (h + 7) % 7;
    }

    /**
     * Returns the name of the month for a given month number.
     *
     * @param month The month number (1-12).
     * @return The name of the month (e.g., "January").
     * @throws IllegalArgumentException if the month is not between 1 and 12.
     */
    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        if (month >= 1 && month <= 12) {
            return monthNames[month - 1];
        } else {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
    }
}
    