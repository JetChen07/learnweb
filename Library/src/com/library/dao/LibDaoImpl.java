package com.library.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.domain.*;
public class LibDaoImpl {
	public static final int FAIL=0;
	public static final int SUCCESS=1;
	private static final List<User> userDb = new ArrayList<User>();	
	private static final List<Catalog> cataList = new ArrayList<Catalog>();
	private static final List<Book> books = new ArrayList<Book>();
	private static final LibDaoImpl instance = new LibDaoImpl();
	
	public static LibDaoImpl getInstance() {
		return instance;
	}
	
	public void regist(User user) {
		userDb.add(user);
		
	}
	/*登录是否成功*/
	public int login(String username, String password) {
		for(User user:userDb) {
			if(user.getUserName().equals(username)&&user.getPassword().equals(password)){
				return SUCCESS;
			}
		}
		return FAIL;
	}
	/*是否存在该用户*/
	public int isUserExist(String username) {
		for(User user:userDb) {
			
			if(user.getUserName().equals(username)){
				return SUCCESS;
			}
		}
		return FAIL;
	}
	
	public void addBookCatgory(String id, String catgoryName, String description) {
		Catalog catalog = new Catalog(id,catgoryName,description); 
		cataList.add(catalog);
	}
	
	public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {
		return books;
	}
	
	public List<Catalog> getCatalogList(){
		return cataList;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
}
