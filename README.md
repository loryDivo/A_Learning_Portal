# A-Learning

A-leaerning è il portale per gli studenti universitari attraverso il quale è possible iscriversi ai corsi frequentati ed utilizzare il materiale pubblicato. 
Il portale è molto semplice:
  - Effettua la registrazione
  - Accedi al tuo account
  - Iscriviti ai corsi disponibili

### Strumenti amministratore

L'utente amministratore potrà:
  - Creare nuovi corsi assegnando i CFU corrispondendti
  - Bannare gli utenti per fino ad una determinata data, oppure bannarli per sempre
  - Togliere il ban di un utente e permettere quindi l'accesso

### Tecnologie utilizzate

A-learning utilizza diverse tecnologie per funzionare:
* [Eclipse](http://www.eclipse.org) v4.7.1a
* [Tomcat](https://tomcat.apache.org/download-80.cgi) v*.*
* [MySql](https://www.mysql.com/it/) v5.7.20
* [Hibernate](http://hibernate.org)

### Utilizzo
A-learning può essere utilizzato visitando il sito di [A-learning](http://a-learning-a-learning.1d35.starter-us-east-1.openshiftapps.com/Assignment3).
Sono presenti i seguenti utenti di test:

##### Utente Normale:
username: user
password: 123123123A

##### Utente Amministratore:
username: admin
password: 123123123A


### Installazione

A-learning richiede l'installazione di [Eclipse](http://www.eclipse.org/downloads/eclipse-packages), [MySql](https://www.mysql.com/it/) e [Tomcat](https://tomcat.apache.org/download-80.cgi).

Importare il progetto in Eclipse:

```sh
Dal programma Eclipse 
-> Selezionare "import"
-> Selezionare "Existing Maven Project"
Automaticamente verrà identificato il pom.xml contenente le dipendenze
Click col destro nel progetto importato
-> Selezionare la voce "Properties"
-> Selezionare la sezione "Project Facets"
-> Nella sezione destra selezionare "Runtimes"
-> Selezionare successivamente "Apache TomCat v *.*"
```

Impostare TomCat

```sh
Dal programma Eclipse
-> Dal menu di Eclipse in basso selezionare la sezione "Servers"
-> Click col destro e selezionare "New" e selezionare "Server"
-> Selezionare "Apache TomCat v *.*" e selezionare directory di "Apache TomCat v *.*" scaricata
```

Creare un database nominato `assignment3`

Modificare il file /src/main/resources/META-INF/persistence.xml come segue, prestando attenzione ai campi username e password:
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

Eseguire con Tomcat l'applicazione

**Il sito utilizzato è soltanto una prova e non verrà usato in fase di produzione**