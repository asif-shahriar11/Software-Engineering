package EditorDemo;

import java.util.Scanner;
public class EditorDemo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter filename with extension : ");
        String filename = input.nextLine();

        try {
            String extension = filename.substring(filename.indexOf('.')+1);
            EditorAbstractFactory editorAbstractFactory = EditorFactoryProducer.getFactory("Parser");
            assert editorAbstractFactory != null;
            Parser parser = editorAbstractFactory.getParser(extension);
            editorAbstractFactory = EditorFactoryProducer.getFactory("Font");
            assert editorAbstractFactory != null;
            Font font = editorAbstractFactory.getFont(extension);
            parser.showParser();
            font.showFont();
        } catch (Exception e) {
            System.out.println("File name not of correct format.");
        }

        input.close();

    }
}