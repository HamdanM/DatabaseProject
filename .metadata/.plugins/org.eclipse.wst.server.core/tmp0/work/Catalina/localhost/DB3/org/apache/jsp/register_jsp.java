/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.21
 * Generated at: 2019-07-25 16:46:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1564052948350L));
    _jspx_dependants.put("jar:file:/home/mohammad/Documents/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/DB3/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1563139928000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("   \n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"Register\" class=\"tab\">\n");
      out.write("    <h1>Register</h1>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("\n");
      out.write("// Function to check Whether both passwords \n");
      out.write("// is same or not. \n");
      out.write("function checkPassword(form) { \n");
      out.write("    password1 = form.password.value; \n");
      out.write("    password2 = form.password1.value; \n");
      out.write("\n");
      out.write("    if (password1 == '') \n");
      out.write("        alert (\"Please enter Password\"); \n");
      out.write("    else if (password2 == '') \n");
      out.write("        alert (\"Please enter confirm password\"); \n");
      out.write("    else if (password1 != password2) { \n");
      out.write("        alert (\"\\nPassword did not match: Please try again...\") \n");
      out.write("        return false; \n");
      out.write("    }else{\n");
      out.write("    \treturn true;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("} \n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<form onSubmit = \"return checkPassword(this)\" action=\"register\"\n");
      out.write("          method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"addToMailingList\" >\n");
      out.write("        <p style=\"color:green\"><label>Username: <input\n");
      out.write("                    type=\"text\" name=\"Username\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>\n");
      out.write("        <p style=\"color:red\"><label>Password: <input\n");
      out.write("                    type=\"password\" name=\"Password\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>\n");
      out.write("             <p style=\"color:red\"><label>Password: <input\n");
      out.write("                    type=\"password\" name=\"Password1\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>\n");
      out.write("        <p style=\"color:red\"><label>First Name: <input\n");
      out.write("                    type=\"text\" name=\"FirstName\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>\n");
      out.write("        <p style=\"color:red\"><label>Last Name: <input\n");
      out.write("                    type=\"text\" name=\"LastName\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>\n");
      out.write("        \n");
      out.write("        <p style=\"color:red\"><label>Email: <input\n");
      out.write("                    type=\"text\" name=\"Email\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>    \n");
      out.write("        \n");
      out.write("        <p style=\"color:red\"><label>Gender: <input\n");
      out.write("                    type=\"text\" name=\"Gender\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>    \n");
      out.write("            \n");
      out.write("        <p style=\"color:red\"><label>Age: <input\n");
      out.write("                    type=\"text\" name=\"Age\"\n");
      out.write("                    size=\"70\" maxlength=\"70\" />\n");
      out.write("            </label></p>\n");
      out.write("\n");
      out.write("        <p style=\"color:orange\"><input style=\"height:120px;width:225px\" type=\n");
      out.write("        \"submit\" name=\"submit\" value=\n");
      out.write("        \"Register\" /></p>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
