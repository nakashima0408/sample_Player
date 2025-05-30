package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utils.Common;

/**
 * Servlet implementation class BmiSevlet
 */
	

@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		double h = Double.parseDouble(request.getParameter("height"));
		double w = Double.parseDouble(request.getParameter("weight"));
		
		double bmi = Common.calcBmi(h, w);
		String rank = Common.getBmiResult(bmi);
		
		request.setAttribute("bmi", bmi);
		request.setAttribute("rank", rank);
		
		request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
		
		
	}

	
	}

	