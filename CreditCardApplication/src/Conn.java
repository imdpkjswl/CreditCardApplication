import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn
{
    Connection c;
    Statement s;

    public Conn()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection("jdbc:mysql:///miniproject", "root", "");
            this.s = this.c.createStatement();
        } catch (Exception var2) {
            System.out.println("Error: " + var2);
        }

    }
}
