import service.StripGenerator;

import java.time.Duration;
import java.time.Instant;

public class App {

    public static void main(String[] args) {
        Instant start = Instant.now();
        for(int i = 0; i <= 10000; i++) {
            new StripGenerator().generateBingoStrip();
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }
}
