package com.jti.tionlie.master_data.dao;

import com.jti.tionlie.master_data.models.Person;
import com.jti.tionlie.support.BaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import play.db.jpa.JPA;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by User TEGAR on 2/3/2016.
 */
@Named
@Singleton
public interface PersonDao extends CrudRepository<Person, UUID> {

    public List<Person> findAll();

    public Person findByNama(String nama);

    public Person findById(UUID id);

    @Override
    public void delete(UUID uuid);

    public List<Person> findByNamaLikeAndAlamatLike(String nama, String alamat);

    @Query(value = "SELECT * FROM mtd_person AS p WHERE p.nama LIKE :nama AND CAST(p.umur as varchar) LIKE :umur AND p.alamat LIKE :alamat ",nativeQuery = true)
    public List<Person> filter(@Param("nama")String nama,@Param("umur")String umur,@Param("alamat")String alamat);

    /**
     @Transactional(readOnly = true)
     public Person findyByName(String name) {
     Person singleResult = (Person) JPA.em().createQuery("SELECT p FROM Person p WHERE p.nama=?")
     .setParameter(1, name).getSingleResult();
     return singleResult;
     }

     @Transactional(readOnly = true)
     public Person findById(String id){
     Person singleResult = (Person) JPA.em().createQuery("SELECT p FROM Person p WHERE p.id=?")
     .setParameter(1, id).getSingleResult();
     return singleResult;
     }

     @Transactional public void deleteById(String id){
     JPA.em().createQuery("DELETE FROM Person p WHERE p.id=?").setParameter(1,id).executeUpdate();
     }

     @Transactional(readOnly = true)
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
     */

}
