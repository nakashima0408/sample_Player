package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ifget
 */
@WebServlet("/ifservlet")
public class ifservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int point = 80;
		//requestオブジェクトにデータを追加
		request.setAttribute("point", point);
		
		//JSPに転送（forward)
		request.getRequestDispatcher("/if.jsp").forward(request, response);
        
		
	}

	}


