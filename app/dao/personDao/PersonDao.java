package dao.personDao;

import dao.BaseDao;
import models.master_data.Person;
import play.db.jpa.JPA;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by User TEGAR on 2/3/2016.
 */
public class PersonDao extends BaseDao<Person> {

    public Person findyByName(String name) {
        Person singleResult = (Person) JPA.em().createQuery("SELECT p FROM Person p WHERE p.nama=?")
                .setParameter(1, name).getSingleResult();
        return singleResult;
    }

    public Person findById(String id){
        Person singleResult = (Person) JPA.em().createQuery("SELECT p FROM Person p WHERE p.id=?")
                .setParameter(1, id).getSingleResult();
        return singleResult;
    }

    public void deleteById(String id){
        JPA.em().createQuery("DELETE FROM Person p WHERE p.id=?").setParameter(1,id).executeUpdate();
    }

    public List<Person> findyByNames(String nama,String umur,String alamat) {
        final String filterKeyNama = "nama";
        final String filterKeyUmur = "umur";
        final String filterKeyAlamat = "alamat";


        CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> c = q.from(Person.class);

        Expression<String> filterKeyExpNama = c.get(filterKeyNama).as(String.class);
        Expression<String> filterKeyExpUmur = c.get(filterKeyUmur).as(String.class);
        Expression<String> filterKeyExpAlamat = c.get(filterKeyAlamat).as(String.class);

        Predicate predicatePoId = cb.like(filterKeyExpNama, "%" + nama + "%");
        Predicate predicatePrNo = cb.like(filterKeyExpUmur, "%" + umur + "%");
        Predicate predicateAlamat = cb.like(filterKeyExpAlamat, "%" + alamat + "%");

        q.where(cb.and(predicatePoId, predicatePrNo,predicateAlamat));
        TypedQuery<Person> query = JPA.em().createQuery(q);
        List<Person> resultList = query.getResultList();

        return resultList;
    }

}
