package com.dithkara.Item1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is an example of using a service provider framework interface with a JDBC driver.
 *
 * Using Postgres as the database.
 * Install postgres latest version.
 *
 * After installing a postgres user is created in the system, but we can't/shouldn't use this user for our activities.
 * This is just a default user, just like sa in mysql.
 *
 * Create a super user with a username in postgres, since it is not correct to create password for postgres user
 * for security reasons
 *
 * Once the superuser is created in postgres, connect to the new user from the root console and connect to postgres using
 * the command 'psql <the db name>'
 */
public class ServiceProviderFrameworkPattern {

    public void getConnection() throws SQLException, ClassNotFoundException {

        // This is the provider registration API, not used after JDBC 4
        //Class.forName("org.postgresql.Driver");

        // the driver is the service provider interface which is mentioned in the META-INF/services/java.sql.Driver

        // This is the service interface
        Connection connection;

        // Service Access API with criteria for selection, this is static factory function which is a public static implementation
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/thinking_in_java_db","dithkara", "123456");

        connection.close();

    }

    public static void main(String[] args) {
        ServiceProviderFrameworkPattern serviceProviderFrameworkPattern =  new ServiceProviderFrameworkPattern();
        try {
            serviceProviderFrameworkPattern.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
