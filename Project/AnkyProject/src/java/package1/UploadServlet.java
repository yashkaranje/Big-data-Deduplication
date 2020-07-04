package package1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.*;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.*;

public class UploadServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:\\DRIVE\\NBN SSOE\\BE\\BE Project\\Implementation\\Chunking\\FileUpload";    
    static String s = new String();
    static Scanner sc;
    KeyStore kscObj = null;
    String loginid = null;
    /**
     * Processes requestsfor both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        String fileName = null;
        String fileLocation = null;
        PrintWriter outw = response.getWriter();
        
            if(ServletFileUpload.isMultipartContent(request)){
                try {
                    List<FileItem> multiparts = new ServletFileUpload(
                                             new DiskFileItemFactory()).parseRequest(request);

                    for(FileItem item : multiparts){
                        if(!item.isFormField()){
                            fileName = new File(item.getName()).getName();
                            item.write( new File(UPLOAD_DIRECTORY + File.separator + fileName));
                        }
                    }



                    fileLocation = UPLOAD_DIRECTORY + "\\" + fileName;                
                    kscObj = MyLoginValidate.kscObj;
                    loginid = MyLoginValidate.loginid;

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
                            outw.println("<script type=\"text/javascript\">");      
                            outw.println("alert('Added File " + fileName + " successfully')");
                            percentageDedup = ((float)dupsCount/(float)senCount) * 100;

                            outw.println("alert('Total no of lines: " + lineCount + " | Total no of sentences: " + senCount + " | Total no of duplicates found: " + dupsCount + " | Deduplication done: "+ percentageDedup +"')");
                            outw.println("location='home.jsp';");
                            outw.println("</script>");
                        }else{
                            outw.println("<script>");
                            outw.println("alert('Add File record  " + fileName + " Failed.');");
                            outw.println("</script>");
                        }
                    }else{
                        outw.println("<script type=\"text/javascript\">");
                        outw.println("alert('Filename already exists.');");
                        outw.println("location='home.jsp';");
    //                    outw.println("document.getElementById(#iddetails).innerHTML = 'yash';");
                        outw.println("</script>");
                    }              
                }catch (Exception ex) {
                   outw.println("alert('ex.printStackTrace());");
                   System.exit(0);
                }          
            }else{
                outw.println("alert('Sorry this Servlet only handles file upload request');");
                System.exit(0);
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void blocking(KeyStore kscObj, String loginid, String fileLocation1) throws FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, UnrecoverableKeyException {
//        System.out.println("Enter file location to upload: ");
        //C:\DRIVE\NBN SSOE\BE\BE Project\Implementation\Chunking\Upload\Lol.txt
//        sc = new Scanner(System.in);
//        String fileLocation = sc.nextLine();
                
    }

}
