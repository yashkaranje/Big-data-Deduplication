/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static package1.Begin.kscObj;
import static package1.Begin.loginid;

/**
 *
 * @author Yash R. Karanje
 */
public class MyLoginValidate extends HttpServlet {
    static String loginid;
    static String pwd;
    static KeyStore kscObj;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
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
            out.println("<title>Servlet MyLoginValidate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyLoginValidate at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
//	out.println("\n Response received");
	loginid = request.getParameter("loginid");
	pwd = request.getParameter("pwd");
          if(loginid.equals("anky@gmail.com") && pwd.equals("_anky")){
            try {
                kscObj = new package1.KeyStore();
                                
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
                
                kscObj.dostoreStream(loginid);
                
            } catch (KeyStoreException ex) {
                Logger.getLogger(MyLoginValidate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(MyLoginValidate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CertificateException ex) {
                Logger.getLogger(MyLoginValidate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnrecoverableEntryException ex) {
                Logger.getLogger(MyLoginValidate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("home.jsp");
            }else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid Credentials');");
                out.println("location='Login.html';");
                out.println("</script>");
            }        
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

}
