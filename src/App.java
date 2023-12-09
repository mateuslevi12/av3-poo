import java.util.Scanner;

import excecao.ProdutoIndisponivelException;
import geral.Celular;
import geral.Cliente;
import geral.Estoque;
import geral.FoneDeOuvido;
import geral.Gerente;
import geral.Notebook;
import geral.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();
        double valorC = 2000;
        double valorN = 4000;
        double valorF = 400;
        System.out.println("Seja bem vindo a MV imports!");
        System.out.println("Cliente = 1/ Gerente = 2 ?");
        int cargo = sc.nextInt();

        if (cargo == 1) {
            System.out.println("Digite seu nome: ");
            String nomeCliente = sc.next();
            sc.nextLine();
            System.out.println("Digite seu email: ");
            String email = sc.nextLine();
            System.out.println("Digite sua idade: ");
            int idade = sc.nextInt();
            System.out.println("Digite seu numero de telefone: ");
            int numero = sc.nextInt();
            System.out.println("Digite seu saldo disponivel para compras: ");
            int saldo = sc.nextInt();
            sc.nextLine();
            Cliente cliente = new Cliente(nomeCliente, idade, email, numero, saldo);
            System.out.println("Produtos disponiveis: ");
            // estoque.mostrarEstoque();
            System.out.println("Selecione o produto que deseja adicionar");
            System.out.println("1 - Celular - 2000,00(preço fixo)");
            System.out.println("2 - Notebook - 4000,00(preço fixo)");
            System.out.println("3 - Fone - 400,00(preço fixo)");

            int numeroProduto = sc.nextInt();
                while(numeroProduto > 0 && numeroProduto <3)
                if(numeroProduto == 1){
                    System.out.print("Digite o nome do celular: ");
                    String nome = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Digite a marca do celular: ");
                    String marca = sc.nextLine();
                    System.out.println();
                    Celular celular = new Celular(nome, valorC, marca);
                    cliente.getCarrinho().adicionarItem(celular);
                    cliente.getCarrinho().mostrarCarrinho();
            } else if(numeroProduto == 2){
                
            }  else if(numeroProduto == 3){
               
            } else {
                System.out.println("ERRO");
            }
             }
        // // ADICIONAR //
        // if (cargo == 2) {
        //     Gerente gerente = new Gerente("Victor", "dezoito", "vriosdantas@gmail.com", 99854776, 180305);
        //     System.out.println("---------GERENCIAMENTO DE ESTOQUE---------");
        //     System.out.println("Qual produto vc deseja adicionar?");
        //     System.out.println("1 - Celular");
        //     System.out.println("2 - Notebook");
        //     System.out.println("3 - Fone");
        //     System.out.println("x > 3 || x < 1 = ERRO");
        //     int numeroProduto = sc.nextInt();
        //     if(numeroProduto == 1){
        //         Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima geração", "iphone 15", "IOS 17", 560, 15.60);
        //         estoque.adicionarItem(celular);
        //         System.out.println("Celular adicionado com sucesso!");
        //     } else if(numeroProduto == 2){
        //         Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição", "Ryzen 7", 16, 1, "Linux");
        //         estoque.adicionarItem(notebook);
        //         System.out.println("Notebook adicionado com sucesso!");
        //     }  else if(numeroProduto == 3){
        //         Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        //         estoque.adicionarItem(fone);
        //         System.out.println("Fone adicionado com sucesso!");
        //     } else {
        //         System.out.println("ERRO");
        //     }
        //     System.out.println("Estoque atual");
        //     estoque.mostrarEstoque();

        // } else if(cargo == 1){
        //     System.out.println("Digite seu saldo");
        //     double saldo = sc.nextDouble();
        //     Cliente cliente = new Cliente("Victor", "dezoito", "vriosdantas@gmail.com", 99854776 ,saldo);
        //     System.out.println("---------COMPRAS NA LOJA---------");
        //     System.out.println("Qual produto vc deseja adicionar no carrinho?");
        //     System.out.println("1 - Celular");
        //     System.out.println("2 - Notebook");
        //     System.out.println("3 - Fone");
        //     System.out.println("x > 3 || x < 1 = ERRO");
            
        //     int numeroProduto = sc.nextInt();
        //     if(numeroProduto == 1){
        //         Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima geração", "iphone 15", "IOS 17", 560, 15.60);
        //         cliente.getCarrinho().adicionarItem(celular);
        //         System.out.println("Celular adicionado com sucesso!");
        //     } else if(numeroProduto == 2){
        //         Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição", "Ryzen 7", 16, 1, "Linux");
        //         cliente.getCarrinho().adicionarItem(notebook);
        //         System.out.println("Notebook adicionado com sucesso!");
        //     }  else if(numeroProduto == 3){
        //         Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        //         cliente.getCarrinho().adicionarItem(fone);
        //         System.out.println("Fone adicionado com sucesso!");
        //     } else {
        //         System.out.println("ERRO");
        //     }
        

        // }
    
        // // REMOVER //
        // if (cargo == 2) {
        //      Gerente gerente = new Gerente("Victor", "dezoito", "vriosdantas@gmail.com", 99854776, 180305);
        //     System.out.println("---------GERENCIAMENTO DE ESTOQUE---------");
        //     System.out.println("Deseja remover algo do estoque?");
        //     System.out.println("1 - Celular");
        //     System.out.println("2 - Notebook");
        //     System.out.println("3 - Fone");
        //     System.out.println("x > 3 || x < 1 = NÃO");
        //     int numeroProduto = sc.nextInt();
        //     if(numeroProduto == 1){
        //         Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima geração", "iphone 15", "IOS 17", 560, 15.60);
        //         estoque.removerItem(celular);
        //         System.out.println("Celular removido com sucesso!");
        //     } else if(numeroProduto == 2){
        //         Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição", "Ryzen 7", 16, 1, "Linux");
        //         estoque.removerItem(notebook);
        //         System.out.println("Notebook removido com sucesso!");
        //     }  else if(numeroProduto == 3){
        //         Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        //         estoque.removerItem(fone);
        //         System.out.println("Fone removido com sucesso!");
        //     } else {
        //         System.out.println("");
        //     }

        // } else if(cargo == 1){
        //     System.out.println("Digite seu saldo");
        //     double saldo = sc.nextDouble();
        //     Cliente cliente = new Cliente("Victor", "dezoito", "vriosdantas@gmail.com", 99854776 ,saldo);
        //     System.out.println("---------COMPRAS NA LOJA---------");
        //     System.out.println("Deseja remover algo do estoque?");
        //     System.out.println("1 - Celular");
        //     System.out.println("2 - Notebook");
        //     System.out.println("3 - Fone");
        //     System.out.println("x > 3 || x < 1 = NÃO");
            
        //     int numeroProduto = sc.nextInt();
        //     if(numeroProduto == 1){
        //         Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima geração", "iphone 15", "IOS 17", 560, 15.60);
        //         cliente.getCarrinho().removerItem(celular);
        //         System.out.println("Celular removido com sucesso!");
        //     } else if(numeroProduto == 2){
        //         Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição", "Ryzen 7", 16, 1, "Linux");
        //         cliente.getCarrinho().removerItem(notebook);
        //         System.out.println("Notebook removido com sucesso!");
        //     }  else if(numeroProduto == 3){
        //         Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        //         cliente.getCarrinho().removerItem(fone);
        //         System.out.println("Fone removido com sucesso!");
        //     } else {
        //         System.out.println("");
        //     }
        // }
        


        sc.close();
    }
}