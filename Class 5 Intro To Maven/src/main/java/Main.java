import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}


//public class Main {
//
//
//    public static void main(String[] args) throws SQLException {
//
////        Protocol ->
////        http, https -> For web surfing
////        ftp - file transfer protocol
////         smtp - simple mail transfer
//// jdbc - java DATABASE CONNECTIVITY
////        Only for relational DBs (mySQL)
//
////              DB sever (IP address + PORT number)
////              /    |   \
////          DB1  DB2     DB3
/////          |  \
////      T1  T2  T3
//
//        System.out.println("Hello world!");
//
//        String url = "jdbc:mysql://localhost:3306/test";
//        // url : Pointing to the same machine
//        Connection connection = DriverManager.getConnection(url, "root", "");
//
//        String sqlQuery = "CREATE TABLE person(id int, name varchar(16))";
//
//        Statement statement = connection.createStatement();
//        statement.execute(sqlQuery);
//
//
//        // Why do we need to Maven?
//        // It's impossible to download all the libraries manually on our own
//        // It helps in building the entire project from compilation to execution
//        // It adds all the recursive dependencies to the project structure
//
//        // GroupId
//        // ArtifactId
//        // Version
//
//
////        Atlassian                  [Group]
////              -Bitbucket
////              -Jira
////              -Confluent
//
//    }
//}
