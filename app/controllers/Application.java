package controllers;

import models.master_data.wrapper.PersonWrap;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result person(){
        PersonWrap personWrap=new PersonWrap();
        personWrap.setNama("Hasani");
        personWrap.setLokasi("Bogor");
        personWrap.setUmur(23);
        
        return ok(Json.toJson(personWrap));
    }

}
