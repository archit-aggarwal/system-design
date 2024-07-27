package spring.app.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import spring.app.repository.products.ProductRepository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = { ProductRepository.class },
        entityManagerFactoryRef = "productsEntityManagerFactory",
        transactionManagerRef = "productsTransactionManager"
)
public class ProductsDataSourceConfig {

    @Bean(name = "productsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.products")
    public DataSource productsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "productsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean productsEntityManagerFactory(
            @Qualifier("productsDataSource") DataSource productsDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(productsDataSource);
        em.setPackagesToScan("spring.app.model.products");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(hibernateProperties());

        return em;
    }

    @Bean(name = "productsTransactionManager")
    public JpaTransactionManager productsTransactionManager(
            @Qualifier("productsEntityManagerFactory") EntityManagerFactory productsEntityManagerFactory) {
        return new JpaTransactionManager(productsEntityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }
}
