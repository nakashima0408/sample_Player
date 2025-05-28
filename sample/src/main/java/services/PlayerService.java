package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class PlayerService {
	
	 // DB接続情報（環境に合わせて修正）
    String url = "jdbc:mariadb://localhost:3306/soccer";
    String user = "root";
    String password = "root";
	
	public HashMap<String, String> getMapfromDB(){
		HashMap<String, String > map = new HashMap<>();
		
        try {
            // JDBCドライバのロード（必要に応じて）
            Class.forName("org.mariadb.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = con.prepareStatement("SELECT name, club FROM players");
                 ResultSet rs = stmt.executeQuery()) {
                
                	while (rs.next()) {
                		String name = rs.getString("name");
                		String club = rs.getString("club");
                		System.out.println(name + ":" + club);
                		map.put(name, club);
                	}

            	}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
	
	}
	public boolean insertPlayer(String name, String club) {
		String sql = "INSERT INTO players(name, club) VALUES (?, ?)";

            try {
            	Class.forName("org.mariadb.jdbc.Driver");
                try (Connection con = DriverManager.getConnection(url, user, password);
                     PreparedStatement pstmt = con.prepareStatement(sql)) {

                    pstmt.setString(1, name);
                    pstmt.setString(2, club);

                    int affectedRows = pstmt.executeUpdate();
                    return affectedRows > 0;  // 挿入成功ならtrue
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;  // エラー時はfalse
            
        

	}
	
	
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
