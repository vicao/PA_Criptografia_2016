package criptografia;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

/**
 * Classe de criptografia RSA
 */
public class Cifrarsa {
	
	public static void main(String[] args) {
		try {
			Cifrarsa encrypt = new Cifrarsa();
			
			String encryptText = "Ola mundo!";
			
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(1024);
			
			KeyPair keyPair = keyPairGen.generateKeyPair();
			
			// Generate keys
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); // A chave Privada
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); // A chave p�blica
			byte[] e = encrypt.encrypt(publicKey, encryptText.getBytes());
			byte[] de = encrypt.decrypt(privateKey, e);
			System.out.println("************************************");
                        System.out.println("Texto Claro : " + encryptText);
                        System.out.println("Cigfrado : " + encrypt.bytesToString(e));
			System.out.println("************************************");
			System.out.println("Decifrado : " + encrypt.bytesToString(de));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Byte array para string
	 * @param encrytpByte
	 * @return
	 */
	protected String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += (char) bytes.intValue();
		}
		return result;
	}

	/**
	 * O m�todo de criptografia
	 * @param publicKey
	 * @param obj
	 * @return
	 */
	protected byte[] encrypt(RSAPublicKey publicKey, byte[] obj) {
		if (publicKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * O m�todo de decifra��o
	 * @param privateKey
	 * @param obj
	 * @return
	 */
	protected byte[] decrypt(RSAPrivateKey privateKey, byte[] obj) {
		if (privateKey != null) {
			try {
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				return cipher.doFinal(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}