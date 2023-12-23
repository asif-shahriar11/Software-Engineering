package QMS;

public class ArduinoMega implements Processor {

    @Override
    public String getProcessorName() { return "Arduino Mega"; }

    @Override
    public double getPrice() { return 150.0; }
}
