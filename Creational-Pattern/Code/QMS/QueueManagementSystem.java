package QMS;

import java.util.LinkedList;

public class QueueManagementSystem {

    private LinkedList<Processor> processors;
    private LinkedList<DisplaySystem> displaySystems;
    private LinkedList<ControlApplication> controlApplication;
    private LinkedList<CommunicationSystem> comSystem;

    QueueManagementSystem() {
        processors = new LinkedList<>();
        displaySystems = new LinkedList<>();
        comSystem = new LinkedList<>();
        controlApplication = new LinkedList<>();
    }


    public void addProcessor(Processor p) { processors.add(p); }
    public void addDisplaySystem(DisplaySystem ds) {displaySystems.add(ds); }
    public void addControlApplication(ControlApplication ca) { controlApplication.add(ca); }
    public void addComSystem(CommunicationSystem cs) { comSystem.add(cs); }

    public double getCost() {
        double cost = 0.0;
        for(Processor p:processors) cost += p.getPrice();
        for(DisplaySystem ds:displaySystems) cost += ds.getPrice();
        for(ControlApplication ca:controlApplication) cost += ca.getPrice();
        for(CommunicationSystem cs:comSystem) cost += cs.getPrice() + cs.getYearlyCommunicationCost();

        return cost;
    }

    public void systemDescription() {
        System.out.println("Display units : " + processors.size());
        System.out.println("Processor : "+processors.get(0).getProcessorName() + ", Display System : " + displaySystems.get(0).getDisplayName());
        comSystem.get(0).communicationMethod();
    }
}
