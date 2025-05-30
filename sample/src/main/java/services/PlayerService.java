package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import beans.Player;
import utils.Db;

public  class PlayerService extends Service<Player> {
	
	public ArrayList<Player> select() {
		String sql = "select * from players";

		ArrayList<Player> players = new ArrayList<>();

		try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();)
		{
			while (rs.next()) {
				LocalDate birthDate = (rs.getDate("birth") != null) ? 
						rs.getDate("birth").toLocalDate() : null ; 
				
				//java.sql.DateをJavaのjava.time.LocalDate型に変換しています。
				//java.sql.DateはJDBCが使う日付型ですが、
				//近年のJavaアプリケーションではjava.time.LocalDateを使うのが標準的で、
				//扱いやすいからです。つまり、SQLの日付をJavaのLocalDateに変換して
				//変数にセットしているということです。
			    
				players.add(
						new Player(
								rs.getInt("id"),
								rs.getInt("country_id"),
								rs.getInt("uniform_num"),
								rs.getString("position"),
								rs.getString("name"),
								rs.getString("club"),
								birthDate, 
								rs.getInt("height"),
								rs.getInt("weight")));
			}
		} catch (Exception se) {
			se.printStackTrace();
		}

		return players;
	}

	@Override
	public Player selectById(int id) {
		String sql = "select * from players where id = ?;";

		Player player = null;

		try (
			Connection con = Db.open();
			PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				LocalDate birthDate = (rs.getDate("birth") != null) ? rs.getDate("birth").toLocalDate() : null ;  
				player = new Player(
						rs.getInt("id"),
						rs.getInt("country_id"),
						rs.getInt("uniform_num"),
						rs.getString("position"),
						rs.getString("name"),
						rs.getString("club"),
						birthDate,  // ここで使う
						rs.getInt("height"),
						rs.getInt("weight"));
			}
		} catch (Exception se) {
			se.printStackTrace();
		}

		return player;
	}

	@Override
	public int insert(Player object) {
		String sql = "insert into players(country_id, uniform_num, position, name, club, birth, height, weight) values (?,?,?,?,?,?,?,?);";
		int id = 0;

		try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement
						(sql, java.sql.Statement.RETURN_GENERATED_KEYS);){
			
			ps.setInt(1, object.getCountry_id());
			ps.setInt(2, object.getUniform_num());
			ps.setString(3, object.getPosition());
			ps.setString(4, object.getName());
			ps.setString(5, object.getClub());
			ps.setDate(6, Date.valueOf(object.getBirth()));
			ps.setInt(7, object.getHeight());
			ps.setInt(8, object.getWeight());
			ps.executeUpdate();

			ResultSet res = ps.getGeneratedKeys();
			if (res.next()) {
				id = res.getInt(1);
			}
		} catch (Exception se) {
			se.printStackTrace();
		}
		return id;
	}

	@Override
	public void update(Player object) {
		String sql = "update players set";
		sql += " country_id = ?, uniform_num = ?, position = ?, name = ?, club = ?, birth = ?, height = ?, weight= ?";
		sql += " where id = ?";

		try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setInt(1, object.getCountry_id());
			ps.setInt(2, object.getUniform_num());
			ps.setString(3, object.getPosition());
			ps.setString(4, object.getName());
			ps.setString(5, object.getClub());
			ps.setDate(6, Date.valueOf(object.getBirth()));
			ps.setInt(7, object.getHeight());
			ps.setInt(8, object.getWeight());
			ps.setInt(9, object.getId());
			ps.executeUpdate();

		} catch (Exception se) {
			se.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from players where id = ?";

		try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception se) {
			se.printStackTrace();
		}
	}

}