import java.util.Scanner;
import excecao.SaldoInsuficienteException;
import geral.Cartao;
import geral.Celular;
import geral.Cliente;
import geral.Estoque;
import geral.FoneDeOuvido;
import leituraEscrita.LeituraEstoque;
import leituraEscrita.EscritaNotaFiscal;
import geral.Notebook;
import geral.Pix;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

        String name = "C:\\Users\\mateu\\Downloads\\(1)programas\\estoque.txt";
        LeituraEstoque leitura = new LeituraEstoque();
        leitura.efeituarLeritura(name);
        estoque.setItensEstoque(leitura.getItensEstoque());
        // boolean parar;

        double valorC = 2000;
        double valorN = 4000;
        double valorF = 400;

        double memoria = 16;
        double tela = 15.8;
        String tipo = "semFio";

        System.out.println("Seja bem vindo a MV imports!");
        System.out.println("Cliente = 1/ Gerente = 2 ?");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.println("------Seja bem vido a MV IMPORTS------");
            System.out.print("Digite seu nome:");
            String nome = sc.next();
            sc.nextLine();
            System.out.print("Digite sua idade: ");
            int idade = sc.nextInt();
            System.out.print("Digite seu email: ");
            String email = sc.next();
            sc.nextLine();
            System.out.print("Digite seu numero de telefone:  ");
            int numero = sc.nextInt();
            System.out.print("Digite seu saldo disponivel: ");
            int saldo = sc.nextInt();
            Cliente cliente = new Cliente(nome, idade, email, numero, saldo);
            System.out.println("Esse são os itens disponiveis da nossa loja: ");
            estoque.mostrarEstoque();
            System.out.print("Deseja adicionar um item ? \n (1 - Sim /2 - Nao /3 - Remover)");
            int Escolha = sc.nextInt();

            while (Escolha == 1) {
                System.out.println("Selecione o produto que deseja adicionar");
                System.out.println("1 - Celular");
                System.out.println("2 - Notebook");
                System.out.println("3 - Fone De Ouvido");
                int escolha = sc.nextInt();

                if (escolha == 1) {
                    System.out.print("Digite o nome do celular");
                    String nomeProd = sc.next();
                    sc.nextLine();
                    System.out.print("Digite a marca do celular");
                    String marca = sc.next();
                    sc.nextLine();
                    Celular celular = new Celular(nomeProd, valorC, marca, memoria);
                    cliente.getCarrinho().adicionarItem(celular);
                }

                else if (escolha == 2) {
                    System.out.print("Digite o nome do notebook");
                    String nomeProd = sc.next();
                    sc.nextLine();
                    System.out.print("Digite a marca do notebook");
                    String marca = sc.next();
                    sc.nextLine();
                    Notebook notebook = new Notebook(nomeProd, valorN, marca, tela);
                    cliente.getCarrinho().adicionarItem(notebook);
                }

                else if (escolha == 3) {
                    System.out.print("Digite o nome do fone");
                    String nomeProd = sc.next();
                    sc.nextLine();
                    System.out.print("Digite a marca do fone");
                    String marca = sc.next();
                    sc.nextLine();
                    FoneDeOuvido fone = new FoneDeOuvido(nomeProd, valorF, marca, tipo);
                    cliente.getCarrinho().adicionarItem(fone);
                }
                System.out.print("Deseja adicionar outro item ? \n (1 - Sim /2 - Nao /3 - Remover)");
                Escolha = sc.nextInt();
            }

            if (Escolha == 2) {
                
                cliente.getCarrinho().mostrarCarrinho();

                System.out.println("Selecione a forma de pagamento");
                System.out.println("1 - Cartão de Credito");
                System.out.println("2 - PIX");
                int escolha = sc.nextInt();
                if (escolha == 1) {
                    Cartao cartao = new Cartao(cliente.getCarrinho().getValorCarrinho());
                    // double valorFinal = cliente.getCarrinho().getValorCarrinho();

                    cartao.solicitarPagamento();
                    System.out.print("Insira sua senha: ");
                    int senha = sc.nextInt();
                    cartao.efetuarPagamento();
                    System.out.println("Nota fiscal emitida com sucesso!!!");
                    EscritaNotaFiscal escrita = new EscritaNotaFiscal(cliente.getCarrinho(), cliente);
                    String fileNameOut = "notaFiscal.txt";

                    escrita.efetuaEscrita(fileNameOut);

                } else if (escolha == 2) {
                    Pix pix = new Pix(cliente.getCarrinho().getValorCarrinho());
                    if (saldo < cliente.getCarrinho().getValorCarrinho()) {
                        sc.close();
                        throw new SaldoInsuficienteException("Saldo insuficiente para realizar a compra");
                    }
                    pix.solicitarPagamento();
                    Thread.sleep(3000);
                    pix.efetuarPagamento();
                    System.out.println("Nota fiscal emitida com sucesso!!!");
                    EscritaNotaFiscal escrita = new EscritaNotaFiscal(cliente.getCarrinho(), cliente);
                    String fileNameOut = "notaFiscal.txt";

                    escrita.efetuaEscrita(fileNameOut);
                }
            } else if (Escolha == 3) {
                cliente.getCarrinho().removerItem();
            }

        }
        // estoque.adicionarItem(new Celular("name", valorC, "name2"));
        // estoque.mostrarEstoque();

        // cliente.getCarrinho().adicionarItem(new Celular("name", valorC, "name2"));
        // cliente.getCarrinho().adicionarItem(new Celular("name", valorC, "name2"));
        // cliente.getCarrinho().adicionarItem(new Celular("name", valorC, "name2"));
        // cliente.getCarrinho().adicionarItem(new Notebook("name", valorC, "name2"));
        // cliente.getCarrinho().mostrarCarrinho();

        // EscritaNotaFiscal escrita = new EscritaNotaFiscal(cliente.getCarrinho());
        // String fileNameOut = "notaFiscal.txt";

        // escrita.efetuaEscrita(fileNameOut);
        // int cargo = sc.nextInt();

        // // if (cargo == 1) {
        // System.out.println("Digite seu nome: ");
        // String nomeCliente = sc.next();
        // sc.nextLine();
        // System.out.println("Digite seu email: ");
        // String email = sc.nextLine();
        // System.out.println("Digite sua idade: ");
        // int idade = sc.nextInt();
        // System.out.println("Digite seu numero de telefone: ");
        // int numero = sc.nextInt();
        // System.out.println("Digite seu saldo disponivel para compras: ");
        // int saldo = sc.nextInt();
        // sc.nextLine();
        // Cliente cliente = new Cliente(nomeCliente, idade, email, numero, saldo);
        // System.out.println("Produtos disponiveis: ");
        // estoque.mostrarEstoque();
        // System.out.println("Selecione o produto que deseja adicionar");
        // System.out.println("1 - Celular - 2000,00(preço fixo)");
        // System.out.println("2 - Notebook - 4000,00(preço fixo)");
        // System.out.println("3 - Fone - 400,00(preço fixo)");

        // int numeroProduto = sc.nextInt();
        // while(numeroProduto > 0 && numeroProduto <3)
        // if(numeroProduto == 1){
        // System.out.print("Digite o nome do celular: ");
        // String nome = sc.nextLine();
        // sc.nextLine();
        // System.out.print("Digite a marca do celular: ");
        // String marca = sc.nextLine();
        // System.out.println();
        // Celular celular = new Celular(nome, valorC, marca);
        // cliente.getCarrinho().adicionarItem(celular);
        // cliente.getCarrinho().mostrarCarrinho();
        // } else if(numeroProduto == 2){

        // } else if(numeroProduto == 3){

        // } else {
        // System.out.println("ERRO");
        // }
        // }
        // // ADICIONAR //
        // if (cargo == 2) {
        // Gerente gerente = new Gerente("Victor", "dezoito", "vriosdantas@gmail.com",
        // 99854776, 180305);
        // System.out.println("---------GERENCIAMENTO DE ESTOQUE---------");
        // System.out.println("Qual produto vc deseja adicionar?");
        // System.out.println("1 - Celular");
        // System.out.println("2 - Notebook");
        // System.out.println("3 - Fone");
        // System.out.println("x > 3 || x < 1 = ERRO");
        // int numeroProduto = sc.nextInt();
        // if(numeroProduto == 1){
        // Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima
        // geração", "iphone 15", "IOS 17", 560, 15.60);
        // estoque.adicionarItem(celular);
        // System.out.println("Celular adicionado com sucesso!");
        // } else if(numeroProduto == 2){
        // Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição",
        // "Ryzen 7", 16, 1, "Linux");
        // estoque.adicionarItem(notebook);
        // System.out.println("Notebook adicionado com sucesso!");
        // } else if(numeroProduto == 3){
        // Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio
        // xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        // estoque.adicionarItem(fone);
        // System.out.println("Fone adicionado com sucesso!");
        // } else {
        // System.out.println("ERRO");
        // }
        // System.out.println("Estoque atual");
        // estoque.mostrarEstoque();

        // } else if(cargo == 1){
        // System.out.println("Digite seu saldo");
        // double saldo = sc.nextDouble();
        // Cliente cliente = new Cliente("Victor", "dezoito", "vriosdantas@gmail.com",
        // 99854776 ,saldo);
        // System.out.println("---------COMPRAS NA LOJA---------");
        // System.out.println("Qual produto vc deseja adicionar no carrinho?");
        // System.out.println("1 - Celular");
        // System.out.println("2 - Notebook");
        // System.out.println("3 - Fone");
        // System.out.println("x > 3 || x < 1 = ERRO");

        // int numeroProduto = sc.nextInt();
        // if(numeroProduto == 1){
        // Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima
        // geração", "iphone 15", "IOS 17", 560, 15.60);
        // cliente.getCarrinho().adicionarItem(celular);
        // System.out.println("Celular adicionado com sucesso!");
        // } else if(numeroProduto == 2){
        // Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição",
        // "Ryzen 7", 16, 1, "Linux");
        // cliente.getCarrinho().adicionarItem(notebook);
        // System.out.println("Notebook adicionado com sucesso!");
        // } else if(numeroProduto == 3){
        // Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio
        // xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        // cliente.getCarrinho().adicionarItem(fone);
        // System.out.println("Fone adicionado com sucesso!");
        // } else {
        // System.out.println("ERRO");
        // }

        // }

        // // REMOVER //
        // if (cargo == 2) {
        // Gerente gerente = new Gerente("Victor", "dezoito", "vriosdantas@gmail.com",
        // 99854776, 180305);
        // System.out.println("---------GERENCIAMENTO DE ESTOQUE---------");
        // System.out.println("Deseja remover algo do estoque?");
        // System.out.println("1 - Celular");
        // System.out.println("2 - Notebook");
        // System.out.println("3 - Fone");
        // System.out.println("x > 3 || x < 1 = NÃO");
        // int numeroProduto = sc.nextInt();
        // if(numeroProduto == 1){
        // Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima
        // geração", "iphone 15", "IOS 17", 560, 15.60);
        // estoque.removerItem(celular);
        // System.out.println("Celular removido com sucesso!");
        // } else if(numeroProduto == 2){
        // Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição",
        // "Ryzen 7", 16, 1, "Linux");
        // estoque.removerItem(notebook);
        // System.out.println("Notebook removido com sucesso!");
        // } else if(numeroProduto == 3){
        // Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio
        // xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        // estoque.removerItem(fone);
        // System.out.println("Fone removido com sucesso!");
        // } else {
        // System.out.println("");
        // }

        // } else if(cargo == 1){
        // System.out.println("Digite seu saldo");
        // double saldo = sc.nextDouble();
        // Cliente cliente = new Cliente("Victor", "dezoito", "vriosdantas@gmail.com",
        // 99854776 ,saldo);
        // System.out.println("---------COMPRAS NA LOJA---------");
        // System.out.println("Deseja remover algo do estoque?");
        // System.out.println("1 - Celular");
        // System.out.println("2 - Notebook");
        // System.out.println("3 - Fone");
        // System.out.println("x > 3 || x < 1 = NÃO");

        // int numeroProduto = sc.nextInt();
        // if(numeroProduto == 1){
        // Produto celular = new Celular("celular", 2000.00, "Apple", "Celular de ultima
        // geração", "iphone 15", "IOS 17", 560, 15.60);
        // cliente.getCarrinho().removerItem(celular);
        // System.out.println("Celular removido com sucesso!");
        // } else if(numeroProduto == 2){
        // Produto notebook = new Notebook("Notebook", 4560.00, "Dell", "Descrição",
        // "Ryzen 7", 16, 1, "Linux");
        // cliente.getCarrinho().removerItem(notebook);
        // System.out.println("Notebook removido com sucesso!");
        // } else if(numeroProduto == 3){
        // Produto fone = new FoneDeOuvido("Fone", 60.00, "Xiaomi","Fone sem fio
        // xiaomi", "Bluetooth", "Sem fio", true, "Branco");
        // cliente.getCarrinho().removerItem(fone);
        // System.out.println("Fone removido com sucesso!");
        // } else {
        // System.out.println("");
        // }
        // }

        sc.close();
    }
}