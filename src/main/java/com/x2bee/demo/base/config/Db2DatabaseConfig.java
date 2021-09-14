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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 9. 8.
 *
 */
@Configuration
@MapperScan(value="com.x2bee.demo.app.repository.x2bee", sqlSessionFactoryRef="db2SqlSessionFactory")
public class Db2DatabaseConfig {
    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource db2DataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(db2DataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.x2bee.demo.app.dto");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/x2bee/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate db2SqlSessionTemplate(SqlSessionFactory db2SqlSessionFactory) throws Exception { 
        return new SqlSessionTemplate(db2SqlSessionFactory);
    }

    @Bean(name="db2TxManager")
    public PlatformTransactionManager db2TxManager(@Autowired @Qualifier("db2DataSource") DataSource db2DataSource) {
        return new DataSourceTransactionManager(db2DataSource);
    }
}
