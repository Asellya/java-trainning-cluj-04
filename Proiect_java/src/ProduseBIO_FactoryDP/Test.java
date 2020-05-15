package ProduseBIO_FactoryDP;
import java.util.Scanner;
/*Aici doar testez clasele si metodele.*/
public class Test {
    public static void main(String[] args) {

      FabricaBio fabrica = new FabricaBio();
      System.out.println("Introduceti numele produsului");
      Scanner input = new Scanner(System.in);
      String tipProdus = input.nextLine();
      ProdusBIO pb = fabrica.getProdus(tipProdus);
      System.out.println("Pretul produsului este: "+pb.calculeazaPretVanzare(pb.getPretProductie(),pb.getRabat()));


    }
}
