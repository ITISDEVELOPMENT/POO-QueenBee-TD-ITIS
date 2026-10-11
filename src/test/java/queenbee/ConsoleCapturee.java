package queenbee;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Outil de test : capture ce qui est affiché sur la console. */
public final class ConsoleCapturee {

    private ConsoleCapturee() {
    }

    public static String capturer(Runnable traitement) {
        PrintStream console = System.out;
        ByteArrayOutputStream tampon = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tampon, true, StandardCharsets.UTF_8));
        try {
            traitement.run();
        } finally {
            System.setOut(console);
        }
        return tampon.toString(StandardCharsets.UTF_8).replace("\r\n", "\n");
    }

    public static String ressource(String chemin) throws IOException {
        try (InputStream fichier = ConsoleCapturee.class.getResourceAsStream(chemin)) {
            return new String(fichier.readAllBytes(), StandardCharsets.UTF_8).replace("\r\n", "\n");
        }
    }
}
