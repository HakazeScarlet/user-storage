package encryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionService {

    private final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;
    private final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private final String HASHING_ALGORITHM = "SHA256";
    private final String CIPHER_ALGORITHM = "AES";

    public String encrypt(final String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);
            byte[] hashedPassword = messageDigest.digest(password.getBytes(CHARSET_UTF_8));

            SecretKeySpec secretKeySpec = new SecretKeySpec(hashedPassword, CIPHER_ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedPassword = cipher.doFinal(password.getBytes(CHARSET_UTF_8));
            return Base64.getEncoder().encodeToString(encryptedPassword);
//        } catch (GeneralSecurityException e) {
//            // TODO: remove two next catches and write more informative message for current catch with GeneralSecurityException
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new AvailableAlgorithmException("Cryptographic or padding algorithm is not available in the environment");
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new CipherBlockSizeException("The length of the data provided for the block cipher is incorrect");
        } catch (InvalidKeyException e) {
            throw new CipherInitializeException("The provided key is not suitable for initializing the cipher");
        }
    }

    private static final class AvailableAlgorithmException extends RuntimeException {

        public AvailableAlgorithmException(String message) {
            super(message);
        }
    }

    private static final class CipherBlockSizeException extends RuntimeException {

        public CipherBlockSizeException(String message) {
            super(message);
        }
    }

    private static final class CipherInitializeException extends RuntimeException {

        public CipherInitializeException(String message) {
            super(message);
        }
    }
}
