package com.young.eman.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DataSouceConfiguration extends BasicDataSource{
	
	@Configuration
	@MapperScan(basePackages = "com.young.eman.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
	@EnableTransactionManagement 
	public static class UnionDataSoucesConfiguration{
		
		@Autowired
	    private  UnionDateSourceProperties unionDateSourceProperties;
		
		@Bean(name="mysql-dataSource",destroyMethod="close")
	    public DataSource dataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl(unionDateSourceProperties.getUrl());
	        dataSource.setUsername(unionDateSourceProperties.getUsername());
	        dataSource.setPassword(unionDateSourceProperties.getPassword());
	        dataSource.setMinIdle(1);
	        dataSource.setMaxIdle(20);
	        dataSource.setInitialSize(10);
	        dataSource.setMaxActive(100);
	        dataSource.setMaxWait(45000);
	        dataSource.setValidationQuery("SELECT 1 FROM DUAL");
	        dataSource.setTestOnBorrow(true);
	        return dataSource;
	    }
		@Bean(name = "jdbcTemplate")
		public JdbcTemplate jdbcTemplate(@Qualifier("mysql-dataSource") DataSource dataSource) throws Exception {
			JdbcTemplate template = new JdbcTemplate();
			template.setDataSource(dataSource);
			return template;
		}
		@Bean(name = "sqlSessionFactory")
		public SqlSessionFactory unionSqlSessionFactory(@Qualifier("mysql-dataSource") DataSource dataSource) throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*.xml"));
			return bean.getObject();
		}
		@Bean(name = "transactionManager")
		@Transactional
		public DataSourceTransactionManager transactionManager(@Qualifier("mysql-dataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}
		
		
		@ConfigurationProperties(prefix = "spring.datasource.pvdvmc")
		@Component
		public static class  UnionDateSourceProperties{
			private String url;
			private String username;
			private String password;
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
		}

	}
}
