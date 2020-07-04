//Filename -> Belonging Clusters -> Clusters -> Sentences -> Indexes

package package1;

import java.io.*;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.sql.Timestamp;
import java.util.*;
import javax.swing.*;

public class Blocking {
    static String s = new String();
    static Scanner sc;
    
    public void blocking(KeyStore kscObj, String loginid, String fileLocation1) throws FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, UnrecoverableKeyException {
        String fileLocation = fileLocation1;
        String[] arr = fileLocation.split("\\\\");
        String fileName = arr[arr.length-1];        
        sc = new Scanner(new File(fileLocation));
        PrintWriter out = new PrintWriter(new FileOutputStream("C:\\DRIVE\\NBN SSOE\\BE\\BE Project\\Implementation\\Chunking\\LolOp.txt"), true);   

        Anky ankyObj = new Anky();
        int lineCount = 0;
        int senCount = 0;
        int dupsCount = 0;
        boolean clusterArray[] = new boolean[12];
        float percentageDedup = 0.0f;
        String belongingClusterNumbersString = "";
        JDBC jdbcObj = new JDBC();  

        
        if(!jdbcObj.isAvailable(fileName).getIsfileAvailable()){
            while (sc.hasNextLine()) { //while the code ends
                s = sc.nextLine();
                lineCount++;
                String op = "";
                String curString = "";

                for(int i=0;i<s.length();i++){
                    char curChar;
                    curChar = s.charAt(i);
                    curString+=curChar; 
                    if(curChar == '.' || curChar == ';' || curChar == '!' || curChar == '?'){
                        out.println(curString);
                        senCount++;
                        SentencePropertiesPOJO senPropObj = ankyObj.doClustering(curString, fileName, senCount, kscObj, loginid);
                        if(senPropObj.isDup){
                            //returns true if duplicate found
                            dupsCount++;
                        }
                        if(senPropObj.belongingClusterNumber > 0){
                            System.out.println(senPropObj.belongingClusterNumber);
                            clusterArray[senPropObj.belongingClusterNumber] = true;
                        }
                        curString = ""; 
                        i++;
                    }                
                }  
            }
        
            for(int i=0;i<clusterArray.length;i++){
                if(clusterArray[i]){
                    belongingClusterNumbersString+=i+",";
                }
            }
            belongingClusterNumbersString = belongingClusterNumbersString.substring(0, belongingClusterNumbersString.length()-1);
            
            if(jdbcObj.doInsert(fileName, belongingClusterNumbersString) == 1){
                System.out.println("Added File record " + fileName + " successfully");
                percentageDedup = ((float)dupsCount/(float)senCount) * 100;
            }else{
                System.out.println("Add File record " + fileName + " failed");
            }
            
            System.out.println("File name: " + fileName);
            System.out.println("Total no of lines: " + lineCount);
            System.out.println("Total no of sentences: " + senCount);
            System.out.println("Total no of duplicates found: " + dupsCount);
            System.out.println("Deduplication done: " + percentageDedup + "%");
            
        }else{
            System.out.println("Filename " + fileName + " already exists.");
        }        
    }
    
    public static void main(String[] args) {
        
    }
}
