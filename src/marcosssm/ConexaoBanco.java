/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marcosssm;

import java.sql.*;

/**
 *
 * @author samu2
 */
public class ConexaoBanco {

    public ConexaoBanco() {
    }

    private static Connection conn = null;
    private static Statement db_statement = null;

    public static Connection getInstanceConn() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = null;
                Conexao conexao = new Conexao();
                conn = conexao.getConexao();
                conn.setAutoCommit(true);
                db_statement = conn.createStatement();
            }
        } catch (Exception e) {
            System.out.println("0. Erro ao conectar com o banco. Erro:" + e.getMessage());
        }
        return conn;
    }

    public static Statement getInstanceStatement() throws Exception {
        if (db_statement == null) {
            getInstanceConn();
        }
        return db_statement;
    }

    public static void closeInstanceConn() throws Exception {
        if (conn != null) {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
        conn = null;
        db_statement = null;
    }
}
