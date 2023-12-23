package EditorDemo;

public class EditorFactoryProducer {
    private static EditorFactoryProducer instance = null;
    private EditorFactoryProducer(){

    }
    public EditorFactoryProducer getInstance()  {
        if (instance == null)   {
            instance = new EditorFactoryProducer();
        }
        return instance;
    }
    public static EditorAbstractFactory getFactory(String choice) {
        if(choice.equalsIgnoreCase("Parser")) return new ParserFactory();
        else if (choice.equalsIgnoreCase("Font"))   return new FontFactory();
        return null;
    }
}
