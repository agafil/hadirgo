/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hadirgo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class HadirGoDb {
    //db dibuat dalam fungsi createAndInsert() secara otomatis
    //insert data juga dilakukan pada fungsi itu
    private static final String URL = "jdbc:sqlite:admin.db";
    
    //membuat tabel baru jika belum ada
    //isAdmin adalah state yang digunakan untuk membedakan akun dosen dan admin
    //0 = dosen
    //1 = admin
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS account (\n"
                                                + " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                                                + " username TEXT NOT NULL,\n"
                                                + " password TEXT NOT NULL,\n"
                                                + " isAdmin BIT NOT NULL"
                                                + ");";
    
    //insert data dosen dan admin untuk login
    //username dan password akun dosen = dosen, dosen
    //akun admin = admin, admin 
    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO account (username, password, isAdmin)\n"
                                                     + " VALUES('admin', 'admin', 1),"
                                                     + " ('dosen', 'dosen', 0);";
    
    //query untuk validasi akun waktu login di fungsi validate()
    private static final String VALIDATE_QUERY = "SELECT * FROM account WHERE \n"
                                                  + "  username = ? AND password = ?;";
    
    //state untuk mengecek apakah db sudah dibuat dengan akun admin dan dosen
    //true jika telah dibuat dengan fungsi createAndInsert()
    private static boolean isAccountInserted = false;
    
    //membuat admin.db dan akun dosen dan admin
    private static void createAndInsert(){
        try{
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection(URL); Statement statement = conn.createStatement()) {
                statement.execute(CREATE_TABLE_SQL);
                statement.execute(INSERT_ACCOUNT_SQL);
                isAccountInserted = true;
                
            }
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    //fungsi untuk validasi login
    public static boolean validate(String username, String password){
        if(!isAccountInserted){
            createAndInsert();
        }
        
        try{
            //mengakses db
            Class.forName("org.sqlite.JDBC");
            //membuat preparedstatement untuk query validasi
            try (Connection conn = DriverManager.getConnection(URL)) {
                //membuat preparedstatement untuk query validasi
                PreparedStatement preparedStatement = conn.prepareStatement(VALIDATE_QUERY);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    resultSet.close();
                    preparedStatement.close();
                    conn.close();
                    return true;
                }
                
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return false;
    }
}
