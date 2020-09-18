/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {

    private static String urlBanco = "jdbc:mysql://localhost:3306/conveniencia?useSSL=false";
    
    public static Connection getConexao()
    {
        
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(urlBanco, "zScrolLock", "luis@123");
            conexao.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Não foi possível fazer conexão com o banco");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return conexao;
    }
    
}
