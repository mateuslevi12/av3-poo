import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem vindo a MV imports!");
        System.out.println("Cliente / Gerente ?");
        String cargo = sc.nextLine();
        if (cargo == "gerente" || cargo == "Gerente") {
            System.out.println("---------GERENCIAMENTO DE ESTOQUE---------");
            System.out.println("Quais produtos vc deseja adicionar?");
            System.out.println("1 - Celular");
            System.out.println("2 - Notebook");
            System.out.println("3 - Fone De Ouvido");
            
        }

        sc.close();
    }
}
