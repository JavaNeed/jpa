jpa-criteria-api
-----------------

application-context.xml
------------------------

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa"
	xsi:schemaLocation="http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/data/jpa http://www.springframework.org/schema/data/jpa/spring-jpa.xsd">
		
	<!-- Jpa Repositories -->
	<jpa:repositories base-package="com.cloudfoundry.tothought.repositories" />

	<!-- MySQL Database -->
	<bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/to_thought_tutorial" />
		<property name="username" value="root" />
		<property name="password" value="root" />
	</bean>

	<!-- Entity Manager -->
	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="datasource" />
		<property name="persistenceUnitName" value="jpa-criteria-api" />
	</bean>

	<!-- Transaction Manager -->
	<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="entityManagerFactory" />
	</bean>
</beans>
```

persistence.xml
---------------

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="1.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence 
	http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">
	
	<!-- For MYSQL -->
	<persistence-unit name="jpa-criteria-api" transaction-type="RESOURCE_LOCAL">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<properties>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />
			<property name="hibernate.hbm2ddl.auto" value="create" />
			<property name="hibernate.show_sql" value="true"/>
		</properties>
	</persistence-unit>
	
	
	<!-- For H2 DB -->
	<persistence-unit name="tothought-tutorial-test" transaction-type="RESOURCE_LOCAL">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<properties>
			<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
			<property name="hibernate.hbm2ddl.auto" value="create" />
			<property name="hibernate.show_sql" value="true"/>
		</properties>
	</persistence-unit>
</persistence>
```

test-context.xml
--------------
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa"
	xsi:schemaLocation="http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.1.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/data/jpa http://www.springframework.org/schema/data/jpa/spring-jpa-1.2.xsd">

	<!-- Database -->
	<jdbc:embedded-database id="datasource" type="H2"></jdbc:embedded-database>

	<!-- Entity Manager -->
	<bean id="entityManagerFactory"
		class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="datasource" />
		<property name="persistenceUnitName" value="tothought-tutorial-test" />
	</bean>

	<!-- Transaction Manager -->
	<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="entityManagerFactory" />
	</bean>
	
	<!-- Jpa Repositories -->
	<jpa:repositories base-package="com.cloudfoundry.tothought.repositories"></jpa:repositories>
</beans>
```

