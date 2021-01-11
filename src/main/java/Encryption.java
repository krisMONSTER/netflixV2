import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {

    public static String encrypt(String string, String newKey) {
        byte[] encrypted;
        Cipher cipher;
        Key key = keyGenerator(newKey);
        try {
            cipher = Cipher.getInstance("AES");
            if (key == null | cipher == null) {
                return null;
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, key);
                encrypted = cipher.doFinal(string.getBytes());
                return Base64.getEncoder().encodeToString(encrypted);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Key keyGenerator(String string) {
        byte[] keyByte = string.getBytes();

        if (keyByte.length < 16 || keyByte.length % 16 != 0) {
            return null;
        } else {
            return new SecretKeySpec(keyByte, "AES");
        }
    }


    public static String createKey(String string) {
        String temp = "";
        if (string.length() > 16) {
            for (int i = 0; i < 16; i++) {
                temp += string.charAt(i);
            }
        } else if (string.length() < 16) {
            temp = string;
            for (int i = string.length(); i < 16; i++) {
                temp += "1";
            }
        } else {
            temp = string;
        }
        return temp;
    }

    public static String decrypt(String string, String newKey) {
        Cipher cipher;
        Key key = keyGenerator(newKey);
        try {
            cipher = Cipher.getInstance("AES");
            //System.out.println(string);
            //System.out.println(string.length());

            if (key == null || cipher == null ) {
                return null;
            } else {
                cipher.init(Cipher.DECRYPT_MODE, key);
                return new String(cipher.doFinal(Base64.getDecoder().decode(string)));
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
