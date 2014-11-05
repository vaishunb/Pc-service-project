package controllers;

import java.util.List;

import models.User;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static String username = "";

    public static Result index() {
        return ok(index.render(username, ""));
    }
    
    public static Result login() {
        System.out.println("Login = " + Form.form().bindFromRequest().get("login"));
        System.out.println("Password = " + Form.form().bindFromRequest().get("key"));
        
        
        List<User> userList = new Model.Finder(String.class, User.class).all();
        for (User user : userList){
        	if (user.getUsername().equals(Form.form().bindFromRequest().get("login"))
        			&& user.getPassword().equals(Form.form().bindFromRequest().get("key"))){
        		System.out.println("You are logged in!");
        		username = user.getName();
        		return ok(index.render(username, "yes"));
        	}
        }
        return ok(index.render(username, "no"));
    }
    
    public static Result logout() {
    	username = "";
    	return redirect(routes.Application.index());
    }

}
