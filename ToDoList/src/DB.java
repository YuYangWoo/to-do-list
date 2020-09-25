import java.sql.*;
public class DB {
    String jdbcDriver ="org.h2.Driver";
    String jdbcUrl="jdbc:h2:tcp://localhost/~/javadb";
    Connection conn;
    PreparedStatement pstmt;
}
