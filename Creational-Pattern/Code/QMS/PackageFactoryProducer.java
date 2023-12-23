package QMS;

public class PackageFactoryProducer {
    public static QMSAbstractFactory getFactory() { return new PackageFactory(); }
}
