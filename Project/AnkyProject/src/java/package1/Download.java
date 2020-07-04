package package1;

import package1.Anky;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Download {
    Scanner sc = null; 
    ResultSet ress = null;
    Heap heapObj = null;
    KeyStore kscObj = null;

    public Download() throws KeyStoreException, IOException, FileNotFoundException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        sc = new Scanner(System.in);
        heapObj = new Heap();
        kscObj = new KeyStore();
    }
        
    public boolean download(String loginid, String fileName1) throws FileNotFoundException {       
//        System.out.println("Enter the file name to download: ");
//        String fileName = sc.nextLine();
        String fileName = fileName1;
        JDBC jdbcObj = new JDBC();
        
        FileRecordClassPOJO fileRecorderClassPojoObj = jdbcObj.isAvailable(fileName);
        if(fileRecorderClassPojoObj.getIsfileAvailable()){
            String clusterNumbers = fileRecorderClassPojoObj.getClusterString();
            String[] arr = clusterNumbers.split(",");
            for(String currentClusterNumber : arr){
                ress = jdbcObj.doSearchByFileName("cluster" + currentClusterNumber, fileName);
                try{
                    while(ress.next()){
                        String[] fileInfoArr = ress.getString(2).split(",");
                        for(String currentFileInfo : fileInfoArr){
                            String[] currentSentenceInfo = currentFileInfo.split("-");
                            if(currentSentenceInfo[0].equals(fileName)){                             
                                AES.setKey(kscObj.doRetrieveSecKeyFromKeyStore("cluster" + currentClusterNumber, loginid));
                                AES.decrypt(ress.getString(1).trim());                             
                                heapObj.doInsertIntoHeap(AES.getDecryptedString(), Integer.parseInt(currentSentenceInfo[1]));
                            }
                        }                    
//                        System.out.println(ress.getString(1) + " " + ress.getString(2));
                    }
                }catch(Exception e){
//                    System.out.println("NullPointerException may be...");
                    e.printStackTrace();
                }                                
            }
            if(heapObj.doShowHeap(fileName)){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("Error 404 : File Not Found");
            return false;
        }       
    }
    
    public static void main(String[] args) throws KeyStoreException, IOException, FileNotFoundException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
//        new Download().download("yashkaranje98");
    }
}
