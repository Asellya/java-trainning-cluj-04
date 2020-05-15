package ProduseBIO_FactoryDP;

public class IaurtBIO extends ProdusBIO {
    IaurtBIO(){
        setPretProductie(5);
        setRabat(0.1);
    }
    @Override
    public double calculeazaPretVanzare(double pretProductie, double rabat) {
        double pretVanzare = pretProductie - pretProductie * rabat;
        return pretVanzare;
    }
}
