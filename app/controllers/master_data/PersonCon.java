package controllers.master_data;

import com.fasterxml.jackson.databind.JsonNode;
import models.master_data.Person;
import models.master_data.wrapper.PersonWrap;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import service.CommandService.PersonCommandService;
import service.CommandServiceImpl.PersonConnmandServiceImpl;
import service.QuerryService.PersonQueryService;
import service.QueryServiceImpl.PersonQueryServiceImpl;
import support.Notification;
import support.converterEntity.ConvertPerson;
import support.transfer.ArrayTransfer;
import support.wrapper.ResponseWrapper;
import views.html.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonCon extends Controller {

    private static final PersonCommandService personCommandService=new PersonConnmandServiceImpl();
    private static final PersonQueryService personQueryService=new PersonQueryServiceImpl();


    private static final Map<String,PersonWrap> tablePerson=new HashMap<>();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @Transactional(readOnly = true)
    public static Result person(){
        ResponseWrapper<ArrayTransfer<PersonWrap>> responseWrapper=new ResponseWrapper<>();
        ArrayTransfer<PersonWrap> personWrapArr = new ArrayTransfer<PersonWrap>(PersonWrap.class);
        List<Person> persons = personQueryService.findAll();
        for (Person person:persons){
            PersonWrap personWrap = ConvertPerson.convertPerson2(person);
            personWrapArr.addItem(personWrap);
        }
        List<Notification> notifications = new ArrayList<>();
        Notification notification=new Notification("succes","200");
        notifications.add(notification);
        responseWrapper.setData(personWrapArr);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @Transactional(readOnly = true)
    public static Result findyByNama(String nama){
        ResponseWrapper<PersonWrap> responseWrapper=new ResponseWrapper<>();
        PersonWrap personWrap = ConvertPerson.convertPerson2(personQueryService.findByName(nama));
        List<Notification> notifications = new ArrayList<>();
        Notification notification=new Notification("succes","200");
        notifications.add(notification);
        responseWrapper.setData(personWrap);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @Transactional(readOnly = true)
    public static Result filter(String nama,String umur,String alamat){
        List<Person> bynameAgeAddressLike = personQueryService.findBynameAgeAddressLike(nama,umur, alamat);
        ResponseWrapper<ArrayTransfer<PersonWrap>> responseWrapper=new ResponseWrapper<>();
        ArrayTransfer<PersonWrap> personWrapArr = new ArrayTransfer<PersonWrap>(PersonWrap.class);
        for (Person person:bynameAgeAddressLike){
            PersonWrap personWrap = ConvertPerson.convertPerson2(person);
            personWrapArr.addItem(personWrap);
        }
        List<Notification> notifications = new ArrayList<>();
        Notification notification=new Notification("succes","200");
        notifications.add(notification);
        responseWrapper.setData(personWrapArr);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @Transactional(readOnly = true)
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

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public static Result addPerson(){
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        String uuid = java.util.UUID.randomUUID().toString();
        personWrap.setId(uuid);
        tablePerson.put(uuid, personWrap);
        return ok("create succes");
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public static Result editPerson(String id){
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        tablePerson.put(id, personWrap);
        return ok("update succes");
    }

    @Transactional
    public static Result deletePerson(String id){
        tablePerson.remove(id);
        return ok("delete succes");
    }




}
