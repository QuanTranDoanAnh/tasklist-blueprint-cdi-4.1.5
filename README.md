# tasklist-blueprint-cdi-4.1.5
tasklist-blueprint-cdi updated to Karaf 4.1.5

# Dependencies Installation
1. Run `feature:install pax-jdbc-config pax-jdbc-pool-dbcp2 jndi jpa transaction hibernate-orm hibernate jdbc webconsole war`
2. Run `feature:repo-add cxf 3.2.2`
3. Run `feature:install cxf`
4. Run `install mvn:com.h2database/h2/1.4.197` to install DB
5. Copy the data source file `org.ops4j.datasource-tasklist.cfg` in tasklist-cdi-persistence module to {karaf}/etc folder

# Run the project
1. From the project root folder build src using `mvn clean install`
2. Run `install -s mvn:vn.quantda.tasklist.cdi/tasklist-cdi-model/1.0.0-SNAPSHOT`
3. Run `install -s mvn:vn.quantda.tasklist.cdi/tasklist-cdi-persistence/1.0.0-SNAPSHOT`
4. Run `install -s mvn:vn.quantda.tasklist.cdi/tasklist-cdi-service/1.0.0-SNAPSHOT`
5. Run `install -s mvn:vn.quantda.tasklist.cdi/tasklist-cdi-ui-angular/1.0.0-SNAPSHOT`
