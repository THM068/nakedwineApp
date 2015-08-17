package demo.naked.appointment.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by tm1c14 on 14/08/2015.
 */
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //do something before
        System.out.println("> before something");

        chain.doFilter(request, response);
        request.setAttribute("name", "Thando Mafela");
        System.out.println("< after something");
    }

    @Override
    public void destroy() {

    }
}
