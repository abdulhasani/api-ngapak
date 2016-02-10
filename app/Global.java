import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import play.Application;
import play.GlobalSettings;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 2/5/2016.
 */
public class Global extends GlobalSettings {
    /**
     *
     */
    static final String DEFAULT_PRESISTENCE_UNIT="defaultPersistenceUnit";

    /**
     *
     */
    private AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();

    /**
     *
     */
    @Override
    public void onStart(Application application) {
        super.onStart(application);
        // AnnotationConfigApplicationContext can only be refreshed once, but we do it here even though this method
        // can be called multiple times. The reason for doing during startup is so that the Play configuration is
        // entirely available to this application context.
        ctx.register(SpringDataJpaConfiguration.class);
        ctx.scan(
                "com.jti.tionlie.master_data.controllers",
                "com.jti.tionlie.master_data.dao",
                "com.jti.tionlie.master_data.service");
        ctx.refresh();

        ctx.start();
    }

    @Override
    public void onStop(Application application) {
        // This will call any destruction lifecycle methods and then release the beans e.g. @PreDestroy
        ctx.close();
        super.onStop(application);

    }

    @Override
    public <A> A getControllerInstance(Class<A> aClass) throws Exception {
        return ctx.getBean(aClass);
    }

    @Configuration
    @EnableJpaRepositories(basePackages = {
            "com.jti.tionlie.master_data.dao"})
    public static class SpringDataJpaConfiguration{

        @Bean
        public EntityManagerFactory entityManagerFactory(){
            return Persistence.createEntityManagerFactory(DEFAULT_PRESISTENCE_UNIT);
        }

        @Bean
        public HibernateExceptionTranslator hibernateExceptionTranslator(){
            return new HibernateExceptionTranslator();
        }

        @Bean
        public JpaTransactionManager transactionManager(){
            return new JpaTransactionManager();
        }
    }
}
