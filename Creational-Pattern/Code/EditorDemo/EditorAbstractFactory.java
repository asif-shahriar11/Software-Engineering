package EditorDemo;

public abstract class EditorAbstractFactory {
    abstract Parser getParser(String fileName);
    abstract Font getFont(String fileName);
}
