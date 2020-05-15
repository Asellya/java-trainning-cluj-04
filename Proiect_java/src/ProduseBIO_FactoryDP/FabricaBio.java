package ProduseBIO_FactoryDP;
/*Avem o fabrica de produse bio. Fabrica creaza doua tipuri de produse bio
* salata bio iaurt bio.
* Vom folosi aceasta clasa pentru a crea produse bio in functie de input-ul utilizatorului si nu constructorii
* fiecare clase.*/
public class FabricaBio {
    public ProdusBIO getProdus(String tipProdus){

        if(tipProdus.equalsIgnoreCase("IaurtBIO")){
            return new IaurtBIO();
        }
        else if(tipProdus.equalsIgnoreCase("SalataBIO")){
            return new SalataBio();
        }
        return null;
    }
}
