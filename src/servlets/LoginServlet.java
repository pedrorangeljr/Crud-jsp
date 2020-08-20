package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoLogin;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DaoLogin daoLogin = new DaoLogin();
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
		BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(daoLogin.validarLogin(login, senha)) {
			
			request.getRequestDispatcher("cadastroUsuario.jsp").forward(request, response);
			
		}
		else {
			
			request.getRequestDispatcher("acessonegado.jsp").forward(request, response);
		}
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
