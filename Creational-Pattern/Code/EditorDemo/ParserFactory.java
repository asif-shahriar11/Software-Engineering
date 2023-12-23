package EditorDemo;

public class ParserFactory extends EditorAbstractFactory {
    @Override
    Parser getParser(String extension) {
        if(extension.equalsIgnoreCase("c")) return new CParser();
        else if(extension.equalsIgnoreCase("cpp")) return new CPPParser();
        else if(extension.equalsIgnoreCase("py")) return new PythonParser();
        return null;
    }
    @Override
    Font getFont(String extension) {
        return null;
    }
}
