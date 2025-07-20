package models;

import cnstant.DatabaseConstants;
import exceptions.LoginException;
import java.sql.*;
import java.util.ArrayList;

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile;
    private Character gender;
    private String email;
    private String password;

    public static class MetaData {
        public static final String TABLE_NAME = "students";
        public static final String ID = "id";
        public static final String MOBILE = "mobile";
        public static final String LAST_NAME = "last_name";
        public static final String FIRST_NAME = "first_name";
        public static final String GENDER = "gender";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    // Constructors
    public Student() {}

    public Student(String firstName, String lastName, String mobile, Character gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public Student(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Student(Integer id, String firstName, String lastName, String mobile, Character gender, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public Character getGender() { return gender; }
    public void setGender(Character gender) { this.gender = gender; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    // Database Operations
    public static void createTable() {
        String sql = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
            "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "%s VARCHAR(50) NOT NULL, " +
            "%s VARCHAR(50) NOT NULL, " +
            "%s VARCHAR(20) NOT NULL, " +
            "%s CHAR(1) NOT NULL, " +
            "%s VARCHAR(100) UNIQUE NOT NULL, " +
            "%s VARCHAR(100) NOT NULL)",
            MetaData.TABLE_NAME,
            MetaData.ID,
            MetaData.FIRST_NAME,
            MetaData.LAST_NAME,
            MetaData.MOBILE,
            MetaData.GENDER,
            MetaData.EMAIL,
            MetaData.PASSWORD
        );

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public Student save() {
        String sql = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)",
            MetaData.TABLE_NAME,
            MetaData.FIRST_NAME,
            MetaData.LAST_NAME,
            MetaData.MOBILE,
            MetaData.GENDER,
            MetaData.EMAIL,
            MetaData.PASSWORD
        );

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, mobile);
            pstmt.setString(4, String.valueOf(gender));
            pstmt.setString(5, email);
            pstmt.setString(6, password);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating student failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
            }
            return this;
        } catch (SQLException e) {
            System.err.println("Error saving student: " + e.getMessage());
            return null;
        }
    }

    public static ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = String.format(
            "SELECT %s, %s, %s, %s, %s, %s, %s FROM %s",
            MetaData.ID,
            MetaData.FIRST_NAME,
            MetaData.LAST_NAME,
            MetaData.MOBILE,
            MetaData.GENDER,
            MetaData.EMAIL,
            MetaData.PASSWORD,
            MetaData.TABLE_NAME
        );

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5).charAt(0),
                    rs.getString(6),
                    rs.getString(7)
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Error getting students: " + e.getMessage());
        }
        return students;
    }

    public boolean isExists() {
        String sql = String.format(
            "SELECT 1 FROM %s WHERE %s = ?",
            MetaData.TABLE_NAME,
            MetaData.EMAIL
        );

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error checking student existence: " + e.getMessage());
            return false;
        }
    }

    public void login() throws LoginException {
        String sql = String.format(
            "SELECT %s, %s, %s, %s, %s FROM %s WHERE %s = ? AND %s = ?",
            MetaData.ID,
            MetaData.FIRST_NAME,
            MetaData.LAST_NAME,
            MetaData.MOBILE,
            MetaData.GENDER,
            MetaData.TABLE_NAME,
            MetaData.EMAIL,
            MetaData.PASSWORD
        );

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                    firstName = rs.getString(2);
                    lastName = rs.getString(3);
                    mobile = rs.getString(4);
                    gender = rs.getString(5).charAt(0);
                } else {
                    throw new LoginException("Invalid email or password");
                }
            }
        } catch (SQLException e) {
            throw new LoginException("Database error during login: " + e.getMessage());
        }
    }
}