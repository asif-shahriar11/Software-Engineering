package QMS;

public class WiFi implements CommunicationSystem {

    @Override
    public void communicationMethod() {
        System.out.println("Communicates with base station via WiFi module");
    }

    @Override
    public double getPrice() { return 100.0; }

    @Override
    public double getYearlyCommunicationCost() { return 1000.0; }
}
