package QMS;

public class Poor implements Package {
    private final QueueManagementSystem system;
    private final int numOfDisplayUnits;
    private final String communicationMode;

    Poor(int numOfDisplayUnits, String communicationMode) {
        system = new QueueManagementSystem();
        this.numOfDisplayUnits = numOfDisplayUnits;
        this.communicationMode = communicationMode;
    }

    @Override
    public void addProcessor() {
        for(int i=0; i<numOfDisplayUnits; i++)  system.addProcessor(new ATMega32()); }

    @Override
    public void addDisplaySystem() {
        for(int i=0; i<numOfDisplayUnits; i++)  system.addDisplaySystem(new LEDMatrix());
    }

    @Override
    public void addControlApplication() { system.addControlApplication(new ControlApplication()); }

    @Override
    public void addCommunicationSystem() {
        if(communicationMode.equalsIgnoreCase("WiFi")) system.addComSystem(new WiFi());
        else if(communicationMode.equalsIgnoreCase("MobileData")) system.addComSystem(new MobileData());
    }

    @Override
    public QueueManagementSystem getSystem() { return system; }
}
