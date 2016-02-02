package controllers;

import models.master_data.wrapper.PersonWrap;
import play.*;
import play.libs.Json;
import play.mvc.*;

import support.Notification;
import support.wrapper.ResponseWrapper;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result person(){
        ResponseWrapper<PersonWrap> responseWrapper=new ResponseWrapper<>();
        PersonWrap personWrap=new PersonWrap();
        personWrap.setNama("Hasani");
        personWrap.setLokasi("Bogor");
        personWrap.setUmur(23);
        Notification notification=new Notification("succes","200");
        responseWrapper.setData(personWrap);
        return ok(Json.toJson(responseWrapper));
    }

}
