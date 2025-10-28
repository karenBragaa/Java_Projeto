package app;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VeiculoFactory factory = new VeiculoFactory();

        System.out.println("Informe o tipo do veiculo: \n- Carro\n- Moto\n");
      
        //Faz a leitura de uma "tipagem" a qual posteriormente decidiremos a regra de negócio;
        String tipoVeiculo = sc.next();

        //Faz a chamada no método make, responsável por "Fabricar" a classe de acordo com tipo; 
        //Aqui decidimos qual regra de negócio vamos seguir;
        Veiculo veiculo = factory.make(tipoVeiculo);

        // Uso do método comum; Chama um método que possui uma regra de negócio de acordo com o tipo "Fabricado";
        veiculo.ligar();

        sc.close();
    }
}

// Classe que decide qual veículo criar
class VeiculoFactory {
    public static final String MOTO = "Moto";
    public static final String CARRO = "Carro";

    //Método tipado para retornar uma Interface do tipo "Veiculo";
    //Fazemos um "switch" na variavel "type" para decidir qual regra de negócio seguir; ou seja, qual classe ser "Fabricada";
    //Se caso for MOTO, é criado uma instância de Moto();
    //Se caso for CARRO, é criado uma instância de Carro();
    //Ambas as classes, implementam a Interface Veiculo;
    public Veiculo make(String type) {
        switch (type) {
            case MOTO: return new Moto();
            case CARRO: return new Carro();
            default: throw new IllegalArgumentException("Tipo inválido: " + type);
        }
    }
}

// Interface comum
// Vale lembrar, que não necessariamente precisa ser uma interface, também podemos ter uma Superclasse e uma Subclasse
interface Veiculo {
    void ligar();
}

// Implementação concreta: Moto
class Moto implements Veiculo {
    @Override
    public void ligar() {
        System.out.println("\nLigando Moto");
    }
}

// Implementação concreta: Carro
class Carro implements Veiculo {
    @Override
    public void ligar() {
        System.out.println("\nLigando Carro");
    }
}
