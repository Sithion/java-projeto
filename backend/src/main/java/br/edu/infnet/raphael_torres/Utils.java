package br.edu.infnet.raphael_torres;

import java.util.UUID;

public class Utils {
    public static boolean isValidUUID(String uuidString) {
        if (uuidString == null) {
            return false;
        }
        try {
            UUID.fromString(uuidString);
            return true; // Conversão bem-sucedida
        } catch (IllegalArgumentException e) {
            return false; // Não é um UUID válido
        }
    }
}
