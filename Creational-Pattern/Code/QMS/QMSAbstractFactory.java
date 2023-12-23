package QMS;

public abstract class QMSAbstractFactory {
    abstract Package getPackage(String packageName, int numOfDisplayUnits, String communicationMode);
}
