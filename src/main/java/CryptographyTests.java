
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Set;

public class CryptographyTests {
    public static void main(String[] args) {
        System.out.println("===========================================");
        listSupportedAlgorithms();
        System.out.println("===========================================");
        exampleRSAKeyPairGenerator();
        System.out.println("===========================================");
    }

    /**
     * Supported algorithms for KeyPairGenerator:
     * RSA
     * DSA
     * DIFFIEHELLMAN
     * EC
     */
    private static void listSupportedAlgorithms() {
        Set<String> algorithms = Security.getAlgorithms("KeyPairGenerator");
        System.out.println("Supported algorithms for KeyPairGenerator:");
        for (String algorithm : algorithms) {
            System.out.println(algorithm);
        }
    }

    public static void exampleRSAKeyPairGenerator() {
        try {
            // Initialize KeyPairGenerator for RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            // Initialize key size (you can adjust this as needed)
            keyPairGenerator.initialize(2048); // 2048-bit key size

            // Generate key pair
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Retrieve public and private keys
            // PublicKey publicKey = keyPair.getPublic();
            // PrivateKey privateKey = keyPair.getPrivate();

            System.out.println("RSA Key Pair generated successfully:");
            System.out.println("Public Key: " + keyPair.getPublic());
            System.out.println("Private Key: " + keyPair.getPrivate());

        } catch (NoSuchAlgorithmException e) {
            System.err.println("RSA algorithm not available: " + e.getMessage());
        }
    }
}

