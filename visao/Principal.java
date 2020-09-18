/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.Scanner;

/**
 *
 * @author zScrolLock
 */
public class Principal {
    TelaCliente telaC = new TelaCliente();
    TelaProduto telaP = new TelaProduto();
    
    public void MenuPrincipal(){
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
            do{
                System.out.println("1 - Inserir Cliente");
                System.out.println("2 - Alterar Cliente");
                System.out.println("3 - Excluir Cliente");
                System.out.println("4 - Apresentar Cliente");
                System.out.println("5 - Apresentar Todos os Clientes");
                System.out.println("6 - Inserir Produto");
                System.out.println("7 - Alterar Produto");
                System.out.println("8 - Excluir Produto");
                System.out.println("9 - Apresentar Produto");
                System.out.println("10 - Apresentar Todos os Produtos");
                System.out.print("Digite uma opcao: ");
                opcao = ler.nextInt();
                    switch(opcao){
                        case 1:
                            telaC.adicionarCliente();
                        break;
                         
                        case 2:
                            telaC.alterarCliente();
                        break;
                            
                        case 3:
                            telaC.excluirCliente();
                        break;
                         
                        case 4:
                            telaC.apresentarCliente();
                        break;
                            
                        case 5:
                            telaC.relacaoCliente();
                        break;
                         
                        case 6:
                            telaP.adicionarProduto();
                        break;
                            
                        case 7:
                            telaP.alterarProduto();
                        break;
                                   
                        case 8:
                            telaP.excluirProduto();
                        break;
                            
                        case 9:
                            telaP.apresentarProduto();
                        break;
                         
                        case 10:
                            telaP.relacaoProduto();
                        break;
                    }
                
            }while(opcao != 0);
    }
    
    
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.MenuPrincipal();
    }
}
