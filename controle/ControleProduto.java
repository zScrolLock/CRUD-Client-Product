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
import modelo.Produto;

/**
 *
 * @author zScrolLock
 */
public class ControleProduto {
    
    public void inserirProduto(int codigo, String descricao, double preco, int quantidade) throws SQLException{
        //int codigoCliente;String nome;String cpf; String endereco; String cidade; String estado; String telefone;
        
        Connection conexao = Conexao.getConexao();
        String comando = "INSERT INTO produto(codigo, descricao, preco, quantidade)" + "values(?, ?, ?, ?)";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigo);
        execSQL.setString(2, descricao);
        execSQL.setDouble(3, preco);
        execSQL.setInt(4, quantidade);
        
        execSQL.executeUpdate();
        conexao.commit();
        execSQL.close();
        conexao.close();
    }
    
    public void excluirProduto(int codigo) throws SQLException, Exception {
        int qntLinhas  = 0;
        Connection conexao = Conexao.getConexao();
        String comando = "DELETE FROM produto WHERE codigo = ?";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigo);
        qntLinhas = execSQL.executeUpdate();
        
        conexao.commit();
        
        execSQL.close();
        conexao.close();
            if(qntLinhas == 0){
                throw new Exception("Nao existem Produtos com esse codigo: " + codigo + "\n");
            }
    }
    
    public void alterarProduto(int codigo, String descricao, double preco, int quantidade) throws SQLException, Exception {
        int qntLinhas = 0;
        Connection conexao = Conexao.getConexao();
        String comando = "UPDATE cliente set nome = ?, cpf = ?, endereco = ?, cidade = ?, estado = ?, telefone = ?" + "WHERE codigoCliente = ?";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigo);
        execSQL.setString(2, descricao);
        execSQL.setDouble(3, preco);
        execSQL.setInt(4, quantidade);
        
        qntLinhas = execSQL.executeUpdate();
        
        conexao.commit();
        execSQL.close();
        conexao.close();
            if(qntLinhas == 0){
                throw new Exception("Cliente nao encontrado\n");
            }
    }
    
    public Produto pesquisarProduto(int codigo) throws SQLException, Exception{
        Produto prod = null;
        Connection conexao = Conexao.getConexao();
        String comando = "SELECT * FROM produto WHERE codigo = ?";
        
        PreparedStatement execSQL;
        
        execSQL = conexao.prepareStatement(comando);
        
        execSQL.setInt(1, codigo);
        
        ResultSet resultQuery;
        resultQuery = execSQL.executeQuery();
        
        resultQuery.last();
            if(resultQuery.getRow() > 0){
                prod = new Produto();
                prod.setCodigo(codigo);
                prod.setDescricao(resultQuery.getString("descricao"));
                prod.setPreco(resultQuery.getDouble("preco"));
                prod.setQuantidade(resultQuery.getInt("quantidade"));
            }else{
                throw new Exception("Produto nao encontrado\n");
            }
        
        execSQL.close();
        conexao.close();
        
        return prod;
    }
    
    public List<Produto> listarTodosProdutos() throws SQLException {
        
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = Conexao.getConexao();
        
        String comando = "SELECT * FROM cliente";
        
        PreparedStatement execSQL;
        execSQL = conexao.prepareStatement(comando);
        
        ResultSet resultQuery;
        resultQuery = execSQL.executeQuery();
        
        Produto prod;
            while(resultQuery.next()){
                prod = new Produto();
                prod.setCodigo(resultQuery.getInt("codigo"));
                prod.setDescricao(resultQuery.getString("descricao"));
                prod.setPreco(resultQuery.getDouble("preco"));
                prod.setQuantidade(resultQuery.getInt("quantidade"));
                
                produtos.add(prod);       
            }
       
        return produtos;
    }
}
