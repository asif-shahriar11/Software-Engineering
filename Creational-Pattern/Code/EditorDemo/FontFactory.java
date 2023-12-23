package EditorDemo;

public class FontFactory extends EditorAbstractFactory {
    @Override
    Parser getParser(String extension) {
        return null;
    }
    @Override
    Font getFont(String extension) {
        if(extension.equalsIgnoreCase("c")) return new CFont();
        else if(extension.equalsIgnoreCase("cpp")) return new CPPFont();
        else if(extension.equalsIgnoreCase("py")) return new PythonFont();
        return null;
    }
}
