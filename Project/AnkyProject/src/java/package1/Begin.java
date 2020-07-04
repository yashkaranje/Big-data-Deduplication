package package1;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Scanner;

public class Begin {
    static KeyStore kscObj = null;
    static Scanner sc = null;
    static int ch;
    static String loginid = "";
    static String loginpwd = "";
    static boolean loginStatus; 
    
    public Begin() throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        kscObj = new KeyStore();
        sc = new Scanner(System.in);
    }
    
    public static KeyStore intoKeyStore(String loginid) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        kscObj.doKeyStore("cluster1", "_anky!@ubn#$0e41", loginid);
        kscObj.doKeyStore("cluster2", "_rubi#@ubn#$0e41", loginid);
        kscObj.doKeyStore("cluster3", "_hasy@@ubn#$0e41", loginid);
        kscObj.doKeyStore("cluster4", "_ketk$@ubn#$0e41", loginid);
        kscObj.doKeyStore("cluster5", "_kyan%@ubn#$0e41", loginid);
        kscObj.doKeyStore("cluster6", "_hrxx^@ubn#$0e41", loginid);
        kscObj.doKeyStore("cluster7", "_susu&@ubn#$0e42", loginid);
        kscObj.doKeyStore("cluster8", "_ganu*@ubn#$0e42", loginid);
        kscObj.doKeyStore("cluster9", "_nigg(@ubn#$0e42", loginid);
        kscObj.doKeyStore("cluster10", "_gits)@kns#$0e41", loginid);
        kscObj.doKeyStore("cluster11", "_vaan+@ubn#$0e41", loginid);
            
        return kscObj;
    }
    
    void begin() throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {                      
        do{
            System.out.println("Enter Login ID: ");
            loginid = sc.next();
            System.out.println("Enter Login Password: ");
            loginpwd = sc.next();

            if(loginid.equalsIgnoreCase("yashkaranje98") && loginpwd.equals("_yash20")){
                loginStatus = true;
                KeyStore kscObj = intoKeyStore(loginid);
                kscObj.dostoreStream(loginid);
    //            System.out.println(kscObj.doRetrieveSecKeyFromKeyStore("cluster1", loginid));
    //            System.out.println(kscObj.doRetrieveSecKeyFromKeyStore("cluster8", loginid));

                System.out.println("Press \n1. Upload \n2. Download \nEnter Choice: ");        
                switch(ch = sc.nextInt()){
                    case 1 :    new Blocking().blocking(kscObj, loginid);
                                break;

                    case 2 :    new Download().download(loginid);
                                break;

                    default:    System.out.println("Invalid Input");
                            break;
                }
            }else{
                System.out.println("Invalid Credentials!");
            }
        }while(!loginStatus);
    }
    
    public static void main(String[] args) throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        new Begin().begin();       
    }   
}
