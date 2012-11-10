package spring.context;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.lotto")
@PropertySource(value={"classpath:spring/context/app.properties","classpath:spring/context/db.properties"})
@EnableTransactionManagement
public class AppContext {
	
	@Value(value="${jdbc.driverClass}")	String driverClass;
	@Value(value="${jdbc.url}")				String url;
	@Value(value="${jdbc.username}")		String username;
	@Value(value="${jdbc.password}")		String password;
	
	/**
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="${jdbc.driverClass}" />
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
		<property name="maxActive" value="${jdbc.maxActive}" />
		<property name="maxIdle" value="${jdbc.maxIdle}" />
		<property name="maxWait" value="${jdbc.maxWait}" />
		<property name="validationQuery" value="${jdbc.validationQuery}" />
		<property name="testWhileIdle" value="${jdbc.testWhileIdle}" />
		<property name="timeBetweenEvictionRunsMillis" value="${jdbc.timeBetweenEvictionRunsMillis}" />
	</bean>
	 */
	public DataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName(this.driverClass);
		ds.setUrl(this.url);
		ds.setUsername(this.username);
		ds.setPassword(this.password);
		
		return ds;
	}
	
	/**
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="typeAliasesPackage" value="com.lotto.dto" />
	</bean>

	 */
	
	@Bean
	public FactoryBean<?> sqlSessionFactory(){
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		
		sfb.setDataSource(dataSource());
		sfb.setTypeAliasesPackage("com.lotto.dto");
		
		return sfb;
	}
	
	/**
	<!-- scan for mappers and let them be autowired -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.lotto.dao" />
	</bean>
	 */
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		
		msc.setBasePackage("com.lotto.dao");
		
		return msc;
	}
}
