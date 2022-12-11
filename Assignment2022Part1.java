//   ID: 22356053
// Name: Chris Brophy

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Assignment2022Part1 {

    // Prints WhatsApp message with correct formatting, user and time
    public static void PrintWhatsAppMessage(String user, long timeSent, String message) {
        // Data Declaration
        final int MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;
        final int SECONDS_IN_AN_HOUR = 60 * 60;
        int secondsSinceMidnight; // Used integers because number won't be very large.
        int hour, minute; // Also, LocalTime only works with integers, not longs.

        // Algorithm
        secondsSinceMidnight = (int) (timeSent % MILLISECONDS_IN_A_DAY) / 1000;
        hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;

        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
        LocalTime localTime = LocalTime.of(hour, minute);
        String time = formatter.format(localTime);

        // Output
        System.out.printf("\nPosted by : %s\n", user);
        System.out.printf("\n%s\n", message); // One line, no auto line breaks
        System.out.printf("\nPosted at : %s\n", time);
    }

    // Main Function
    public static void main(String[] args) {
        PrintWhatsAppMessage(
                System.getProperty("user.name"),
                2000000000,
                "Java is cool...");

        PrintWhatsAppMessage(
                "Dermot Kennedy",
                System.currentTimeMillis(),
                "If CS4141 has a million fans I am one of them. If CS4141 has one hundred fans I am one of them. If CS4141 has one fan I am that fan. If CS4141 has no fans then I am no longer on this earth. If the world is against CS4141, I am against the world. Love CS4141 till my last breath.");

        PrintWhatsAppMessage(
                "Mark Hamil",
                400000,
                "I hate Star Wars.");
    }
}
