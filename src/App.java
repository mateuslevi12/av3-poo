import java.util.Scanner;
import excecao.SaldoInsuficienteException;
import geral.Cartao;
import geral.Celular;
import geral.Cliente;
import geral.Estoque;
import geral.FoneDeOuvido;
import leituraEscrita.LeituraEstoque;
import leituraEscrita.EscritaEstoque;
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
        System.out.println("Cliente = 1/ Funcionario = 2 ?");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.println("--------------------------------------");
            System.out.println("------Seja bem vido a MV IMPORTS------");
            System.out.println("--------------------------------------");
            System.out.print("Digite seu nome: ");
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
            System.out.println("");
            System.out.println("----Esse são os itens disponiveis da nossa loja:-----");
            System.out.println("");
            estoque.mostrarEstoque();
            System.out.println("");
            System.out.println("Deseja adicionar um item ?\n(1 - Sim /2 - Nao /3 - Remover)");
            System.out.print("Digite a operação desejada: ");
            int Escolha = sc.nextInt();
            System.out.println("");

            boolean finalizar = false;

            while (!finalizar) {
                while (Escolha == 1) {
                    System.out.println("----ADIÇÃO DE ITENS----");
                    System.out.println("Selecione o produto que deseja adicionar");
                    System.out.println("1 - Celular");
                    System.out.println("2 - Notebook");
                    System.out.println("3 - Fone De Ouvido");
                    int escolha = sc.nextInt();

                    if (escolha == 1) {
                        System.out.print("Digite o nome do celular: ");
                        String nomeProd = sc.next();
                        sc.nextLine();
                        System.out.print("Digite a marca do celular: ");
                        String marca = sc.next();
                        sc.nextLine();
                        Celular celular = new Celular(nomeProd, valorC, marca, memoria);
                        cliente.getCarrinho().adicionarItem(celular);
                    }

                    else if (escolha == 2) {
                        System.out.print("Digite o nome do notebook: ");
                        String nomeProd = sc.next();
                        sc.nextLine();
                        System.out.print("Digite a marca do notebook: ");
                        String marca = sc.next();
                        sc.nextLine();
                        Notebook notebook = new Notebook(nomeProd, valorN, marca, tela);
                        cliente.getCarrinho().adicionarItem(notebook);
                    }

                    else if (escolha == 3) {
                        System.out.print("Digite o nome do fone: ");
                        String nomeProd = sc.next();
                        sc.nextLine();
                        System.out.print("Digite a marca do fone: ");
                        String marca = sc.next();
                        sc.nextLine();
                        FoneDeOuvido fone = new FoneDeOuvido(nomeProd, valorF, marca, tipo);
                        cliente.getCarrinho().adicionarItem(fone);
                    }
                    System.out.println("O que deseja fazer agora?\n(1 - Adicionar /2 - Finalizar /3 - Remover)");
                    System.out.print("Digite a operação desejada: ");
                    Escolha = sc.nextInt();
                    if (Escolha == 2) {
                        finalizar = true;
                    }
                }

                while (Escolha == 3) {
                    System.out.println("-------------REMOÇÃO DE ITEM-------------");
                    System.out.println("");
                    cliente.getCarrinho().mostrarCarrinho();
                    System.out.println("Escolha o numero do produto a ser removido");
                    int index = sc.nextInt();
                    cliente.getCarrinho().removerItem(index);
                    cliente.getCarrinho().mostrarCarrinho();
                    System.out.println("O que deseja fazer agora?\n(1 - Adicionar /2 - Finalizar /3 - Remover)");
                    System.out.print("Digite a operação desejada: ");
                    Escolha = sc.nextInt();
                    if (Escolha == 2) {
                        finalizar = true;
                    }
                }

            }

            System.out.println("---------------------------------");
            System.out.println("-------------PAGAMENTO-----------");
            System.out.println("---------------------------------");
            cliente.getCarrinho().mostrarCarrinho();

            System.out.println("Selecione a forma de pagamento");
            System.out.println("1 - Cartão de Credito");
            System.out.println("2 - PIX");
            int escolha = sc.nextInt();
            if (escolha == 1) {
                if (saldo < cliente.getCarrinho().getValorCarrinho()) {
                    sc.close();
                    throw new SaldoInsuficienteException("Saldo insuficiente para realizar a compra");
                }
                System.out.print("Insira sua senha: ");
                int senha = sc.nextInt();
                Cartao cartao = new Cartao(cliente.getCarrinho().getValorCarrinho(), senha, cliente);
                cartao.solicitarPagamento();
                Thread.sleep(3000);
                cartao.efetuarPagamento();
                System.out.println("Nota fiscal emitida com sucesso!!!");
                EscritaNotaFiscal escrita = new EscritaNotaFiscal(cliente.getCarrinho(), cliente, cliente.getCarrinho().getValorCarrinho() * 1.2);
                String fileNameOut = "notaFiscal.txt";

                escrita.efetuaEscrita(fileNameOut);

            } else if (escolha == 2) {
                Pix pix = new Pix(cliente.getCarrinho().getValorCarrinho(), cliente);
                pix.solicitarPagamento();
                Thread.sleep(3000);
                pix.efetuarPagamento();
                System.out.println("Nota fiscal emitida com sucesso!!!");
                EscritaNotaFiscal escrita = new EscritaNotaFiscal(cliente.getCarrinho(), cliente, cliente.getCarrinho().getValorCarrinho() * 0.8 );
                String fileNameOut = "notaFiscal.txt";

                escrita.efetuaEscrita(fileNameOut);
            }

        } else if (opcao == 2) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("------Seja bem vido ao gerenciamento do estoque da MV IMPORTS------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("");
            estoque.mostrarEstoque();
            System.out.println("O que deseja fazer no estoque?");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Remover item");
            System.out.println("");
            System.out.println("Selecione a opção: ");
            int escolhendo = sc.nextInt();

            boolean finalizar = false;
            while (!finalizar) {
                while (escolhendo == 1) {
                    System.out.println("------ADIÇÃO DE ITENS AO ESTOQUE------");
                    System.out.println("");
                    System.out.println("Qual dos itens abaixo quer adicionar?");
                    System.out.println("1 - Celular");
                    System.out.println("2 - Notebook");
                    System.out.println("3 - Fone De Ouvido");
                    System.out.println("");
                    System.out.println("Selecione a opção: ");
                    int escolhaProd = sc.nextInt();

                    if (escolhaProd == 1) {
                        System.out.print("Digite o nome do celular: ");
                        String nomeProd = sc.next();
                        sc.nextLine();
                        System.out.print("Digite a marca do celular: ");
                        String marca = sc.next();
                        sc.nextLine();
                        Celular celular = new Celular(nomeProd, valorC, marca, memoria);
                        estoque.adicionarItem(celular);
                    }

                    else if (escolhaProd == 2) {
                        System.out.print("Digite o nome do notebook: ");
                        String nomeProd = sc.next();
                        sc.nextLine();
                        System.out.print("Digite a marca do notebook: ");
                        String marca = sc.next();
                        sc.nextLine();
                        Notebook notebook = new Notebook(nomeProd, valorN, marca, tela);
                        estoque.adicionarItem(notebook);
                    }

                    else if (escolhaProd == 3) {
                        System.out.print("Digite o nome do fone: ");
                        String nomeProd = sc.next();
                        sc.nextLine();
                        System.out.print("Digite a marca do fone: ");
                        String marca = sc.next();
                        sc.nextLine();
                        FoneDeOuvido fone = new FoneDeOuvido(nomeProd, valorF, marca, tipo);
                        estoque.adicionarItem(fone);
                    }
                    System.out.println("");
                    estoque.mostrarEstoque();

                    System.out.print("O que deseja fazer? \n (1 - Adicionar item /2 - Remover item /3 - Finalizar)");
                    System.out.println("");
                    System.out.print("Digite a operação desejada: ");
                    escolhendo = sc.nextInt();
                    if (escolhendo == 3) {
                        finalizar = true;
                    }
                }
                while (escolhendo == 2) {
                    System.out.println("------REMOÇÃO DE ITENS DO ESTOQUE------");
                    System.out.println("");
                    estoque.mostrarEstoque();
                    System.out.println("");
                    System.out.println("Escolha o numero do produto a ser removido");
                    int index = sc.nextInt();
                    estoque.removerItem(index);

                    System.out.print("O que deseja fazer? \n (1 - Adicionar item /2 - Remover item /3 - Finalizar)");
                    System.out.print("Digite a operação desejada: ");
                    escolhendo = sc.nextInt();

                    if (escolhendo == 3) {
                        finalizar = true;
                    }
                }

            }

            System.out.println("");
            System.out.println("---------EDIÇÃO FINALIZADA---------");
            System.out.println("");

            estoque.mostrarEstoque();
            EscritaEstoque escrita = new EscritaEstoque();
            escrita.escreverEstoque(estoque.getItensEstoque(), name);

        }
        sc.close();
    }
}