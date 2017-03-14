package com.mmt.model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.mmt.model.bean.User;

public interface UserDaoMMT {
	public int insert(User user) throws SQLException, ClassNotFoundException, IOException ;
	public User search(String  uid) throws SQLException, ClassNotFoundException, IOException ;
	public int delete (String uid) throws SQLException, ClassNotFoundException, IOException ;
	public int update(String uid, User user) throws SQLException, ClassNotFoundException, IOException;
	public List<User> displayAll() throws SQLException, ClassNotFoundException, IOException;
}
