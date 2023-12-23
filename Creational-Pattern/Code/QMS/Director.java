package QMS;

public class Director {
    public void construct(Package qmsPackage) {
        qmsPackage.addProcessor();
        qmsPackage.addDisplaySystem();
        qmsPackage.addControlApplication();
        qmsPackage.addCommunicationSystem();
    }
}
