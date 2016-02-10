package com.jti.tionlie.support.converterEntity;

import com.jti.tionlie.master_data.models.City;
import com.jti.tionlie.master_data.wrapper.CityWrap;


/**
 * Created by User on 2/9/2016.
 */
public class ConvertCity {

    public static City convertToEntity(CityWrap cityWrap) {
        City city = null;
        if (cityWrap instanceof CityWrap) {
            city = new City();
            city.setId(cityWrap.getId());
            city.setName(cityWrap.getName());
            city.setPostalCode(cityWrap.getPostalCode());
        }
        return city;
    }

    public static CityWrap convertToWrapper(City city){
        CityWrap cityWrap=null;
        if(city instanceof City){
            cityWrap=new CityWrap(city.getId(),city.getName(),city.getPostalCode());
        }
        return cityWrap;
    }


}
