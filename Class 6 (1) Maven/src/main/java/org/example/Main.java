package org.example;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public Main() throws Exception {
    }


    // A->B->C

    public static void main(String[] args)  {
//        Protocol ->
//        http, https -> For web surfing
//        ftp - file transfer protocol
//         smtp - simple mail transfer
// jdbc - java DATABASE CONNECTIVITY
//        Only for relational DBs (mySQL)

//              DB sever (IP address + PORT number)
//              /    |   \
//          DB1  DB2     DB3
///          |  \
//      T1  T2  T3

        int i = 10;
        System.out.println("Hello world!");

//        String url = "jdbc:mysql://localhost:3306/test";
        // url : Pointing to the same machine
//        Connection connection = DriverManager.getConnection(url, "root", "");
//
//        String sqlQuery = "CREATE TABLE person(id int, name varchar(16))";
//
//        Statement statement = connection.createStatement();
//        statement.execute(sqlQuery);


        // Why do we need to Maven?
        // It's impossible to download all the libraries manually on our own
        // It helps in building the entire project from compilation to execution
        // It adds all the recursive dependencies to the project structure

        // GroupId
        // ArtifactId
        // Version


//        Atlassian                  [Group]
//              -Bitbucket
//              -Jira
//              -Confluent

    }
// Repository -> A place where you can save/persist your libraries (maven artifacts)

//    Types of Maven repositories - >
//    1. Local repository -> /.m2/__
//    2. Central Repository -> this is available on internet and have open source libraries
//    3. Remote repository -> Protected, available on internet, but private to any org/enterprise

    // nexus, JFrog artifactory

// Pom.xml -> [Parsed] -> [for every dependency] -> found in local repo -> Add it to the classpath -> exit
//                                                   -> not found in local -> remote repo exists? -> download the library and add it to the classpath
//                                                                           -> central repo -> download the library and add it to the classpath


// A -> B -> C -> catch (throw), final block

// Catch at the level when you can do something useful about it
//throw when you reached an error and there's nothing more you can do besides letting the consumer of API's know about it and decide

//    FileInputStream fs = new FileInputStream("dns");









//    Q-1 Try to change the local repo's location from .m2 to something else
//    Q-2 -> Try to change the target folder's name


}