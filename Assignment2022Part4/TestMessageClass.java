//   ID: 22356053
// Name: Chris Brophy

public class TestMessageClass {
    public static void main(String[] args) {
        String aMessage = "Have a nice Christmas everyone. " +

                "Enjoy the break from UL work, especially CS4141";

        Message xmasMessage = new Message(aMessage);

        xmasMessage.display();

        String anotherMessage = "Who would have thought that programming in Java " +

                "could be soooooooooo interesting";

        Message loveJava = new Message(anotherMessage, "Ada Lovelace");

        System.out.println("Here is a message…");

        System.out.printf("Posted by %s", loveJava.getPostedBy());

        System.out.printf("on %s ", loveJava.postedAtDayName());

        System.out.printf("at %s ", loveJava.postedAtTime());

        loveJava.display();
    }
}
