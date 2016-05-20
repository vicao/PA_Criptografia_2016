package criptografia;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

public class cbc {
  public static void main(String args[]) throws Exception {
    KeyGenerator kg = KeyGenerator.getInstance("DES");
    Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
    Key key = kg.generateKey();

    c.init(Cipher.ENCRYPT_MODE, key);
    String txt = "Stand and unfold yourself";
    byte input[] = txt.getBytes();
    byte encrypted[] = c.doFinal(input);
    byte iv[] = c.getIV();
    System.out.println("Texto claro : " +  txt);
    System.out.println("Texto criptografado : " +  encrypted);
    System.out.println("IV : " + iv.toString());
    
    IvParameterSpec dps = new IvParameterSpec(iv);
    c.init(Cipher.DECRYPT_MODE, key, dps);
    byte output[] = c.doFinal(encrypted);
    System.out.println(new String(output));
  }
}