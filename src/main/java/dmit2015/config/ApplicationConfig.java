package dmit2015.config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

// TODO: Set the Jakarta EE Authentication Mechanism

// TODO: Set the Jakarta EE Identity Store

@DataSourceDefinitions({

		// TODO: Change the value for yourNaitUsername and yourStudentID
		@DataSourceDefinition(
			name="java:app/datasources/mssqlDS",
			className="com.microsoft.sqlserver.jdbc.SQLServerDataSource",
			url="jdbc:sqlserver://DMIT-Capstone1.ad.sast.ca;databaseName=DMIT2015_1213_E01_yourNaitUsername;TrustServerCertificate=true",
			user="yourNaitUsername",
			password="RemotePassword.yourNaitUsername"),

//			name="java:app/datasources/mssqlDS",
//			className="com.microsoft.sqlserver.jdbc.SQLServerDataSource",
//			url="jdbc:sqlserver://localhost;databaseName=DMIT2015_1213_CourseDB;TrustServerCertificate=true",
//			user="user2015",
//			password="Password2015"),

})

@FacesConfig
@ApplicationScoped
public class ApplicationConfig {

}