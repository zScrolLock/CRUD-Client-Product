/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import modelo.Cliente;



/**
 *
 * @author zScrolLock
 */
public class ControleCliente {
    
    
    public void inserirCliente(int codigoCliente, String nome, String cpf, String endereco, String cidade, String estado, String telefone) throws SQLException{
        //int codigoCliente;String nome;String cpf; String endereco; String cidade; String estado; String telefone;
        
        Connection conexao = Conexao.getConexao();
        String comando = "INSERT INTO cliente(codigocliente, nome, cpf, endereco, cidade, estado, telefone)" + "values(?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigoCliente);
        execSQL.setString(2, nome);
        execSQL.setString(3, cpf);
        execSQL.setString(4, endereco);
        execSQL.setString(5, cidade);
        execSQL.setString(6, estado);
        execSQL.setString(7, telefone);
        
        execSQL.executeUpdate();
        conexao.commit();
        execSQL.close();
        conexao.close();
    }
    
    public void excluirCliente(int codigoCliente) throws SQLException, Exception {
        int qntLinhas  = 0;
        Connection conexao = Conexao.getConexao();
        String comando = "DELETE FROM cliente WHERE codigoCliente = ?";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigoCliente);
        qntLinhas = execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        conexao.close();
            if(qntLinhas == 0){
                throw new Exception("Nao existem Clientes com esse codigo: " + codigoCliente + "\n");
            }
    }
    
    public void alterarCliente(int codigoCliente, String nome, String cpf, String endereco, String cidade, String estado, String telefone) throws SQLException, Exception {
        int qntLinhas = 0;
        Connection conexao = Conexao.getConexao();
        String comando = "UPDATE cliente set nome = ?, cpf = ?, endereco = ?, cidade = ?, estado = ?, telefone = ?" + "WHERE codigoCliente = ?";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigoCliente);
        execSQL.setString(2, nome);
        execSQL.setString(3, cpf);
        execSQL.setString(4, endereco);
        execSQL.setString(5, cidade);
        execSQL.setString(6, estado);
        execSQL.setString(7, telefone);
        
        qntLinhas = execSQL.executeUpdate();
        
        conexao.commit();
        execSQL.close();
        conexao.close();
            if(qntLinhas == 0){
                throw new Exception("Cliente nao encontrado\n");
            }
    }
    
    public Cliente pesquisarCliente(int codigoCliente) throws SQLException, Exception{
        Cliente cli = null;
        Connection conexao = Conexao.getConexao();
        String comando = "SELECT * FROM cliente WHERE codigoCliente = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigoCliente);
        
        ResultSet resultQuery;
        resultQuery = execSQL.executeQuery();
        
        resultQuery.last();
            if(resultQuery.getRow() > 0){
                cli = new Cliente();
                cli.setCodigoCliente(codigoCliente);
                cli.setNome(resultQuery.getString("nome"));
                cli.setCpf(resultQuery.getString("cpf"));
                cli.setEndereco(resultQuery.getString("endereco"));
                cli.setCidade(resultQuery.getString("cidade"));
                cli.setEstado(resultQuery.getString("estado"));
                cli.setTelefone(resultQuery.getString("telefone"));
            }else{
                throw new Exception("Cliente nao encontrado\n");
            }
        
        execSQL.close();
        conexao.close();
        
        return cli;
    }
    
    public List<Cliente> listarTodosCliente() throws SQLException {
        
        List<Cliente> clientes = new ArrayList<>();
        Connection conexao = Conexao.getConexao();
        
        String comando = "SELECT * FROM cliente";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        ResultSet resultQuery;
        resultQuery = execSQL.executeQuery();
        
        Cliente cli;
            while(resultQuery.next()){
                cli = new Cliente();
                cli.setCodigoCliente(resultQuery.getInt("codigoCliente"));
                cli.setNome(resultQuery.getString("nome"));
                cli.setCpf(resultQuery.getString("cpf"));
                cli.setEndereco(resultQuery.getString("endereco"));
                cli.setCidade(resultQuery.getString("cidade"));
                cli.setEstado(resultQuery.getString("estado"));
                cli.setTelefone(resultQuery.getString("telefone"));
                
                clientes.add(cli);       
            }
       
        return clientes;
    }
}
