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
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS account (\n"
                                                + " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                                                + " username TEXT NOT NULL UNIQUE,\n"
                                                + " password TEXT NOT NULL\n"
                                                + ");";
    
    //insert data dosen dan admin untuk login
    //username dan password akun dosen adalah dosen dan dosen secara berturut2
    //username dan password akun admin juga sama, admin dan admin
    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO account (username, password)\n"
                                                     + " VALUES('admin', 'admin'),"
                                                     + " ('dosen', 'dosen');";
    
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
            Connection conn = DriverManager.getConnection(URL);
            Statement statement = conn.createStatement();
            statement.execute(INSERT_ACCOUNT_SQL);
            isAccountInserted = true;
            
            statement.close();
            conn.close();
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
            Connection conn = DriverManager.getConnection(URL);
            
            //membuat preparedstatement untuk query validasi
            PreparedStatement preparedStatement = conn.prepareStatement(VALIDATE_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            return false;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return false;
    }
}
