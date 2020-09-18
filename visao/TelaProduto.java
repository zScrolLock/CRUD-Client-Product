/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ControleProduto;
import java.util.Scanner;

/**
 *
 * @author zScrolLock
 */
public class TelaProduto {
    ControleProduto controle = new ControleProduto();
	Scanner ler = new Scanner(System.in);
		
		public void adicionarProduto() {
			//int codigo, String descricao, double preco, int quantidade
			int codigo;
			String descricao;
			double preco;
			int quantidade;
			
			System.out.print("Digite o Codigo do Produto: ");
			codigo = ler.nextInt();
			System.out.print("Digite a Descricao do Produto: ");
			descricao = ler.nextLine();
			descricao = ler.nextLine();
			System.out.print("Digite o Preco do Produto: ");
			preco = ler.nextDouble();
			System.out.print("Digite a Quantidade do Produto: ");
			quantidade = ler.nextInt();
                        
                        try{
                            controle.inserirProduto(codigo, descricao, preco, quantidade);
                        }catch(Exception e){
                            
                        }
		}
		
		public void alterarProduto() {
			int cod;
			int novoCodigo;
			String novaDescricao;
			double novoPreco;
			int novaQuantidade;
			
			System.out.println("Digite o Codigo do Produto que Deseja Alterar: ");
			cod = ler.nextInt();
			
			System.out.println("ALTERACAO DO PRODUTO SELECIONADO\n");
			System.out.print("Digite a Nova Descricao do Produto: ");
			novaDescricao = ler.nextLine();
			novaDescricao = ler.nextLine();
			System.out.print("Digite o Novo Preco do Produto: ");
			novoPreco = ler.nextDouble();
			System.out.print("Digite a Nova Quantidade do Produto: ");
			novaQuantidade = ler.nextInt();
			
                        try{
                            controle.alterarProduto(cod, novaDescricao, novoPreco, novaQuantidade);
                        }catch(Exception e){
                            System.err.println("Nao foi possivel alterar produto ou produto nao existe\n");
                        }
		}
		
		public void apresentarProduto() {
			int cod;
			System.out.print("Digite o Codigo do Produto que deseja exibir: ");
			cod = ler.nextInt();
			
                        try{
                            controle.pesquisarProduto(cod);
                        }catch(Exception e){
                            System.err.println("Nao foi encontrado produtos com esse codigo: " + cod + "\n");
                        }
		}
		
		public void relacaoProduto() {
                    try{
			controle.listarTodosProdutos();
                    }catch(Exception e){
                        System.err.println("Nao ha produtos para listar\n");
                    }
		}
                
                public void excluirProduto(){
                    int codigo;
                    System.out.println("Digite o Codigo do Produto que deseja Excluir: ");
                    codigo = ler.nextInt();
                    
                    try{
                        controle.excluirProduto(codigo);
                    }catch(Exception e){
                        System.err.println("Nao ha produtos com esse codigo " + codigo + "\n");
                    }
                }
}
