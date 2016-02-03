package com.jti.tionlie.support.converterEntity;

import com.jti.tionlie.master_data.models.Person;
import com.jti.tionlie.master_data.wrapper.PersonWrap;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public class ConvertPerson {

    public static Person convertPerson(PersonWrap personWrap) {
        Person person = null;
        if (personWrap instanceof PersonWrap) {
            person = new Person();
            person.setId(personWrap.getId());
            person.setNama(personWrap.getNama());
            person.setUmur(personWrap.getUmur());
            person.setAlamat(personWrap.getAlamat());
        }

        return person;
    }

    public static PersonWrap convertPerson2(Person person) {
        PersonWrap warp = null;
        if (person instanceof Person) {
            warp = new PersonWrap();
            warp.setId(person.getId());
            warp.setNama(person.getNama());
            warp.setUmur(person.getUmur());
            warp.setAlamat(person.getAlamat());
        }
        return warp;
    }
}