package ssdi.carrentalsystem.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author hpam
 * 
 * Login filter that checks for valid user session
 * 
 */
public class LoginFilter implements Filter {
	
	private FilterConfig filterConfig = null;
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String url = req.getRequestURL().toString();
		String matchURL = url.substring(url.lastIndexOf("/"), url.length());
		System.out.println("Url request " + matchURL);
		Enumeration<String> paramName = filterConfig.getInitParameterNames();
		
		boolean exclusionMatch = false;
		while(paramName.hasMoreElements()) {
			String param = paramName.nextElement();
			String excludeUrl = (filterConfig.getInitParameter(param));
			
			if(excludeUrl.equals(matchURL)) {
				System.out.println("Match!");
				exclusionMatch = true;
				break;
			}
		}
		
		if(exclusionMatch) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession(false);
			if (session == null || session.getAttribute("user") == null) {
				System.out.println("No user session. Redirecting to login.jsp");
				res.sendRedirect("login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}
}