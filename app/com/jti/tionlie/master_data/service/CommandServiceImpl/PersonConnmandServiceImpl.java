package com.jti.tionlie.master_data.service.CommandServiceImpl;


import com.jti.tionlie.master_data.dao.PersonDao;
import com.jti.tionlie.master_data.models.Person;
import com.jti.tionlie.master_data.wrapper.PersonWrap;
import com.jti.tionlie.master_data.service.CommandService.PersonCommandService;
import com.jti.tionlie.support.converterEntity.ConvertPerson;

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
    public Person update(PersonWrap wrap) {

        PersonWrap oldWrap = ConvertPerson.convertPerson2(personDao.findById(wrap.getId()));
        Person update = null;

        if (!oldWrap.getNama().equalsIgnoreCase(wrap.getNama()) ||
                oldWrap.getUmur() != wrap.getUmur() ||
                !oldWrap.getAlamat().equalsIgnoreCase(wrap.getAlamat())) {

            update = (Person) personDao.update(ConvertPerson.convertPerson(wrap));
        }

        return update;
    }

    @Override
    public void delete(PersonWrap wrap) {
        if (wrap.getId() != null) {
            Person person = personDao.findById(wrap.getId());
            personDao.delete(person);
        }
    }

    @Override
    public void delettById(String id) {
        if(id!=null){
            if(!id.trim().isEmpty()){
                personDao.deleteById(id);
            }
        }
    }

}
