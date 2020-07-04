package package1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Scanner;

public class Anky {
    static Scanner sc;
    static String s = new String();

    public Anky() throws FileNotFoundException {
    
    }
    
    boolean commonFunc(String currentClusterName, String encryptedString, String fileName, int indexOfSentence){
        //returns true if duplicate found
        JDBC jdbcObj = new JDBC();
        if(jdbcObj.isAvailable(currentClusterName, encryptedString)){
            if(jdbcObj.doUpdateContent(currentClusterName, encryptedString, fileName, indexOfSentence) == 1){
                System.out.println("Updated the encryptedString " + encryptedString + " in " + currentClusterName);
            }
            return true;
        }else{
            if(jdbcObj.doInsert(currentClusterName, encryptedString, fileName, indexOfSentence) ==  1){
                System.out.println("Inserted the encryptedString " + encryptedString + " in " + currentClusterName);
            }
            return false;
        }
    }
    
    SentencePropertiesPOJO doClustering(String plainText, String fileName, int indexOfSentence, KeyStore kscObj, String loginid) throws FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, UnrecoverableKeyException{
        int curSenLen = plainText.length();
        SentencePropertiesPOJO sentencePropertiesObject = new SentencePropertiesPOJO();
        
        if(curSenLen!=0){
            if(curSenLen > 0 && curSenLen <= 20){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster1";
                String symKey1 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey1);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 1;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 20 && curSenLen <= 40){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster2";
                String symKey2 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid); 

                AES.setKey(symKey2);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 2;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 40 && curSenLen <= 60){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster3";
                String symKey3 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey3);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 3;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 60 && curSenLen <= 80){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster4";
                String symKey4 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey4);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 4;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 80 && curSenLen <= 100){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster5";
                String symKey5 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey5);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 5;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 100 && curSenLen <= 120){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster6";
                String symKey6 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey6);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 6;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 120 && curSenLen <= 140){
                String op = "";
                String encryptedString;            
                String currentClusterName = "cluster7";
                String symKey7 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey7);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 7;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 140 && curSenLen <= 160){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster8";
                String symKey8 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey8);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 8;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 160 && curSenLen <= 180){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster9";
                String symKey9 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey9);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 9;
                
                return sentencePropertiesObject;

            }else if(curSenLen > 180 && curSenLen <= 200){
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster10";
                String symKey10 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey10);
//                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 10;
                
                return sentencePropertiesObject;

            }else /*if(curSenLen > 200)*/{
                String op = "";
                String encryptedString;
                String currentClusterName = "cluster11";
                String symKey11 = kscObj.doRetrieveSecKeyFromKeyStore(currentClusterName, loginid);

                AES.setKey(symKey11);
                AES.encrypt(plainText.trim());
                encryptedString = AES.getEncryptedString();

                sentencePropertiesObject.isDup = commonFunc(currentClusterName, encryptedString, fileName, indexOfSentence);
                sentencePropertiesObject.belongingClusterNumber = 11;
                
                return sentencePropertiesObject;
            }
        }
        //curSenLen = 0
        return sentencePropertiesObject;
    }

    public static void main(String[] args) throws FileNotFoundException {
        
    }
}
