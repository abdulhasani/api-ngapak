package com.jti.tionlie.master_data.controllers;

import com.fasterxml.jackson.databind.JsonNode;

import com.jti.tionlie.master_data.dao.CityDao;
import com.jti.tionlie.master_data.service.CommandService.CityCommandService;
import com.jti.tionlie.master_data.wrapper.CityWrap;
import com.jti.tionlie.support.converterEntity.ConvertCity;
import org.springframework.transaction.annotation.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;


import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by User on 2/9/2016.
 */
@Named
@Singleton
public class CityCon extends Controller {

    private final CityCommandService cityCommandService;

    // We are using constructor injection to receive a repository to support our desire for immutability.
    @Inject
    public CityCon(CityCommandService cityCommandService) {
        this.cityCommandService = cityCommandService;
    }

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public  Result addCity(){
        JsonNode jsonNode = request().body().asJson();
        CityWrap cityWrap = Json.fromJson(jsonNode, CityWrap.class);
        String uuid = java.util.UUID.randomUUID().toString();
        cityWrap.setId(uuid);
        cityCommandService.sumbit(cityWrap);
        return ok(Json.toJson(cityWrap));
    }
}
