/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Producto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raúl
 */
public class Buscador extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            throw new UnavailableException("No se pudo inicializar el servlet Buscador.");
        }
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            int codigo = 0;
            
            try {
                codigo = Integer.parseInt(request.getParameter("codigo"));
            } catch (NumberFormatException ex) {
                throw new ServletException("El código del producto no es válido.");
            }
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjercicioJSPServletsYBeans", "root", "root");
            
            consulta = conexion.prepareStatement("SELECT * FROM Productos WHERE Codigo = ?;");
            consulta.setInt(1, codigo);
            
            resultadoConsulta = consulta.executeQuery();
            
            if (resultadoConsulta.next()) {
                String descripcion = resultadoConsulta.getString("Descripcion");
                double costo = resultadoConsulta.getDouble("Costo");
                int stockActual = resultadoConsulta.getInt("StockActual");
                
                Producto producto = new Producto(codigo, descripcion, costo, stockActual);
                
                request.setAttribute("producto", producto);
                
                RequestDispatcher despachador = request.getRequestDispatcher("MostrarProducto.jsp");
                
                if (despachador != null) {
                    despachador.forward(request, response);
                }
            } else {
                request.setAttribute("codigo", codigo);
                
                response.sendError(404);
            }
        } catch (SQLException ex) {
            throw new ServletException("¡ERROR! Se produjo un error con la base de datos.");
        } finally {
            try {
                if (resultadoConsulta != null) {
                    resultadoConsulta.close();
                }
                
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Se produjo un error al cerrar los recursos.");
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
