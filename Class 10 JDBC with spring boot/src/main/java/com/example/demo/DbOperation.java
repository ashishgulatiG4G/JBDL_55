package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DbOperation {

    private Connection connection = null;

    // app Server = 127.0.0.1 8080
    // db server = 127.0.0.1 3306

    //https://www.localhost.com

    //DB Server -> [DB1, DB2, Db3]
    // DB1 -> [T1, T2, T3, T4]
    // T =
    // [id, name, age]
    //  1   john, 122

    // C -> Won't return something
    // R -> return something
    // U -> Won't return something
    // D -> Won't return something


    // Primary Key = Unique ID for entire row


    // DDL - Data definition Language (create table, create index, alter table)
    // DML - Data manipulation language (delete from, insert into, update)


    /**
     * To generate id
     *  1. Using an auto incremented number
     *  2. You generate a random number (e.g. randomness can depend on multiple factors: Time + RandomNumber) -> MongoDB
     */

    /**
     * Auto increment works on:
     *
     * 1
     * 2
     * 6
     * 15
     *
     * 1. Last id which is inserted + 1 -> 7
     * 2. largest Id+1 -> 16 ************************
     * 3. Missing -> 3
     */


    /**
     * Query = Select * from employee where id = ?
     * Compilation of Q -> Q'
     * Compiled query is run on the server
     *
     * Prepared Statement
     */

    public DbOperation(@Value("${db.url}") String url,
                       @Value("${db.username}") String username,
                       @Value("${db.password}") String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            createEmployeeTable();
        } catch (SQLException e) {
            log.error("Exception in creating the connection");
        }
    }

    private void createEmployeeTable() {
        try {
            String sql = "create table if not exists employee(id int primary key auto_increment, name varchar(30), age int)";
            Statement statement = this.connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            log.error("Couldn't create table: {}", e);
        }

        log.info("Table got created successfully");

    }

    // CREATE EMPLOYEE
    public void createEmployee(Employee employee) throws SQLException {
        // Write Logic to insert an employee in the table / DB
        // insert into employee(name, age) VALUES('JOHN', 30)

        String sql = "insert into employee(name, age) VALUES('" + employee.getName() + "'," + employee.getAge() + ")";
        Statement statement = this.connection.createStatement();
        Integer result = statement.executeUpdate(sql);
        log.info("Number of employees created - {}", result);

    }

    public void createEmployeeDynamic(Employee employee) throws SQLException {

        String sql = "insert into employee(name, age) VALUES(?,?)";
        PreparedStatement statement = this.connection.prepareStatement(sql);

        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getAge());

        Integer result = statement.executeUpdate();
        log.info("Number of employees created - {}", result);

    }


    // GET ALL EMPLOYEES
    public List<Employee> getEmployees() throws SQLException {
        // Write Logic to get employees from the table / DB
        // Select * from employee

        String sql = "Select * from employee";

        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<Employee> employeeList = new ArrayList<>();

        while(rs.next()) {
            Integer id = rs.getInt("id"); // rs.getInt("id")
            String name = rs.getString("name");
            Integer age = rs.getInt("age");

            Employee employee = new Employee(id, name, age);
            employeeList.add(employee);
        }

        return employeeList;
    }

    // Get Employee with a particular ID
    public Employee getEmployeeById(Integer employeeId) throws SQLException {
        // Write Logic to get employees from the table / DB
        // Select * from employee where id=employeeId

        String sql = "Select * from employee where id = " + employeeId;

        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            Integer id = rs.getInt("id"); // rs.getInt("id")
            String name = rs.getString("name");
            Integer age = rs.getInt("age");

            Employee employee = new Employee(id, name, age);
            return employee;
        }

        return null;
    }

    public Employee getEmployeeByName(String name1) throws SQLException {
        // Write Logic to get employees from the table / DB
        // Select * from employee where id=employeeId

        String sql = "Select * from employee where name = '" + name1 + "'";

        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            Integer id = rs.getInt("id"); // rs.getInt("id")
            String name = rs.getString("name");
            Integer age = rs.getInt("age");

            Employee employee = new Employee(id, name, age);
            return employee;
        }

        return null;
    }


    public void updateEmployee(Employee employee) {
        // update employee set name = ? age = ? where id = ?
        //1 -> employee.getName
    }

    public void patchUpdateEmployee(Employee employee) {
        // patch update employee set name = ? age = ? where id = ?
        //1 -> employee.getName
    }

    public void deleteEmployee(int id) {
        // delete from employee where id = ?
    }





}
