package controllers.master_data;

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

public class PersonCon extends Controller {

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
        ResponseWrapper<PersonWrap> responseWrapper=new ResponseWrapper<>();
        PersonWrap personWrap = tablePerson.get(id);
        responseWrapper.setData(personWrap);
        List<Notification> notifications = new ArrayList<>();
        Notification notification=new Notification("succes","200");
        notifications.add(notification);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPerson(){
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        String uuid = java.util.UUID.randomUUID().toString();
        personWrap.setId(uuid);
        tablePerson.put(uuid, personWrap);
        return ok("create succes");
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result editPerson(String id){
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        tablePerson.put(id,personWrap);
        return ok("update succes");
    }

    public static Result deletePerson(String id){
        tablePerson.remove(id);
        return ok("delete succes");
    }


    public static Result personName(){
        return ok();
    }

}
