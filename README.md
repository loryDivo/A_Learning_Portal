# A-Learning

A-leaerning is the portal for university students through which it is possible to register for the courses attended and use the published material. The portal is very simple:

- Register
- Log in to your account
- Sign up for the courses available

### Administration tools

The administrator user can:
- Create new courses by assigning the corresponding credits
- Banning users for up to a certain date, or banning them forever
- Remove a user's ban and then allow access

### Technology adopted

A-learning uses different technologies to work:
* [Eclipse](http://www.eclipse.org) v4.7.1a
* [Tomcat](https://tomcat.apache.org/download-80.cgi) v*.*
* [MySql](https://www.mysql.com/it/) v5.7.20
* [Hibernate](http://hibernate.org)

### Utilization
A-learning can be used by visiting the site of [A-learning](http://a-learning-a-learning.1d35.starter-us-east-1.openshiftapps.com/Assignment3).
The following test users are present:

##### Normal User:
username: user

password: 123123123A

##### Admin User:
username: admin

password: 123123123A


### Installation

A-learning requires the installation of [Eclipse](http://www.eclipse.org/downloads/eclipse-packages), [MySql](https://www.mysql.com/it/) e [Tomcat](https://tomcat.apache.org/download-80.cgi).

Import the project into Eclipse::

```sh
From the Eclipse program
-> Select "import"
-> Select "Existing Maven Project"
The pom.xml containing the dependencies will be identified automatically
Right click on the imported project
-> Select the "Properties" item
-> Select the "Project Facets" section
-> In the right section select "Runtimes"
-> Then select "Apache TomCat v *. *"
```

Set-up Tomcat:

```sh
From the Eclipse program
-> From the Eclipse menu at the bottom select the "Servers" section
-> Right click and select "New" and select "Server"
-> Select "Apache TomCat v *. *" And select directory of "Apache TomCat v *. *" Downloaded
```

Create a database named `assignment3'

Modify file /src/main/resources/META-INF/persistence.xml as follows, paying attention to the username and password fields:
```sh
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="1.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">
	<persistence-unit name="assignment3" transaction-type="RESOURCE_LOCAL">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<class>com.assignment3.models.User</class>
		<class>com.assignment3.models.Course</class>
		<properties>
			<property name="hibernate.connection.url" value="jdbc:mysql://127.0.0.1/assignment3" />
			<property name="hibernate.connection.driver_class" value="com.mysql.cj.jdbc.Driver" />
			<property name="hibernate.connection.username" value="[your-username]" />
			<property name="hibernate.connection.password" value="[your-password]" />
			<property name="hibernate.archive.autodetection" value="class" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
			<property name="hbm2ddl.auto" value="create" />
			<property name="javax.persistence.schema-generation.database.action"
				value="create" />
			<property name="javax.persistence.schema-generation.scripts.create-target"
				value="sampleCreate.ddl" />
			<property name="javax.persistence.schema-generation.scripts.drop-target"
				value="sampleDrop.ddl" />
		</properties>
	</persistence-unit>
</persistence>
```

Execute with TomCat

** The site used is only a trial and will not be used during production **
