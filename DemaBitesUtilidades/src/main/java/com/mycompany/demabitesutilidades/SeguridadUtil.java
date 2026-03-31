package com.mycompany.demabitesutilidades;

import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Emily Lara
 */
public class SeguridadUtil {

    private static final String CLAVE = "1234567890123456"; // 16 caracteres para AES-128

    // Encriptar (Pasa de texto normal a "basura" segura)
    public static String encriptar(String dato) {
        if (dato == null) return null;
        try {
            SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(dato.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar", e);
        }
    }

    //Desencriptar (Pasa de "basura" segura a texto normal)
    public static String desencriptar(String dato) {
        if (dato == null) return null;
        try {
            SecretKeySpec key = new SecretKeySpec(CLAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(dato)));
        } catch (Exception e) {
            throw new RuntimeException("Error al desencriptar", e);
        }
    }

    // SHA-256 (Huella digital única e irreversible para búsquedas)
    public static String hash(String dato) {
        if (dato == null) return null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(dato.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al hashear", e);
        }
    }
}
