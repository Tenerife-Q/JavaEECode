package Chapter4.Example9;

public class MobileTelephone { 
    SIM sim;
    void setSIM(SIM card) {
        sim = card;
    } 
    long lookNumber(){
        return sim.getNumber();
    }
}
