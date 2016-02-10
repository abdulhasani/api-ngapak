package com.jti.tionlie.master_data.service.QuerryService;

import com.jti.tionlie.master_data.models.Person;

import java.util.List;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public interface PersonQueryService {

    Person findByNama(String nama);
    List<Person> findAll();
    List<Person> findBynameAgeAddressLike(String nama, String age, String address);

}
