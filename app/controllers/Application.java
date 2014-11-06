package controllers;

import java.util.List;

import models.User;
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
        return ok(index.render(username, "no"));
    }
    
    public static Result logout() {
    	username = "";
    	return redirect(routes.Application.index());
    }

}
