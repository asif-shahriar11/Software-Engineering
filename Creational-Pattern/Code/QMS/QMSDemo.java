package QMS;

import java.util.LinkedList;
import java.util.Scanner;

/** Driver **/
public class QMSDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your package.");
        System.out.println("Deluxe (Raspberry Pi + LCD Panel) ... press 1");
        System.out.println("Optimal (Arduino Mega + LED Matrix) ... press 2");
        System.out.println("Poor (ATMega32 + LED Matrix) ... press 3");
        int choice = input.nextInt();
        input.nextLine();
        String packageChoice;
        if(choice == 1) packageChoice = "Deluxe";
        else if(choice == 2) packageChoice = "Optimal";
        else packageChoice = "Poor";

        System.out.println("Enter number of display units : ");
        int dUnits = input.nextInt();
        input.nextLine();

        System.out.println("Enter communication mode.");
        System.out.println("WiFi ... press 1");
        System.out.println("Mobile Data ... press 2");
        choice = input.nextInt();
        input.nextLine();
        String comChoice;
        if(choice == 1) comChoice = "WiFi";
        else comChoice = "MobileData";


        QMSAbstractFactory qmsAbstractFactory = PackageFactoryProducer.getFactory();

        Package qmsPackage = qmsAbstractFactory.getPackage(packageChoice, dUnits, comChoice);

        //PackageFactory pf = new PackageFactory();
        //Package qmsPackage = pf.getPackage(packageChoice, dUnits, comChoice);

        Director director = new Director();
        director.construct(qmsPackage);

        QueueManagementSystem qms = qmsPackage.getSystem();
        System.out.println("Total cost : " + qms.getCost());
        qms.systemDescription();


        input.close();

    }
}
