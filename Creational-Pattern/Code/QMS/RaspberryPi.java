package QMS;

public class RaspberryPi implements Processor {

    @Override
    public String getProcessorName() { return "Raspberry Pi"; }

    @Override
    public double getPrice() { return 200.0; }
}
