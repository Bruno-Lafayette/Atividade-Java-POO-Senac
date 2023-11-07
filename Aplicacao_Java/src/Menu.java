import java.util.Scanner;

public class Menu {
    private String opcoes = """
            -------------------------------------
            Selecione a opção desejada:
            -------------------------------------
           
            1. Adicionar um veículo
            2. Verificar os veículos adicionados
            3. Sair

            -------------------------------------

            """;
    private Integer entradaUsuario = 0;
    private Colecao colecao = new Colecao();
    
    public Menu() {
    }


    public String getOpcoes() {
        return this.opcoes;
    }

    public void mostrarMenu(){
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println(opcoes);

            while (entradaUsuario != 3) {
                System.out.println("Digite sua escolha: ");
                entradaUsuario = entrada.nextInt();
                switch (entradaUsuario) {
                    case 1:
                        colecao.addVeiculoColecao(coletarInfVeiculo());
                        
                        System.out.println("Adicionando veiculo....\n");
                        System.out.println("Veiculo adicionando com sucesso\n");
                        break;

                    case 2:
                        colecao.mostrarColecao();
                        break;
                
                    default:
                        break;
                }
                System.out.println(opcoes);

            }
        }
    }

    private Veiculo coletarInfVeiculo(){
        String placa = confirmarEntradaUsuario("Digite a placa do veículo");
        String marca = confirmarEntradaUsuario("Digite a marca do veículo");
        String modelo = confirmarEntradaUsuario("Digite o modelo do veículo");
        String cor = confirmarEntradaUsuario("Digite a cor do veículo");
        Float velocidade = Float.valueOf(confirmarEntradaUsuarioNumero("Digite a velocidade máxima do veículo"));
        Integer rodas = Integer.valueOf(confirmarEntradaUsuarioNumero("Digite a quantidade de rodas do veículo"));
        Veiculo cadastroVeiculo = new Veiculo(placa, marca, modelo, cor, velocidade , rodas, null);
        return cadastroVeiculo;
    }

    private String confirmarEntradaUsuario(String menssagem){
        Scanner entrada = new Scanner(System.in); 
            System.out.println(menssagem);
            String respostaUsuario = entrada.nextLine();
            while (respostaUsuario == "") {
                System.out.println("Resposta inválida, resposta deve conter 1 caracter no mínimo, tente novamente:");
                respostaUsuario = entrada.nextLine();
            }
            return respostaUsuario;
        
    }

    private String confirmarEntradaUsuarioNumero(String menssagem){
        Scanner entrada = new Scanner(System.in); {
            System.out.println(menssagem);
            String respostaUsuario = entrada.nextLine();
            while (respostaUsuario == "") {
                System.out.println("Resposta inválida, resposta deve conter 1 caracter no mínimo, tente novamente:");
                respostaUsuario = entrada.nextLine();
            }
            return respostaUsuario;
        }
    }

    
}
