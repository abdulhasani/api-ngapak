package com.jti.tionlie.master_data.service.QueryServiceImpl;

import com.jti.tionlie.master_data.dao.PersonDao;
import com.jti.tionlie.master_data.models.Person;
import com.jti.tionlie.master_data.service.QuerryService.PersonQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by User TEGAR on 2/3/2016.
 */
@Service("personQueryServiceImpl")
@Transactional(readOnly = true)
public class PersonQueryServiceImpl implements PersonQueryService{

    private PersonDao personDao;

    @Inject
    public PersonQueryServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person findByNama(String name) {
        if (name == null){
            return null;
        }

        return personDao.findByNama(name);
    }

    @Override
    public List<Person> findAll() {
        List<Person> listPerson = personDao.findAll();

        return listPerson;
    }

    @Override
    public List<Person> findBynameAgeAddressLike(String name, String age, String address) {
        return personDao.filter(name,age,address);
    }

}
