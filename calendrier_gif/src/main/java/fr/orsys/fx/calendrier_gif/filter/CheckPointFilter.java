package fr.orsys.fx.calendrier_gif.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // Premier filtre à exécuter lorsque le serveur reçoit une requête HTTP
public class CheckPointFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Ok");
		request.setAttribute("msDepart", new Date().getTime());
		chain.doFilter(request, response);
		
	}
}