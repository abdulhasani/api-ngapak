package com.jti.tionlie.master_data.service.QuerryService;

import com.jti.tionlie.master_data.models.Person;

import java.util.List;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public interface PersonQueryService {

    Person findByName(String name);
    List<Person> findAll();
    List<Person> findBynameAgeAddressLike(String name, String age, String address);

}
