package com.jti.tionlie.master_data.service.CommandServiceImpl;

import com.jti.tionlie.master_data.dao.CityDao;
import com.jti.tionlie.master_data.models.City;
import com.jti.tionlie.master_data.service.CommandService.CityCommandService;
import com.jti.tionlie.master_data.wrapper.CityWrap;
import com.jti.tionlie.support.converterEntity.ConvertCity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by User on 2/9/2016.
 */
@Service("cityCommandService")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class CityCommandServiceImpl implements CityCommandService{
    private final CityDao cityDao;

    @Inject
    public CityCommandServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public City sumbit(CityWrap cityWrap) {
        return cityDao.save(ConvertCity.convertToEntity(cityWrap));
    }
}
