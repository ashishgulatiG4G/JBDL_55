package com.example.demojpa.daos;

import com.example.demojpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @Query -- To execute custom queries
     * 1. Native Query -> Writing queries keeping sql table in mind
     * 2. JPQL -> Java Persistence Query Language -> keep Java Objects in mind
     */

    List<Employee> findByNameAndAgeAndAddress(String name, Integer age, String address);

    // JPQL
//    @Query(value = "select e from Employee e where e.name=?1 and e.age=?2 and e.address=?3")
    //Native SQL Query
//  @Query(value = "select * from employee e where e.name=?1 and e.age=?2 and e.address=?3", nativeQuery = true)
//    List<Employee> findByNameAgeAddress(String name, Integer age, String address);
}
