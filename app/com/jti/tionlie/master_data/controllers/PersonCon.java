package com.jti.tionlie.master_data.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.jti.tionlie.master_data.models.Person;


import com.jti.tionlie.master_data.service.CommandService.CityCommandService;
import com.jti.tionlie.master_data.wrapper.CityWrap;
import com.jti.tionlie.support.Notification;
import com.jti.tionlie.support.transfer.ArrayTransfer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import play.libs.Json;
import play.mvc.*;

import com.jti.tionlie.master_data.service.CommandService.PersonCommandService;
import com.jti.tionlie.master_data.service.QuerryService.PersonQueryService;

import com.jti.tionlie.support.converterEntity.ConvertPerson;
import com.jti.tionlie.support.wrapper.ResponseWrapper;
import com.jti.tionlie.master_data.wrapper.PersonWrap;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;


@Named
@Singleton
public class PersonCon extends Controller {


    private static PersonCommandService personCommandServiceImpl;
    private static PersonQueryService personQueryServiceImpl;
    private static CityCommandService cityCommandService;


    @Inject
    public PersonCon(PersonCommandService personConnmandServiceImpl,
                     PersonQueryService personQueryServiceImpl,
                     CityCommandService cityCommandService) {
        this.personCommandServiceImpl = personConnmandServiceImpl;
        this.personQueryServiceImpl = personQueryServiceImpl;
        this.cityCommandService=cityCommandService;
    }

    public static Result index() {
        return ok(com.jti.tionlie.master_data.views.html.index.render("Your new application is ready."));
    }

    @Transactional(readOnly = true)
    public static Result findAll() {
        ResponseWrapper<ArrayTransfer<PersonWrap>> responseWrapper = new ResponseWrapper<>();
        ArrayTransfer<PersonWrap> personWrapArr = new ArrayTransfer<PersonWrap>(PersonWrap.class);
        List<Person> persons = personQueryServiceImpl.findAll();
        for (Person person : persons) {
            PersonWrap personWrap = ConvertPerson.convertPerson2(person);
            personWrapArr.addItem(personWrap);
        }
        List<Notification> notifications = new ArrayList<>();
        Notification notification = new Notification("succes", "200");
        notifications.add(notification);
        responseWrapper.setData(personWrapArr);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @Transactional(readOnly = true)
    public static Result findyByNama(String nama) {
        ResponseWrapper<PersonWrap> responseWrapper = new ResponseWrapper<>();
        PersonWrap personWrap = ConvertPerson.convertPerson2(personQueryServiceImpl.findByNama(nama));
        List<Notification> notifications = new ArrayList<>();
        Notification notification = new Notification("succes", "200");
        notifications.add(notification);
        responseWrapper.setData(personWrap);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @Transactional
    public static Result filter(String nama, String umur, String alamat) {
        List<Person> bynameAgeAddressLike = personQueryServiceImpl.findBynameAgeAddressLike("%" + nama + "%", "%" + umur + "%", "%" + alamat + "%");
        ResponseWrapper<ArrayTransfer<PersonWrap>> responseWrapper = new ResponseWrapper<>();
        ArrayTransfer<PersonWrap> personWrapArr = new ArrayTransfer<PersonWrap>(PersonWrap.class);
        for (Person person : bynameAgeAddressLike) {
            PersonWrap personWrap = ConvertPerson.convertPerson2(person);
            personWrapArr.addItem(personWrap);
        }
        List<Notification> notifications = new ArrayList<>();
        Notification notification = new Notification("succes", "200");
        notifications.add(notification);
        responseWrapper.setData(personWrapArr);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @Transactional(readOnly = true)
    public static Result findById(String id) {
        ResponseWrapper<PersonWrap> responseWrapper = new ResponseWrapper<>();
        //responseWrapper.setData(personWrap);
        List<Notification> notifications = new ArrayList<>();
        Notification notification = new Notification("succes", "200");
        notifications.add(notification);
        responseWrapper.setNotifications(notifications);
        return ok(Json.toJson(responseWrapper));
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional(propagation = Propagation.SUPPORTS,
            rollbackFor = {Exception.class,RuntimeException.class}
    )
    public static Result addPerson() {
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        String uuid = java.util.UUID.randomUUID().toString();
        personWrap.setId(uuid);
        personCommandServiceImpl.submit(personWrap);
        CityWrap cityWrap = new CityWrap();
        String uidCity = java.util.UUID.randomUUID().toString();
        cityWrap.setId(uidCity);
        cityWrap.setName("Jakarta");
        cityWrap.setPostalCode("jawaTengah");
        cityCommandService.sumbit(null);
        return ok("create succes");
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public static Result editPerson(String id) {
        JsonNode jsonNode = request().body().asJson();
        PersonWrap personWrap = Json.fromJson(jsonNode, PersonWrap.class);
        personWrap.setId(id);
        Person update = personCommandServiceImpl.update(personWrap);
        return ok("update succes");
    }

    @Transactional
    public static Result deletePerson(String id) {
        personCommandServiceImpl.delettById(id);
        return ok("delete succes");
    }


}
