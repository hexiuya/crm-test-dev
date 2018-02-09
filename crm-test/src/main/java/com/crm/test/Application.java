package com.crm.test;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
//@MapperScan("com.cmbfae.task.mapper")  //后期加上
@ImportResource("/spring/applicationContext.xml")
public class Application {
	private static Logger logger = Logger.getLogger(Application.class);



//	@Bean
//	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//
//
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
//
//		return sqlSessionFactoryBean.getObject();
//	}

//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//		// return new
//		// DataSourceTransactionManager(dataSourceConfig.dataSource());
//	}

	/**
	 * Start
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("SpringBoot Start Success");
	}

//	@Value("${spring.datasource.url}")
//	private String url;
//
//	@Value("${spring.datasource.username}")
//	private String username;
//
//	@Value("${spring.datasource.password}")
//	private String password;
//
//	@Value("${spring.datasource.driver-class-name}")
//	private String className;

	/**
	 * druid初始化
	 * 
	 * @return
	 * @throws SQLException
	 */
//	@Primary // 默认数据源
//	@Bean(name = "dataSource", destroyMethod = "close")
//	public DruidDataSource dataSource() {
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		dataSource.setDriverClassName(className);
//		try {
//			dataSource.init();
//		} catch (SQLException e) {
//			throw new RuntimeException("druid datasource init fail");
//		}
//		return dataSource;
//	}
}

@Configuration
@ImportResource("/spring/applicationContext.xml")
class XmlImportingConfiguration {
}