package service.CommandServiceImpl;


import converterEntity.ConvertPerson;
import dao.personDao.PersonDao;
import models.master_data.Person;
import models.master_data.wrapper.PersonWrap;
import service.CommandService.PersonCommandService;

import java.util.List;
import java.util.UUID;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public class PersonConnmandServiceImpl implements PersonCommandService {

   private final PersonDao personDao = new PersonDao();

    @Override
    public Person submit(PersonWrap wrap) {
        Person save = (Person) personDao.save(ConvertPerson.convertPerson(wrap));
        return save;
    }

    @Override
    public Person submitUpdate(PersonWrap wrap) {


        return null;
    }


}
