//   ID: 22356053
// Name: Chris Brophy

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Message {
    private final static int MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;
    private final static int SECONDS_IN_AN_HOUR = 60 * 60;
    private final int DISPLAY_WIDTH = 30;

    private String messageText;
    private String postedBy;
    private long postedAt;

    public Message(String text) {
        messageText = text;
        postedBy = System.getProperty("user.name");
        postedAt = System.currentTimeMillis();
    }

    public Message(String text, String postBy) {
        messageText = text;
        postedBy = postBy;
        postedAt = System.currentTimeMillis();
    }

    public String getMessageText() {
        return messageText;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public long getPostedAt() {
        return postedAt;
    }

    public String postedAtTime() {
        int secondsSinceMidnight = (int) (postedAt % MILLISECONDS_IN_A_DAY) / 1000;
        int hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        int minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;
        int second = secondsSinceMidnight % 60;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalTime localTime = LocalTime.of(hour, minute, second);
        String time = formatter.format(localTime);

        return time;
    }

    public String postedAtDayName() {
        int days = ageOfPost();

        LocalDateTime date = LocalDateTime.now().minusDays(days);
        String weekday = date.getDayOfWeek().toString().toLowerCase();
        String name = weekday.substring(0, 1).toUpperCase() + weekday.substring(1);

        return name;
    }

    public int ageOfPost() {
        return (int) ((System.currentTimeMillis() - postedAt) / MILLISECONDS_IN_A_DAY);
    }

    public void display() {
        String[] msg = messageText.split(" ");
        int curLine = 0;
        for (String word : msg) {
            if (curLine + word.length() > DISPLAY_WIDTH) {
                System.out.print("\n");
                curLine = 0;
            }
            curLine += word.length() + 1;
            System.out.printf("%s ", word);
        }
        System.out.print("\n");
    }
}