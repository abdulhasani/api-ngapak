package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.master_data.wrapper.PersonWrap;

import play.libs.Json;
import play.mvc.*;

import support.Notification;
import support.transfer.ArrayTransfer;
import support.wrapper.ResponseWrapper;
import views.html.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

    private static final Map<String,PersonWrap> tablePerson=new HashMap<>();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result person(){
        ResponseWrapper<ArrayTransfer<PersonWrap>> responseWrapper=new ResponseWrapper<>();
        ArrayTransfer<PersonWrap> personWrapArr = new ArrayTransfer<PersonWrap>(PersonWrap.class);
        for (Map.Entry<String,PersonWrap> personWrap:tablePerson.entrySet()){
            personWrapArr.addItem(personWrap.getValue());
        }
        List<Notification> notifications = new ArrayList<>();
        Notification notification=new Notification("succes","200");
        notifications.add(notification);
        responseWrapper.setData(personWrapArr);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    public static Result findById(String id){

        return null;
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPerson(){
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        String uuid = java.util.UUID.randomUUID().toString();
        personWrap.setId(uuid);
        tablePerson.put(uuid,personWrap);
        return ok("Tersimpan");
    }



    public static Result personName(){
        return ok();
    }

}
