package dev.gledson;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Aplicacao {


    public static void main(String[] args) throws IOException, InterruptedException {

        String endereco = "https://v6.exchangerate-api.com/v6/9acde6c519f125535d785e8a/latest/USD";
        Scanner scan = new Scanner(System.in);
        double valor;

        double resultado;

        int condicao = 0;

        while (condicao != 7) {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            // System.out.println(json);

            Gson gson = new Gson();

            Moedas moedas = gson.fromJson(json, Moedas.class);
            //System.out.println(moedas);
            //System.out.println("Cotação USD para BRL: " + moedas.getConversion_rates().get("USD"));

            System.out.println("***********************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("***********************************************");

            condicao = scan.nextInt();

            switch (condicao) {
                case 1:
                    System.out.println("Digite o valor que deseja converter");
                    valor = scan.nextDouble();
                    resultado = valor * moedas.getConversion_rates().get("ARS");
                    System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>> " + resultado + " [ARS]");
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja converter");
                    valor = scan.nextDouble();
                    resultado = valor / moedas.getConversion_rates().get("ARS");
                    System.out.println("Valor " + valor + " [ARS] corresponde ao valor final de =>> " + resultado + " [USD]");
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja converter");
                    valor = scan.nextDouble();
                    resultado = valor * moedas.getConversion_rates().get("BRL");
                    System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>> " + resultado + " [BRL]");
                    break;
                case 4:
                    System.out.println("Digite o valor que deseja converter");
                    valor = scan.nextDouble();
                    resultado = valor / moedas.getConversion_rates().get("BRL");
                    System.out.println("Valor " + valor + " [BRL] corresponde ao valor final de =>> " + resultado + " [USD]");
                    break;
                case 5:
                    System.out.println("Digite o valor que deseja converter");
                    valor = scan.nextDouble();
                    resultado = valor * moedas.getConversion_rates().get("COP");
                    System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>> " + resultado + " [COP]");
                    break;
                case 6:
                    System.out.println("Digite o valor que deseja converter");
                    valor = scan.nextDouble();
                    resultado = valor / moedas.getConversion_rates().get("COP");
                    System.out.println("Valor " + valor + " [COP] corresponde ao valor final de =>> " + resultado + " [USD]");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }

    }
}
