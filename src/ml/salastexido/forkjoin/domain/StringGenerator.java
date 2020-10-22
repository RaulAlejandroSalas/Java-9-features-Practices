package ml.salastexido.forkjoin.domain;

import java.util.Random;


public class StringGenerator  {

    private static String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static Random rand = new Random();

    public static String gerateString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 5; i <= 10; i++) {
            stringBuilder.append(ALLOWED_CHARS
                        .charAt(rand.nextInt(ALLOWED_CHARS.length())));
        }
        return stringBuilder.toString();    
    }
    
}
