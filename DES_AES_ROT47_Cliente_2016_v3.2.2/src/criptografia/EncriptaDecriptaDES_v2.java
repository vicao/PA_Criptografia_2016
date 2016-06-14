package criptografia;

import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import javax.crypto.spec.IvParameterSpec;
import sun.misc.BASE64Encoder;
 

/**
 
 * @author Vinicius Dutra Cerqueira Rocha - 315112918

 * 
 * 
 */



 public class EncriptaDecriptaDES_v2 {
	 
    static KeyGenerator keygenerator;// = KeyGenerator.getInstance("DES");
    static SecretKey chaveDES = null;
    static Cipher cifraDESCBC; // Cria a cifra
    static Cipher cifraDESECB; // Cria a cifra
    static IvParameterSpec iv;
    static SecureRandom secureRandom;
    static SecretKey sk;
    static String Data = new SimpleDateFormat("[dd/MM/yyyy - HH:mm:ss]").format(new Date(System.currentTimeMillis()));
    
     public static void main(String[] args) throws Exception {
 
         cifraDESCBC = Cipher.getInstance("DES/CBC/PKCS5Padding");
         String toEncrypt = "The shorter you live, the longer you're dead!";
         System.out.println("texto claro : " + toEncrypt);
         System.out.println("Encrypting...");
         byte[] encrypted = encryptCBC(toEncrypt, "password");
         System.out.println("Texto criptografado : " + encrypted);
         System.out.println("Decrypting...");
         //String decrypted = decryptCBC(encrypted, "password");

         //System.out.println("Decrypted text: " + decrypted);
     }
    
    
    
    
    
    /**
     *  Metodo para criptografar o texto utilizando o processo DES
     * @param texto  - texto a ser encriptado
     * @param chave  Chave a ser utilizada pra realizar a criptografia
     *  @return array de bytes com o texto criptografado.
     */
     public static byte[] DESPaddingECB(String texto,SecretKey chave){
        byte[] textoEncriptado = null;
             try {

                 cifraDESECB = Cipher.getInstance("DES/ECB/PKCS5Padding"); // Inicializa a cifra para o processo de encriptação
                 cifraDESECB.init(Cipher.ENCRYPT_MODE, chave); // Texto puro
                 byte[] asercriptografado = texto.getBytes();
                 //System.out.println("Texto [Formato de Byte] : " + asercriptografado);
                // System.out.println("Texto Puro : " + new String(asercriptografado)); // Texto encriptado
                 textoEncriptado = cifraDESECB.doFinal(asercriptografado);
                 System.out.println("[DESPaddingECB]Texto Claro : " + texto);
                 System.out.println("[DESPaddingECB]Texto Encriptado : " + textoEncriptado);                
             } catch (Exception ex) {
                 System.out.println(Data + "[Exception]encriptar : " + ex.getMessage());   
             }
          return textoEncriptado;               
    }     

    /**
     *  Metodo para criptografar o texto utilizando o processo DES
     * @param texto  - texto a ser encriptado
     * @param chave  Chave a ser utilizada pra realizar a criptografia
     *  @return array de bytes com o texto criptografado.
     */
     public static byte[] DESPaddingCBC(String texto,SecretKey chave){
        byte[] textoEncriptado = null;
        String strCipherText = new String();
             try {
                 cifraDESCBC = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Inicializa a cifra para o processo de encriptação
                 
                 // generate an initialization vector (IV)

                 //cifraDESCBC.init(Cipher.ENCRYPT_MODE, chave); // Texto puro
                 
                 // initialize the cipher with the key and IV
                 cifraDESCBC.init(Cipher.ENCRYPT_MODE, chaveDES, iv);
                 
                System.out.println("[DESPaddingCBC]iv : " + iv.getIV());
                 
                 byte[] AseCriptografado = texto.getBytes();
                 //System.out.println("Texto [Formato de Byte] : " + AseCriptografado);
                // System.out.println("Texto Puro : " + new String(AseCriptografado)); // Texto encriptado
                 textoEncriptado = cifraDESCBC.doFinal(AseCriptografado);
                 strCipherText = new BASE64Encoder().encode(textoEncriptado);
                 System.out.println("[DESPaddingCBC]Texto Claro : " + texto);
                 System.out.println("[DESPaddingCBC]Texto Encriptado : " + textoEncriptado);                
             } catch (Exception ex) {
                 System.out.println(Data + "[DESPaddingCBC][Exception]encriptar : " + ex.getMessage());   
             }
          return textoEncriptado;               
    }   

     /**
      * Metodo para descriptografar usando o processo DES
      * @param textoEncriptado array de bytes encriptado
      * @param chave chave de descriptografia
      * @return texto descriptografado
      */
    public static String DESPaddingECBDecrypter(byte[] textoEncriptado,SecretKey chave){
          String descriptografado = "";
             try {
                 //keygenerator = KeyGenerator.getInstance("DES");                 
                 Cipher cifraDES; // Cria a cifra
                 cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding"); // Inicializa a cifra para o processo de encriptação                 
                 //System.out.println("Texto Encriptografado : " + new String(textoEncriptado)); // Texto encriptado
                 cifraDES.init(Cipher.DECRYPT_MODE, chave); // Decriptografa o texto
                 byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado); 
                 descriptografado = new String(textoDecriptografado);
                 //System.out.println("Texto Decriptografado : " + descriptografado);
             } catch (Exception ex) {
                 System.out.println(Data + "[DESPaddingECBDecrypter][Exception]descriptar : " + ex.getMessage());   
             }
                   return   descriptografado;   
    }
    
     /**
      * Metodo para descriptografar usando o processo DES
      * @param textoEncriptado array de bytes encriptado
      * @param chave chave de descriptografia
      * @return texto descriptografado
      */
    public static String DESPaddingCBCDecrypter(byte[] textoEncriptado,SecretKey chave){
          String descriptografado = "";
             try {
                 
                //-----------------------------------
                
                 /* create a binary key from the argument key (seed)
                 SecureRandom sr = new SecureRandom();
                byte[] ivspec = new byte[cifraDESCBC.getBlockSize()];
                 sr.nextBytes(ivspec);
                 KeyGenerator kg = KeyGenerator.getInstance("DES");
                 kg.init(sr);
                 SecretKey sk = kg.generateKey();*/
                 
                //-----------------------------------
                 
                 cifraDESCBC = Cipher.getInstance("DES/CBC/PKCS5Padding"); // Inicializa a cifra para o processo de encriptação                 
                 //System.out.println("Texto Encriptografado : " + new String(textoEncriptado)); // Texto encriptado
                 cifraDESCBC.init(Cipher.DECRYPT_MODE,  chaveDES,iv);//sk,iv); // Decriptografa o texto
                 byte[] textoDecriptografado = cifraDESCBC.doFinal(textoEncriptado); 
                 descriptografado = new String(textoDecriptografado);
                 //System.out.println("Texto Decriptografado : " + descriptografado);
             } catch (Exception ex) {
                 System.out.println(Data + "[DESPaddingCBCDecrypter][Exception]descriptar : " + ex.getMessage());   
             }
                   return   descriptografado;   
            
                   
                   
        
    }
    
    public static byte[] encryptCBC(String toEncrypt, String key) throws Exception {
        byte[] encrypted = null;
        try {
               //DES CBC

            //****************************************           
            //gerachaveCBC(key);
            //geraIV(iv);
                    
                // create a binary key from the argument key (seed)
                SecureRandom sr = new SecureRandom(key.getBytes());
                KeyGenerator kg = KeyGenerator.getInstance("DES");
                kg.init(sr);
                sk = kg.generateKey();


            // generate an initialization vector (IV)
            SecureRandom secureRandom = new SecureRandom();
            byte[] ivspec = new byte[cifraDESECB.getBlockSize()];
            secureRandom.nextBytes(ivspec);
            iv = new IvParameterSpec(ivspec);

            
            
            // initialize the cipher with the key and IV
            cifraDESCBC.init(Cipher.ENCRYPT_MODE, sk, iv);
            // enctypt!
            encrypted = cifraDESCBC.doFinal(toEncrypt.getBytes());
            //****************************************           
            //System.out.println("[encryptCBC]iv : " + iv.getIV());

        } catch (Exception ex) {
            System.out.println(Data + "[Exception][encryptCBC] -" + ex.getMessage() + ex.getLocalizedMessage());
        }

        return encrypted;
   }
  
   public static String decryptCBC(byte[] toDecrypt, String key) throws Exception {
       byte[] decrypted = null;
       try {

           gerachaveCBC(key);   
           System.out.println("[decryptCBC]iv : " + iv.getIV());
           // do the decryption with that key
           //Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
           cifraDESCBC.init(Cipher.DECRYPT_MODE, sk, iv);
           decrypted = cifraDESCBC.doFinal(toDecrypt);
       } catch (Exception ex) {
           System.out.println(Data + "[Exception][decryptCBC]descriptar : " + ex.getMessage() + ex.getLocalizedMessage());
       }

       return new String(decrypted);
   }

    private static void gerachaveCBC(String key) {
        try {
            // create a binary key from the argument key (seed)
            SecureRandom sr = new SecureRandom(key.getBytes());
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(sr);
            sk = kg.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(Data + "[Exception][gerachaveCBC]descriptar : " + ex.getMessage());
        }
        
    }

    private static void geraIV(IvParameterSpec iv) {
         // generate an initialization vector (IV)
         SecureRandom secureRandom = new SecureRandom();
         byte[] ivspec = new byte[cifraDESECB.getBlockSize()];
         secureRandom.nextBytes(ivspec);
         iv = new IvParameterSpec(ivspec);
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/**----------Area de Teste-------------------------------------------------------------------------------------------------------    
   
    *
     * Metodo antigo de criptografia
     * @param texto texto a ser criptografado
     * @return array de bytes
     *
    public static byte[] encriptarOLD(String texto){
        byte[] textoEncriptado = null;
             try {
                 keygenerator = KeyGenerator.getInstance("DES");   
                 chaveDES = keygenerator.generateKey();
                 Cipher cifraDES; // Cria a cifra
                 cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding"); // Inicializa a cifra para o processo de encriptação
                 cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES); // Texto puro
                 byte[] AseCriptografado = texto.getBytes();
                 //System.out.println("Texto [Formato de Byte] : " + AseCriptografado);
                // System.out.println("Texto Puro : " + new String(AseCriptografado)); // Texto encriptado
                 textoEncriptado = cifraDES.doFinal(AseCriptografado);
                 System.out.println("Texto Encriptado : " + textoEncriptado);                
             } catch (Exception ex) {
                 Logger.getLogger(EncriptaDecriptaDES_v2.class.getName()).log(Level.SEVERE, null, ex);
             }
          return textoEncriptado;               
    }  
    
    /*
     * Metodo antigo de descriptografia
     * @param textoEncriptado texto a ser encriptador
     * @return string contendo o texto criptografado
     *
    public static String descriptarOLD(byte[] textoEncriptado){
          String descriptografado = "";
             try {
                 //keygenerator = KeyGenerator.getInstance("DES");                 
                 Cipher cifraDES; // Cria a cifra
                 cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding"); // Inicializa a cifra para o processo de encriptação                 
                 //System.out.println("Texto Encriptografado : " + new String(textoEncriptado)); // Texto encriptado
                 cifraDES.init(Cipher.DECRYPT_MODE, chaveDES); // Decriptografa o texto
                 byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado); 
                 descriptografado = new String(textoDecriptografado);
                 //System.out.println("Texto Decriptografado : " + descriptografado);
             } catch (Exception ex) {
                 Logger.getLogger(EncriptaDecriptaDES_v2.class.getName()).log(Level.SEVERE, null, ex);
             }
                   return   descriptografado;   
    }
---------------------------------   
*/
    
}
