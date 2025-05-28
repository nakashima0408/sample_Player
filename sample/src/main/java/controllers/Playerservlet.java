package controllers;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import services.PlayerService;
/**
 * Servlet implementation class Mapservlet
 */
@WebServlet("/Playerservlet")
public class Playerservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//MapService という別クラスからデータ（Map）を取得するための処理です。
		//MapService クラスのインスタンス（＝オブジェクト）を作成
		PlayerService service = new PlayerService();
		//MapService の getMap() メソッドを呼び出しています。

//		このメソッドは HashMap<String, String> 型の値を返すように作られているので、
		//その戻り値を map 変数に代入しています。
		HashMap<String, String> map = service.getMapfromDB();
		System.out.println("Map size: " + map.size());
		
		request.setAttribute("maps", map);
		
		request.getRequestDispatcher("/Player.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");  // 文字化け防止

        String name = request.getParameter("name");
        String club = request.getParameter("club");

        PlayerService service = new PlayerService();

        boolean success = service.insertPlayer(name, club);

        if (success) {
            // 登録成功なら一覧ページへリダイレクト
            response.sendRedirect("/Player.jsp");
        } else {
            // 登録失敗時はエラーメッセージなど表示（簡単な例）
            response.getWriter().println("登録に失敗しました。");
        }
    }
}


