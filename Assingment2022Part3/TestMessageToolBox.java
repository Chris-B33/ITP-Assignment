//   ID: 22356053
// Name: Chris Brophy

public class TestMessageToolBox {
    public static void main(String[] args) {
        // Range of values
        // 86,400,000ms in a day
        long[] times = new long[] {
                System.currentTimeMillis(),
                86400000 * 2 + 86400000 / 4,
                86400000 * 8 + 86400000 / 2,
                86400000 * 5 + 86400000 / 3,
                86400000 * 1500 // 1500 % 7 = 2
        };
        String[] msgs = new String[] {
                "SHUT UP SHUT UP SHUT UP SHUT UP SHUT UP",
                " ".repeat(30) + "There was 30 characters preceding this message",
                " ".repeat(25) + "This message has exactly 39 characters",
                "",
                "this class is nice tbh"
        };
        int[] widths = new int[] {
                -4,
                90,
                70,
                20,
                10
        };

        // timeOfDayFormatted tests
        System.out.println("\nTime of Day Formatted Tests");
        for (long i : times) {
            System.out.println(MessageToolBox.timeOfDayFormatted(i));
        }

        // DayName tests
        System.out.println("\nDay Name Tests");
        for (long i : times) {
            System.out.println(MessageToolBox.dayName(i));
        }

        // ageOfPost tests
        System.out.println("\nAge Of Post Tests");
        for (long i : times) {
            System.out.println(MessageToolBox.ageOfPost(i));
        }

        // centre tests
        System.out.println("\nCentre Tests");
        for (int i = 0; i < times.length; i++) {
            String m = msgs[i];
            int w = widths[i];
            System.out.println(MessageToolBox.centre(m, w));
        }

        // display tests
        System.out.println("\nDisplay Tests");
        for (int i = 0; i < times.length; i++) {
            String m = msgs[i];
            int w = widths[i];
            MessageToolBox.display(m, w);
        }

    }
}
