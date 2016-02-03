package com.jti.tionlie.master_data.service.CommandService;

import com.jti.tionlie.master_data.models.Person;
import com.jti.tionlie.master_data.wrapper.PersonWrap;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public interface PersonCommandService {

    public Person submit(PersonWrap wrap);
    public Person update(PersonWrap wrap);
    public void delete(PersonWrap wrap);
    public void delettById(String id);

}
