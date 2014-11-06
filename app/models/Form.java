package models;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class Form extends Model{
	
	@Id
	public String id;
	
	@ManyToOne
    public User client;
	
	public LocalTime time;
	public DeviceType type;
	public String model;
	public String description;
	public boolean warranty;
	public Priority priority;
	
	public enum DeviceType {Laptop, Smartphone, Desktop, Other};
	public enum Priority {Low, Middle, High};
	
	public Form (String clientEmail, LocalTime time, DeviceType type, String model, 
			String description, boolean warranty, Priority priority){
		this.time = time;
		this.type = type;
		this.model = model;
		this.description = description;
		this.warranty = warranty;
		this.priority = priority;
	}
	
	public static Finder<String,Form> find = new Finder<String, Form>(String.class, Form.class);
	
	public static List<Form> findFormsRequested(String userEmail){
		return find.fetch("form").where().eq("client.email", userEmail).findList();
	}
	
	public static Form create(String clientEmail, LocalTime time, DeviceType type, String model, 
			String description, boolean warranty, Priority priority){
		
		Form form = new Form(clientEmail, time, type, model, description, warranty, priority);
		form.client = User.find.ref(clientEmail);
		form.save();
		return form;
		
	}
	

}
