package util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class PasswordUtils {

    private PasswordUtils() {
    }

    public static String encode(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String encoded) {
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}

