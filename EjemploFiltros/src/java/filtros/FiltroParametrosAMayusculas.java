/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import filtros.wrappers.WrapperRequestParametrosAMayusculas;
import filtros.wrappers.WrapperResponseParametrosAMayusculas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
public class FiltroParametrosAMayusculas implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            WrapperRequestParametrosAMayusculas pedidoFalso = new WrapperRequestParametrosAMayusculas((HttpServletRequest)request);
            WrapperResponseParametrosAMayusculas respuestaFalsa = new WrapperResponseParametrosAMayusculas((HttpServletResponse)response);
            
            chain.doFilter(pedidoFalso, respuestaFalsa);
            
            PrintWriter salida = response.getWriter();
            
            try {
                String advertencia = "<p style=\"background-color: red; color: white; font-weight: bold;\">¡ADVERTENCIA! Este servlet ha sido filtrado.</p>";
                String htmlRespuesta = respuestaFalsa.toString().replace("</body>", advertencia + "\n</body>");
                
                salida.print(htmlRespuesta);
            } finally {
                salida.close();
            }
        }
    }
    
    @Override
    public void destroy() {
        
    }
    
}
