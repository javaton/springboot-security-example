package hello;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

import java.io.IOException;

/**
 * Created by djordje.colovic on 04-Apr-18.
 */
public class JWTAuthenticationFilter extends  GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Mesto za custom Authorization");
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        System.out.println(httpRequest.getHeader("Authorization"));
        System.out.println(httpRequest.getHeader("username"));

        if(!httpRequest.getHeader("Authorization").isEmpty()){
            System.out.println("Ima Authorization param");
        } else {
            throw new HTTPException(401);
        }

        chain.doFilter(req, res);
    }

}
