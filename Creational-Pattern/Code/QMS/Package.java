package QMS;

public interface Package {
    void addProcessor();
    void addDisplaySystem();
    void addControlApplication();
    void addCommunicationSystem();
    QueueManagementSystem getSystem();
}
