
package com.mycompany.hadirgo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KelasDb {
    private static final String URL = "jdbc:sqlite:admin.db";
    
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS kelas (\n"
                                                + " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                                                + " kodeKelas TEXT NOT NULL,\n"
                                                + " namaKelas TEXT NOT NULL,\n"
                                                + " jam byte NOT NULL, \n"
                                                + " menit byte NOT NULL, \n"
                                                + " dosen TEXT NOT NULL"
                                                + ");";
    
    private static boolean isDataExist = false;
    
    public static void buatTabelAwalan(Connection conn) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.execute(CREATE_TABLE_SQL);
        stmt.close();
    }
    
    public static void insertKelasBaru(String kodeKelas, String namaKelas, byte jam, byte menit, String namaDosen){
        String sql = "INSERT INTO kelas (kodeKelas, namaKelas, jam, menit, dosen) \n"
                    + "VALUES(?, ?, ?, ?, ?);";
        try{
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection(URL)) {
                if(!isDataExist){
                    buatTabelAwalan(conn);
                }
                
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, kodeKelas);
                preparedStatement.setString(2, namaKelas);
                preparedStatement.setByte(3, jam);
                preparedStatement.setByte(4, menit);
                preparedStatement.setString(5, namaDosen);
                
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            }
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    public static void updateKelas(String kodeKelasLama, String kodeKelasBaru, String namaKelas, byte jam, byte menit, String namaDosen){
        String sql = "UPDATE kelas SET kodeKelas = ?,\n"
                + " namaKelas = ?, \n"
                + " jam = ?, \n"
                + " menit = ?, \n"
                + " namaDosen = ? "
                + "WHERE kodeKelas = ?;";
        
        try{
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection(URL)) {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, kodeKelasBaru);
                preparedStatement.setString(2, namaKelas);
                preparedStatement.setByte(3, jam);
                preparedStatement.setByte(4, menit);
                preparedStatement.setString(5, namaDosen);
                preparedStatement.setString(6, kodeKelasLama);
                
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            }
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteKelas(String kodeKelas){
        String sql = "DELETE FROM kelas where kodeKelas = ?;";
        try{
            Class.forName("org.sqlite.JDBC");
            
            try (Connection conn = DriverManager.getConnection(URL)) {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, kodeKelas);
                
                preparedStatement.executeUpdate();
                preparedStatement.close();
                conn.close();
            }
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
