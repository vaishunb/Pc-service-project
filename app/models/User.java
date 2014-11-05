package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model{
	
	
	@Id
	private String username;
	private String name;	
	private String password;
	
	
	public User(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public String toString(){
		return "Name = "+name+" Login = "+username+" Password = "+password;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
