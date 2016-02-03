package service.QueryServiceImpl;

import dao.personDao.PersonDao;
import models.master_data.Person;
import service.QuerryService.PersonQueryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public class PersonQueryServiceImpl implements PersonQueryService{

    PersonDao personDao = new PersonDao();

    @Override
    public Person findByName(String name) {
        if (name == null){
            return null;
        }

        return personDao.findyByName(name);
    }

    @Override
    public List<Person> findAll() {
        List<Person> listPerson = personDao.getAll();

        return listPerson;
    }

    @Override
    public List<Person> findBynameAgeAddressLike(String name, Integer age, String address) {
        return personDao.findyByNames(name,age,address);
    }

}
