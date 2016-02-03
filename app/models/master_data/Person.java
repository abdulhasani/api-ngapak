package models.master_data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by User on 2/2/2016.
 */
@Entity
@Table(name = "mtd_person")
public class Person {

    @Id
    @Column(name = "id_person", nullable = false)
    private String id;
    @Column(name = "nama", nullable = false, length = 255)
    private String nama;
    @Column(name = "umur", nullable = false, length = 3)
    private Integer umur;
    @Column(name = "alamat", nullable = false, length = 255)
    private String alamat;

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
