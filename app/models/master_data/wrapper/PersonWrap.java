package models.master_data.wrapper;

/**
 * Created by User on 2/2/2016.
 */
public class PersonWrap {
    private String id;
    private String nama;
    private Integer umur;
    private String alamat;

    public PersonWrap() {
    }

    public PersonWrap(String id, String nama, Integer umur, String alamat) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getLokasi() {
        return alamat;
    }

    public void setLokasi(String alamat) {
        this.alamat = alamat;
    }
}
