
/**
 * 在这里给出对类 CaesarCiper 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;

public class CaesarCiper {
    public String encrypt(String text,int key){
        StringBuilder encrypted = new StringBuilder(text);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++){
            
            char curChar=encrypted.charAt(i);
            boolean lower=Character.isLowerCase(curChar); 
            int idx=alphabet.indexOf(Character.toUpperCase(curChar));

            if(idx!=-1){
                if(lower){
                    encrypted.setCharAt(i,Character.toLowerCase(shiftedAlphabet.charAt(idx)));
                }
                else{
                    encrypted.setCharAt(i,shiftedAlphabet.charAt(idx));
                }
                
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String text,int key1,int key2){
        StringBuilder encrypted = new StringBuilder(text);
        String text1=encrypt(text,key1);
        String text2=encrypt(text,key2);
        for(int i=0;i<text.length();i++){
            if (i%2==0){
                encrypted.setCharAt(i,text1.charAt(i));
            }
            else{
                encrypted.setCharAt(i,text2.charAt(i));
            }
        }
        return encrypted.toString();
    }
    
    public void testEncrypted(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Input your key: ");
        int key=Integer.parseInt(scanner.nextLine());
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
}