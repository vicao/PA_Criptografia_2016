package app.tests;

import Criptografia.EncriptaDecriptaDES_Antigo;
import app.Sistema.Sistema;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JTextArea;

/**

 * @author Vinicius Dutra Cerqueira Rocha - 315112918
 
 * @version 5.0
 * 
 */

public class ClasseDeTeste {

      static Scanner sca = new Scanner(System.in);
      static String texto = "";
      static String chave = "";
      static byte[] criptografado = null;
      static String descriptografado = "";
      //static AES classeAES = new AES();
      static EncriptaDecriptaDES_Antigo classeDES = new EncriptaDecriptaDES_Antigo();
      static Sistema controller = new Sistema();     
      
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       //metodoDES();
        //metodoROT();

    }
    

    /**
     * Metodo de teste de criptografia DES
     */
    static void metodoDES(){
       byte[] encriptado = null; 
       String resultado = "";
       System.out.println("Digite o texto a ser criptografado : ");
       texto = sca.nextLine();     
       encriptado = classeDES.encriptarOLD(texto);   
       
       resultado = classeDES.descriptarOLD(encriptado);
       System.out.println("Resultado : " + resultado);
       String teste = "";
       teste = encriptado.toString();
       System.out.println("Resultado Teste: " + teste);
    }






}
