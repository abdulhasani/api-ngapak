package com.jti.tionlie.master_data.dao;

import com.jti.tionlie.master_data.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by User on 2/9/2016.
 */
@Repository
public interface CityDao extends CrudRepository<City,String>{

}
