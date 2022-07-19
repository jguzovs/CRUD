import java.sql.*;

public class DBLogic {
    HelperMethods help = new HelperMethods();

    private String DB;
    private String USER;
    private String PASSWORD;

    // getter for database path
    public String getDB() {
        return DB;
    }

    // getter for user
    public String getUser() {
        return USER;
    }

    // getter for password
    public String getPassword() {
        return PASSWORD;
    }

    // setter for database path
    public void setDB(String newDB) {
        DB = newDB;
    }
    
    // setter for user
    public void setUSER(String newUSER){
        USER = newUSER;
    }
    
    // setter for password
    public void setPASSWORD(String newPASSWORD){
        PASSWORD = newPASSWORD;
    }

    // method to print ConnectionInfo
    public void printConnectionInfo(){
        System.out.println();
        System.out.println("Connection Info:");
        help.printSeparator(20);
        System.out.println("DB: " + getDB());
        System.out.println("USER: " + getUser());
        help.printSeparator(20);
    }

    // insert
    public void insert(String name, String email) {

        try {
            Connection conn = DriverManager.getConnection(DB, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO users (email, name) VALUES ('" + name + "', '" + email + "')";

            stmt.executeUpdate(sql);

            System.out.println();
            System.out.println("Data was added successfully!");
            System.out.println();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete(int id) {

        try {
            Connection conn = DriverManager.getConnection(DB, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM users WHERE id = " + id + "";

            stmt.executeUpdate(sql);

            help.printSeparator(20);
            System.out.println("Data was deleted successfully!");
            help.printSeparator(20);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update
    public void update(int id, String column, String newInfo) {

        try {
            Connection conn = DriverManager.getConnection(DB, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            String sql = "UPDATE users SET " + column + " = '" + newInfo + "' WHERE id = '" + id + "'";

            stmt.executeUpdate(sql);

            help.printSeparator(20);
            System.out.println("Data was updated successfully!");
            help.printSeparator(20);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // read
    public void read() {

        try {
            Connection conn = DriverManager.getConnection(DB, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, name FROM users");  

            while (rs.next()) {

                System.out.println("id: " + rs.getInt("id"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("name: " + rs.getString("name"));
                help.printSeparator(20);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to try to connect
    public void connect() throws SQLException {
        DriverManager.getConnection(DB, USER, PASSWORD);
    }
}
