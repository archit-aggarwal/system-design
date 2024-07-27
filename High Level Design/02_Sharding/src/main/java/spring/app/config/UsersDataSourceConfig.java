package spring.app.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import spring.app.repository.users.UserRepository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = { UserRepository.class },
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
public class UsersDataSourceConfig {

    @Primary
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSource usersDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("usersDataSource") DataSource usersDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(usersDataSource);
        em.setPackagesToScan("spring.app.model.users");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(hibernateProperties());

        return em;
    }

    @Primary
    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory usersEntityManagerFactory) {
        return new JpaTransactionManager(usersEntityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }
}