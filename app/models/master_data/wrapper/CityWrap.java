package models.master_data.wrapper;

/**
 * Created by HP on 02/02/2016.
 */
public class CityWrap {
    private String name;


    public CityWrap() {
    }

    public CityWrap(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
