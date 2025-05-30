package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Player;
import services.PlayerService;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/Playerservlet")
public class Playerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Playerservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Modelからページの表示に必要なデータを取得
		ArrayList<Player> players = null;
		PlayerService ps = new PlayerService();
		players = ps.select();

		request.setAttribute("players", players);

		request.getRequestDispatcher("/Player.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コード設定（フォームの日本語対応など）
		request.setCharacterEncoding("UTF-8");
	try {
	    int countryId = Integer.parseInt(request.getParameter("country_id"));
	    int uniformNum = Integer.parseInt(request.getParameter("uniform_num"));
	    String position = request.getParameter("position");
	    String name = request.getParameter("name");
	    String club = request.getParameter("club");
	    LocalDate birth = LocalDate.parse(request.getParameter("birth"));
	    int height = Integer.parseInt(request.getParameter("height"));
	    int weight = Integer.parseInt(request.getParameter("weight"));

	    Player newPlayer = new Player();
	    	newPlayer.setCountry_id(countryId);
	    	newPlayer.setUniform_num(uniformNum);
	    	newPlayer.setPosition(position);
	    	newPlayer.setName(name);
	    	newPlayer.setClub(club);
	    	newPlayer.setBirth(birth);
	    	newPlayer.setHeight(height);
	    	newPlayer.setWeight(weight);

	    PlayerService ps = new PlayerService();
	    ps.insert(newPlayer);  // INSERTを行うサービスメソッド

	    // 登録完了後に一覧へリダイレクト
	    response.sendRedirect("Playerservlet");
	    
		} catch (Exception e) {
		e.printStackTrace();
		response.getWriter().println("登録中にエラーが発生しました: " + e.getMessage());
		}
	}      
}