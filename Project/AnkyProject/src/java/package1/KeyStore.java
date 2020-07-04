package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyStore {
    java.security.KeyStore ks;
    char[] ksPwd;
    java.security.KeyStore.ProtectionParameter protParam;
    javax.crypto.SecretKey mySecretKey;
    java.security.KeyStore.SecretKeyEntry skEntry;

    public KeyStore() throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, UnrecoverableEntryException {
        ks = java.security.KeyStore.getInstance("JCEKS");        
        ks.load(null, null);        
    }    
    
    void doKeyStore(String alias, String secKey, String lock) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, UnrecoverableEntryException {
        ksPwd = lock.toCharArray();        
        protParam = new java.security.KeyStore.PasswordProtection(ksPwd);                                
        mySecretKey = new SecretKeySpec(secKey.getBytes(),"AES");
        skEntry = new java.security.KeyStore.SecretKeyEntry(mySecretKey);
        ks.setEntry(alias, skEntry, protParam);       
    }
    
    void dostoreStream(String lock) throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException{
        java.io.FileOutputStream fos = null;
        try {
            fos = new java.io.FileOutputStream("keystore.ks");
            ks.store(fos, lock.toCharArray());
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
    
    String doRetrieveSecKeyFromKeyStore(String alias, String lock) throws FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, UnrecoverableKeyException{
        java.io.FileInputStream fis = null;
        try {
 	 ks.load(new FileInputStream("keystore.ks"), lock.toCharArray());
        } finally {
                if (fis != null) {
                        fis.close();
                }
        }
                
        SecretKey key = (SecretKey)ks.getKey(alias, lock.toCharArray());
//        System.out.println(key);
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
//        System.out.println(encodedKey); 
        String decodedKey = new String(Base64.getDecoder().decode(encodedKey));  
//        System.out.println(decodedKey);  
        
        return decodedKey;
    }
    
    public static void main(String[] args) throws KeyStoreException, IOException, FileNotFoundException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException{    
//        KeyStore kscObj = new KeyStore();
//        kscObj.doKeyStore("cluster1", "_anky!@ubn#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster2", "_rubi#@ubn#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster3", "_hasy@@ubn#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster4", "_ketk$@ubn#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster5", "_kyan%@ubn#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster6", "_hrxx^@ubn#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster7", "_susu&@ubn#$0e42", "yashkaranje98");
//        kscObj.doKeyStore("cluster8", "_ganu*@ubn#$0e42", "yashkaranje98");
//        kscObj.doKeyStore("cluster9", "_nigg(@ubn#$0e42", "yashkaranje98");
//        kscObj.doKeyStore("cluster10", "_gits)@kns#$0e41", "yashkaranje98");
//        kscObj.doKeyStore("cluster11", "_vaan+@ubn#$0e41", "yashkaranje98");
//        kscObj.storeStream("yashkaranje98");
//        System.out.println(kscObj.doRetrieveSecKeyFromKeyStore("cluster1", "yashkaranje98"));
//        System.out.println(kscObj.doRetrieveSecKeyFromKeyStore("cluster8", "yashkaranje98"));
    }
}
