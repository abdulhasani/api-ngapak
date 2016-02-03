package service.CommandService;

import models.master_data.Person;
import models.master_data.wrapper.PersonWrap;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public interface PersonCommandService {

    public Person submit(PersonWrap wrap);

}
