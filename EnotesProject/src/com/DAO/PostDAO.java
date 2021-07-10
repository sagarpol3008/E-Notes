package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;
import com.User.UserDetails;

public class PostDAO {

	private Connection connection;

	public PostDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean AddNotes(String ti, String co, int ui) {

		boolean f = false;

		try {
			String query = "insert into post(title,content,uid) values(?,?,?)";

			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, ti);
			preparedstatement.setString(2, co);
			preparedstatement.setInt(3, ui);

			int i = preparedstatement.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {

		}

		return f;

	}

	public List<Post> getData(int id) {
		List<Post> list = new ArrayList<Post>();
		Post po = null;

		try {

			String query = "select * from post where uid=? order by id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);

			ResultSet resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				po = new Post();
				po.setId(resultset.getInt(1));
				po.setTitle(resultset.getString(2));
				po.setContent(resultset.getString(3));
				po.setPdate(resultset.getTimestamp(4));

				list.add(po);

			}

		} catch (Exception e) {

		}

		return list;

	}
	
	public Post getDataById(int noteId) {
		Post p = null;
		
		try {
			String query = "select * from post where id=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, noteId);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				p = new Post();
				p.setId(resultset.getInt(1));
				p.setTitle(resultset.getString(2));
				p.setContent(resultset.getString(3));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return p;
	}
	
	public boolean PostUpdate(int nid, String ti, String co) {
		boolean f = false;
		
		try {
			String query = "update post set title=?,content=? where id=?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, ti);
			preparedstatement.setString(2, co);
			preparedstatement.setInt(3, nid);
			
			int i = preparedstatement.executeUpdate();
			
			if(i==1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	public boolean DeleteNotes(int nid) {
		boolean f = false;
		
		try {
			
			String query = "delete from post where id=?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, nid);
			int x = preparedstatement.executeUpdate();
			
			if(x==1) {
				f = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}

}
