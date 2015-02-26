package be.vdab.voertuigen.div;

/**
 * Created by zi08 on 10/02/2015.
 */
public enum Div {
    // Code met private constructor om singleton aan te maken:
//    private static final Div instance = new Div();
//
//    public static Div getInstance() {
//        return instance;
//    }
//
//    private Div() {
//    }

    // Code voor singleton door middel van enum type
    INSTANCE;
    private int nummer = 1;

    public Nummerplaat getNummerplaat() {
        String plaat = String.format("AAA%03d", nummer++);
        if (nummer >= 999) {
            nummer = 1;
        }
        return new Nummerplaat(plaat);
    }



}
