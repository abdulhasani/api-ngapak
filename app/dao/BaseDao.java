package dao;



import play.db.jpa.JPA;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

/**
 * Created by User TEGAR on 2/3/2016.
 */

public class BaseDao<T> {
    protected Class domainClass;

    public BaseDao() {
        this.domainClass = (Class)
                ((ParameterizedType)
                        getClass().
                                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T save(T domain) {
        JPA.em().persist(domain);
        return domain;
    }

    public T update(T domain) {
        JPA.em().merge(domain);
        return domain;
    }

    public void delete(T domain) {
        JPA.em().remove(domain);
    }

    public T getById(UUID id) {
        return (T) JPA.em().createQuery("SELECT xx FROM "+domainClass.getName()+" xx WHERE xx.id=:id").setParameter("id",id).getSingleResult();
    }

    public Long count() {
        List list = JPA.em().
                createQuery("SELECT count(*) FROM " + domainClass.getName() + " x").getResultList();
        Long count= (Long) list.get(0);
        return count;
    }

    public List<T> getAll() {
        return JPA.em().createQuery("FROM " + domainClass.getName()).getResultList();
    }

    public List<T> getAll(int start,int num){
        return JPA.em().createQuery("FROM " + domainClass.getName()).setFirstResult(start)
                .setMaxResults(num)
                .getResultList();
    }
}
