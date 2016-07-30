/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax.ecms.com;

//import com.mysql.jdbc.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Glen Graebner
 */
public class LibraryServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LibraryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibraryServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } 
        finally {
            out.close();
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
        
        //processRequest(request, response);
        String action = request.getParameter("action");
        StringBuffer sb = new StringBuffer();
        
        if (action.equals("getlist")) {
            
            DataSource ds = null;
            Connection conn = null;
            ResultSet result = null;
            Statement stmt = null;
            
            try
            {
                Context context = new InitialContext();
                Context envCtx = (Context) context.lookup("java:comp/env");
                ds =  (DataSource)envCtx.lookup("jdbc/ecms");
                if (ds != null)
                {
                    try
                    {
                        conn = ds.getConnection();
                        stmt = conn.createStatement();
                        result = stmt.executeQuery("SELECT * FROM modules");

                        response.setContentType("text/xml");
                        response.setHeader("Cache-Control", "no-cache");
                        sb.append("<modules>");
                        
                        while (result.next()) 
                        {
                            sb.append("<module>" + result.getString("title") + "</module>");
                        }
                        
                        sb.append("</modules>");
                        response.getWriter().write(sb.toString());
                        
                        result.close();
                        stmt.close();
                        conn.close();
                    }
                    catch(SQLException e)
                    {}
                    finally 
                    {
                        try 
                        {
                            if (stmt != null)
                            stmt.close();
                        }  
                        catch (SQLException e)
                        {}
                        try 
                        {
                            if (conn != null)
                            conn.close();
                        } 
                        catch (SQLException e) 
                        {}
                    }
                }
            }
            catch (NamingException e) 
            {
                System.out.println("Error occurred " + e);
            }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

}
