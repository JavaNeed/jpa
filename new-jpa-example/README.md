new-jpa-example
--------------
Database configurations being made in the persistance.xml file, Ideally it should be in a spring-context.xml

- This project doesn't uses spring
- It uses simple datasource connection through persistance.xml file

Note: Very generic code. 


```
<?xml version="1.0" encoding="UTF-8"?>

<persistence version="1.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence 
   http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">

	<persistence-unit name="new-jpa-example"
		transaction-type="RESOURCE_LOCAL">
		<class>com.sdnext.hibernate.model.Country</class>
		<class>com.sdnext.hibernate.model.Department</class>
		<class>com.sdnext.hibernate.model.Employee</class>
		<class>com.sdnext.hibernate.model.JobHistory</class>
		<class>com.sdnext.hibernate.model.JobHistoryPK</class>
		<class>com.sdnext.hibernate.model.Job</class>
		<class>com.sdnext.hibernate.model.Location</class>
		<class>com.sdnext.hibernate.model.Region</class>

		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/test3" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password" value="root" />
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
			
			<property name="hibernate.show_sql" value="true" />
			
			<property name="eclipselink.logging.level" value="FINE" />
			<property name="eclipselink.ddl-generation" value="create-tables" />
		</properties>

	</persistence-unit>
</persistence>

```