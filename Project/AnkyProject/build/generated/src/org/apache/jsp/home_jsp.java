package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import package1.JDBC;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Home</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"home.css\">\n");
      out.write("    <script>\n");
      out.write("\t\t$(document).ready(function(){\n");
      out.write("\t\t\t$(\"#show-toast\").click(function(){\n");
      out.write("\t\t\t\t\t$(\"#myToast\").toast('show');\n");
      out.write("\t\t\t});\n");
      out.write("\t});\n");
      out.write("\t</script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"\">\n");
      out.write("        <nav class=\"navbar sticky-top navbar-expand-lg\" style=\"background-color: #519194;\">\n");
      out.write("          <div class=\"header\" style=\"margin-left: -16px;\">\n");
      out.write("            <div class=\"progress-container\">\n");
      out.write("              <div class=\"progress-bar btn-myprimary\" id=\"myBar\"></div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-light\" style=\"background-color: #519194;\">\n");
      out.write("            <a class=\"navbar-item\">\n");
      out.write("              <!-- <img src=\"q.jpg\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"spec\"> -->\n");
      out.write("              <span class=\"navbar-brand mb-0 h1\" style=\"color: white;\">Welcome!</span>\n");
      out.write("            </a>\n");
      out.write("          </nav>\n");
      out.write("\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("          </button>\n");
      out.write("\n");
      out.write("          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("              <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"home.html\" style=\"color: white; margin-left: 20px;\">Home</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a class=\"nav-link\" href=\"info.html\" style=\"color: white; margin-left: 20px;\">About</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a target=\"_blank\" id=\"show-toast\" class=\"nav-link\"><p style=\"color: white; margin-left: 20px;\">Help</p></a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\" style=\"padding-left:900px;\">\n");
      out.write("                  <a class=\"nav-link\" href=\"#profwName\" style=\"color: white;\">LogOut</a>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("      <div aria-live=\"assertive\" aria-atomic=\"false\" class=\"d-flex justify-content-center align-items-center\">\n");
      out.write("      \t<!-- <button type=\"button\" class=\"btn btn-primary\">Show Toast</button> -->\n");
      out.write("        <div class=\"toast\" role=\"alert\" data-autohide=\"false\" id=\"myToast\" style=\"position: absolute; left:250px; padding-top:150px;\">\n");
      out.write("        \t<div class=\"toast-header\">\n");
      out.write("          \t<!-- <img src=\"gmail.png\" class=\"rounded mr-2\" alt=\"gmail.png\" style=\"max-height: 20px;\"> -->\n");
      out.write("            <strong class=\"mr-auto\"><i class=\"\"></i>Contact Us...</strong>\n");
      out.write("            <!-- <small></small> -->\n");
      out.write("            <button type=\"button\" class=\"ml-2 mb-1 close\" data-dismiss=\"toast\" style=\"align: right;\">\n");
      out.write("            \t<span aria-hidden=\"true\">&times;</span>\n");
      out.write("            </button>\n");
      out.write("          </div>\n");
      out.write("        \t<div class=\"toast-body\">\n");
      out.write("          \t<label><p style=\"color: #000000;\"></p><strong style=\"color: blue; font-size: 110%;\">anky@gmail.com</strong></label>\n");
      out.write("          </div>\n");
      out.write("      \t</div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"myImg\">\n");
      out.write("      <div class=\"jumbotron container\">\n");
      out.write("        <!-- <div class=\"row\">\n");
      out.write("                  <div class=\"col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch\">\n");
      out.write("                      <button type=\"button\" class=\"btn btn-secondary btn-lg mybtn\">UPLOAD 📤</button>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch\">\n");
      out.write("                      <button type=\"button\" class=\"btn btn-info btn-lg mybtn\">DOWNLOAD 📥 </button>\n");
      out.write("                  </div>\n");
      out.write("        </div> -->\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch\">\n");
      out.write("            <div class=\"\">\n");
      out.write("                <form action=\"UploadServlet\" method=\"get\">\n");
      out.write("                    <br>\n");
      out.write("                    <!-- <label for=\"myfile\">Select a file:</label><br> -->\n");
      out.write("                    <input type=\"file\" id=\"myfile\" name=\"myfile\"><br><br>\n");
      out.write("                    <!-- <input type=\"submit\" class=\"btn btn-success\"> -->\n");
      out.write("                    <input type=\"submit\" value=\"UPLOAD 📤\" class=\"btn btn-secondary btn-lg mybtn\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch\">\n");
      out.write("            <div class=\"\">\n");
      out.write("                <form action=\"DownloadServlet\" method=\"get\">\n");
      out.write("                    <p></p>\n");
      out.write("                    <label for=\"fname\">Enter File Name: </label>\n");
      out.write("                    <input type=\"text\" id=\"myfile\" name=\"mytext\"><br><br>\n");
      out.write("                    <!-- <input type=\"submit\" class=\"btn btn-success\"> -->\n");
      out.write("                    <input type=\"submit\" value=\"DOWNLOAD 📥\" class=\"btn btn-info btn-lg mybtn\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("    ");
  JDBC jdbcobj = new JDBC();
    ResultSet ress = jdbcobj.displayData(); 
    int fileCount = 1;
      out.write("        \n");
      out.write("      <div class=\"container jumbotron myImgTable\">\n");
      out.write("        <table class=\"table table-hover table-sm\">\n");
      out.write("          <thead class=\"thead-dark\">\n");
      out.write("            <tr>\n");
      out.write("              <th scope=\"col\">Sr. No.</th>\n");
      out.write("              <th scope=\"col\">Available Files</th>\n");
      out.write("            </tr>\n");
      out.write("          </thead>\n");
      out.write("          <tbody style=\"color: white;\">              \n");
      out.write("            ");
  while(ress.next()){ 
      out.write("\n");
      out.write("               <tr>\n");
      out.write("                   <th scope=\"row\">");
      out.print(fileCount++);
      out.write("</th>\n");
      out.write("                   <td> ");
      out.print(ress.getString(1));
      out.write(" </td>\n");
      out.write("               </tr>\n");
      out.write("            ");
  }   
      out.write("              \n");
      out.write("        </tbody>\n");
      out.write("      </table>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("        <div id=\"footer\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\t\t&copy; copyright 2020 | all rights reserved.\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
