package com.iscoapps.healthapp.DataBase;


public class User
{
    public static final String TABLE_NAME = "users";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_DB = "DB";
    public static final String COLUMN_Gender = "gender";

    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String name;
    private String email;
    private String password;
    private String DB;
    private String timestamp;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDB() {
        return DB;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    // Create table SQL query
    public static final String CREATE_TABLE=
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_EMAIL + " TEXT UNIQUE,"
                    + COLUMN_PASSWORD + " TEXT,"
                    + COLUMN_DB + " TEXT,"
                    + COLUMN_Gender + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";



    public User() {
    }

    public User(int id, String name, String email,
                String password, String db,
                String gender,
                String timestamp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.DB = DB;
        this.gender = this.gender;

        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}