package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class JSPTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/resources/Header.html");
    _jspx_dependants.add("/resources/NavBarTemplate.html");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>JSP Template</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/main.css\">        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Header</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/header.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"header-logo\">\n");
      out.write("                <img id=\"header-img\" src=\"resources/xyz-logo.png\" alt=\"Home Page\">\n");
      out.write("                <h1 id=\"header-txt\">Drivers Association</h1>\n");
      out.write("            </div>  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>NavBar</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/navBar.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"navBar\">\n");
      out.write("            <ul class=\"menu\">\n");
      out.write("                <li><a href=\"/html/default.asp\">Place holder</a></li>\n");
      out.write("                <li><a href=\"/css/default.asp\">Place holder</a></li>\n");
      out.write("                <li><a href=\"/html/default.asp\">Place holder</a></li>\n");
      out.write("                <li><a href=\"/html/default.asp\">Place holder</a></li>\n");
      out.write("                <li><a href=\"/html/default.asp\">HTML</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- Example Content -->\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div style=\"height:600px;\">\n");
      out.write("                <a href=\"http://imgur.com/k9hz3\">\n");
      out.write("                    <img src=\"http://i.imgur.com/k9hz3.jpg\" title=\"Hosted by imgur.com\" alt=\"\" />\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"height:600px;\">\n");
      out.write("                <a href=\"http://imgur.com/TXuFQ\">\n");
      out.write("                    <img src=\"http://i.imgur.com/TXuFQ.jpg\" title=\"Hosted by imgur.com\" alt=\"\" />\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                      \n");
      out.write("    </body>\n");
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
