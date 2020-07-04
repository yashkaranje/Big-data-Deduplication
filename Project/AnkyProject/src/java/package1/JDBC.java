package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC{
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    int resultBool = 0;
    String query = null;
    ResultSet ress = null;
	
    public JDBC() {
    	try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("found Driver");
	} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
		
	try {
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/beproject", "**", "**"); 
            System.out.println("Got Connection");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
    }
    
    boolean isAvailable(String currentClusterName, String encryptedString){
        try {
            query = "select * from " + currentClusterName + " where encryptedtext = ?;";
//            stmt = con.createStatement();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, encryptedString);
//            pstmt.setString(1, encryptedString);
            ress = pstmt.executeQuery();
            if (!ress.isBeforeFirst()) {    
                //empty
                return false;
            } 
            //con.close();
	} catch (SQLException e) {
            e.printStackTrace();
	}
        return true;
    }
    
    ResultSet doSearchByFileName(String currentClusterName, String fileName){
        fileName = "%" + fileName + "%";
        try {
            query = "select * from " + currentClusterName + " where fileinfo like ?;";
//            stmt = con.createStatement();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, fileName);
//            pstmt.setString(1, encryptedString);
            ress = pstmt.executeQuery();
//            while(ress.next()){
//                System.out.println(ress.getString(1));
//            }
            if (!ress.isBeforeFirst()) {    
                //empty
                return null;
            } 
            //con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return ress;
    }
    
    public ResultSet displayData(){
    	try {
            query = "select filename from filerecord;";
            stmt = con.createStatement();
            ress = stmt.executeQuery(query);
            //con.close();
	} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        return ress;
    }
    
//    boolean isAvailable(String fileName){
//        try {
//            query = "select * from filerecord where filename = ?;";
////            stmt = con.createStatement();
//            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, fileName);
////            pstmt.setString(1, encryptedString);
//            ress = pstmt.executeQuery();
//            if (!ress.isBeforeFirst()) {    
//                //empty
//                return false;
//            } 
//            //con.close();
//	} catch (SQLException e) {
//            e.printStackTrace();
//	}
//        return true;
//    }
    
    FileRecordClassPOJO isAvailable(String fileName){
        FileRecordClassPOJO fileRecorderClassObj = new FileRecordClassPOJO();
//        String temp = "";
        try {
            query = "select clusternumbers from filerecord where filename = ?;";
//            stmt = con.createStatement();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, fileName);
//            pstmt.setString(1, encryptedString);
            ress = pstmt.executeQuery();
            while(ress.next()){
                fileRecorderClassObj.clusterString = ress.getString(1);
                fileRecorderClassObj.isfileAvailable = true;
            } 
            //con.close();
	} catch (SQLException e) {
            e.printStackTrace();
	}
        return fileRecorderClassObj;
    }    
    
    int doUpdateContent(String currentClusterName, String encryptedString, String fileName, int indexOfSentence){
        String temp = "";
        try {
            query = "select fileinfo from " + currentClusterName + " where encryptedtext = ?;";
            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, currentClusterName);
            pstmt.setString(1, encryptedString);
            ress = pstmt.executeQuery();
            while(ress.next()){
                temp = ress.getString(1);
            } 
            //con.close();
	} catch (SQLException e) {
            e.printStackTrace();
	}
        
        if(!temp.contains(fileName+"-"+indexOfSentence)){
            temp+=","+fileName+"-"+indexOfSentence;        
            try {
            query = "UPDATE " + currentClusterName + " set fileinfo=? where encryptedtext=?;";
            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, currentClusterName);
            pstmt.setString(1, temp);
            pstmt.setString(2, encryptedString);
            resultBool = pstmt.executeUpdate();
//            con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }       				
	return resultBool;
    }
    
    int doInsert(String currentClusterName, String encryptedString, String fileName, int indexOfSentence){
        String temp = "";
        try {
            query = "select fileinfo from " + currentClusterName + " where encryptedtext = ?;";
            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, currentClusterName);
            pstmt.setString(1, encryptedString);
            ress = pstmt.executeQuery();
            while(ress.next()){
                temp = ress.getString(1);
            } 
            //con.close();
	} catch (SQLException e) {
            e.printStackTrace();
	}
        
        if(!temp.contains(fileName+"-"+indexOfSentence)){
            temp+=fileName+"-"+indexOfSentence;
            
            try {
            query = "insert into " + currentClusterName + " values(?,?);";
            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, currentClusterName);
            pstmt.setString(1, encryptedString);
            pstmt.setString(2, temp);
            resultBool = pstmt.executeUpdate();
//            con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }  				
	return resultBool;
    }
    
    int doInsert(String fileName, String belongingClusterNumbersString){
        try {
            query = "insert into filerecord values(?,?);";
            pstmt = con.prepareStatement(query);
//            pstmt.setString(1, currentClusterName);
            pstmt.setString(1, fileName);
            pstmt.setString(2, belongingClusterNumbersString);
            resultBool = pstmt.executeUpdate();
//            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }         				
	return resultBool;
    }
    
    public static void main(String[] args) throws SQLException {
//        JDBC obj = new JDBC(); 
//        obj.isAvailable("cluster1", "pqr.txt", true);
//        System.out.println(obj.doInsert("Lol2.txt", "3,4,6"));
//        System.out.println(obj.getClusterNumbers("Lol.txt"));

//       ResultSet ress = obj.displayData();
//       while(ress.next()){
//           System.out.println(ress.getString(1));
//       }
    } 
}


/*
truncate cluster1;
truncate cluster2;
truncate cluster3;
truncate cluster4;
truncate cluster5;
truncate cluster6;
truncate cluster7;
truncate cluster8;
truncate cluster9;
truncate cluster10;
truncate cluster11;
truncate filerecord;
*/