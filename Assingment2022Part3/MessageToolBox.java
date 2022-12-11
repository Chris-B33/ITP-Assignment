//   ID: 22356053
// Name: Chris Brophy

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class MessageToolBox {

    final static int MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;
    final static int SECONDS_IN_AN_HOUR = 60 * 60;

    // Returns string time identified by timeSentInMills //
    public static String timeOfDayFormatted(long timeSentInMills) {
        int secondsSinceMidnight = (int) (timeSentInMills % MILLISECONDS_IN_A_DAY) / 1000;
        int hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        int minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;
        int second = secondsSinceMidnight % 60;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalTime localTime = LocalTime.of(hour, minute, second);
        String time = formatter.format(localTime);

        return time;
    }

    // Return string name of day associated wth timeSentInMills //
    public static String dayName(long timeSentInMills) {
        int days = ageOfPost(timeSentInMills);

        LocalDateTime date = LocalDateTime.now().minusDays(days);
        String weekday = date.getDayOfWeek().toString().toLowerCase();
        String name = weekday.substring(0, 1).toUpperCase() + weekday.substring(1);

        return name;
    }

    // Returns int age of post in days given by timeSentInMills //
    public static int ageOfPost(long timeSentInMills) {
        return (int) ((System.currentTimeMillis() - timeSentInMills) / MILLISECONDS_IN_A_DAY);
    }

    // Returns string centred message associated with messageText and width //
    public static String centre(String messageText, int width) {
        if (width <= 0 || width < messageText.length()) {
            return "";
        } else if (messageText.length() == 0) {
            return " ".repeat(width);
        } else {
            int padding = (int) ((width - messageText.length()) / 2);
            return " ".repeat(padding) + messageText + " ".repeat(padding);
        }
    }

    // Displays messageText in series of lines based on width //
    public static void display(String messageText, int width) {
        if (width < 10) {
            width = 10;
        } else if (width > 80) {
            width = 80;
        }

        int j = 0;
        for (int i = 0; i < messageText.length(); ++i) {
            System.out.print(messageText.charAt(i));
            if (j + 1 == width) {
                System.out.print("\n");
                j = 0;
            }
            j++;
        }
        System.out.print("\n");
    }
}