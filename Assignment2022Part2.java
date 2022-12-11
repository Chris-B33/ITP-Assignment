//   ID: 22356053
// Name: Chris Brophy

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Assignment2022Part2 {
    public static void PrintWhatsAppMessage(String user, long timeSent, String msg) {
        final int MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;
        final int SECONDS_IN_AN_HOUR = 60 * 60;
        int secondsSinceMidnight;
        int days, hour, minute, second;

        secondsSinceMidnight = (int) (timeSent % MILLISECONDS_IN_A_DAY) / 1000;
        days = (int) (timeSent / MILLISECONDS_IN_A_DAY);
        hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;
        second = secondsSinceMidnight % 60;

        // Day Name Display
        String day;
        if (days == 0) {
            day = "";
        } else if (days == 1) {
            day = "Yesterday";
        } else if (days < 7) {
            LocalDateTime date = LocalDateTime.now().minusDays(days);
            String weekday = date.getDayOfWeek().toString().toLowerCase();
            day = weekday.substring(0, 1).toUpperCase() + weekday.substring(1);
        } else {
            day = "Some time ago...";
        }

        // Lowercase / Uppercase
        String message;
        if (user == System.getProperty("user.name")) {
            message = msg.toLowerCase();
        } else {
            message = msg.toUpperCase();
        }

        // Time Leading Zeros
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalTime localTime = LocalTime.of(hour, minute, second);
        String time = formatter.format(localTime);

        // Size Alignment
        if (day != "") {
            int padding = (int) ((40 - day.length()) / 2);
            System.out.printf("\n%s%s%s\n", " ".repeat(padding), day, " ".repeat(padding));
        }
        System.out.printf("\nPosted by : %s\n", user);
        if (message.length() < 40) {
            System.out.printf("\n%40s\n", message);
        } else {
            System.out.printf("\n%-40s\n", message);
        }
        System.out.printf("\nPosted at : %s\n", time);
    }

    public static void main(String[] args) {
        // Testing
        PrintWhatsAppMessage(
                "Dermot Kennedy",
                System.currentTimeMillis(), // Sent in 1970
                "If CS4141 has a million fans I am one of them. If CS4141 has one hundred fans I am one of them. If CS4141 has one fan I am that fan. If CS4141 has no fans then I am no longer on this earth. If the world is against CS4141, I am against the world. Love CS4141 till my last breath.");

        PrintWhatsAppMessage(
                System.getProperty("user.name"),
                200000000, // Sent over 2 days ago
                "Java is cool...");

        PrintWhatsAppMessage(
                "Mikey McCarthy",
                86410101, // Sent just over a day ago
                "I stole class representative from my peers Chris and Mark :(");

        PrintWhatsAppMessage(
                "Mark Hamil",
                0, // Sent now
                "I hate Star Wars.");
    }
}