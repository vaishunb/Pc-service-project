package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model{
	
	
	@Id
	public String email;
	public String name;	
	public String password;
	
	//Adress
	public String zip;
	public String city;
	public String street;
	public String appartment;
	
	
	public User(String name, String email, String password, String zip, String city, String street, String appartment){
		this.name = name;
		this.email = email;
		this.password = password;
		
		this.zip = zip;
		this.city = city;
		this.street = street;
		this.appartment = appartment;
		this.save();
	}
	
	public static Finder<String,User> find = new Finder<String,User>(
	        String.class, User.class
	    ); 
	
	
	public String toString(){
		return "Name = "+name+" Login = "+email+" Password = "+password;
	}

}
