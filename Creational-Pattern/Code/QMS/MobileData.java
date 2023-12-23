package QMS;

public class MobileData implements CommunicationSystem {

    @Override
    public void communicationMethod() {
        System.out.println("Communicates via SIM card");
    }

    @Override
    public double getPrice() { return 50.0; }

    @Override
    public double getYearlyCommunicationCost() { return 600.0; }
}
