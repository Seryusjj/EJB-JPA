package presentation.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.User;

//Los import no se incluyen aquí pero sí los verás en eclipse
/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, 
description = "Filtro de seguridad", 
urlPatterns = {	"/restricted/alumno/*", "/restricted/profesor/*" },
initParams = { @WebInitParam(name = "InitPage", value = "/restricted/admin/index.xhtml", description = "Pagina de inicio"),
			   @WebInitParam(name = "LoginParam", value = "/../../logueo.xhtml", description = "Pagina de logueo") })
public class LoginVerifierAdmin implements Filter {
	// Necesitamos acceder a los parámetros de inicialización en
	// el método doFilter por lo que necesitamos la variable
	// config que se inicializará en init()
	FilterConfig config = null;

	/**
	 * Default constructor.
	 */
	public LoginVerifierAdmin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig) -10-
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		// Iniciamos la variable de instancia config
		config = fConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Si no es petición HTTP nada que hacer
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		// En el resto de casos se verifica que se haya hecho login previamente
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		User loggeedin = (User) session.getAttribute("LOGGEDIN_USER");
		if(loggeedin==null){
			String loginForm = config.getInitParameter("LoginParam");

			// Si no hay login, redirección al formulario de login
			res.sendRedirect(req.getContextPath() + loginForm);
			return;
		}
		else if (loggeedin instanceof Admin) {
			String loginForm = config.getInitParameter("InitPage");

			// Si no hay login, redirección al formulario de login
			res.sendRedirect(req.getContextPath() + loginForm);
			return;
		}
		chain.doFilter(request, response);
	}
}