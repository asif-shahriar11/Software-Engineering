package QMS;

public class PackageFactory extends QMSAbstractFactory {
    @Override
    Package getPackage(String packageName, int numOfDisplayUnits, String communicationMode) {
        if(packageName.equalsIgnoreCase("Deluxe"))  return new Deluxe(numOfDisplayUnits, communicationMode);
        else if(packageName.equalsIgnoreCase("Optimal"))  return new Optimal(numOfDisplayUnits, communicationMode);
        else if(packageName.equalsIgnoreCase("Poor"))  return new Poor(numOfDisplayUnits, communicationMode);

        return null;
    }
}
