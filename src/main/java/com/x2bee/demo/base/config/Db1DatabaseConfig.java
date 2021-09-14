/**
 * 
 */
package com.x2bee.demo.base.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
@Configuration
@MapperScan(value="com.x2bee.demo.app.repository.x2commerce", sqlSessionFactoryRef="db1SqlSessionFactory")
public class Db1DatabaseConfig {
    @Bean(name = "db1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    public DataSource db1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource db1DataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(db1DataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.x2bee.demo.app.dto");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/x2commerce/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory db1SqlSessionFactory) throws Exception { 
        return new SqlSessionTemplate(db1SqlSessionFactory);
    }

    @Bean(name="db1TxManager")
    @Primary
    public PlatformTransactionManager db1TxManager(@Autowired @Qualifier("db1DataSource") DataSource db1DataSource) {
        return new DataSourceTransactionManager(db1DataSource);
    }

}
