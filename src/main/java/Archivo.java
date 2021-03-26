import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class Archivo {
    private PDDocument doc;
    private File file;

    public Archivo(String path){
        this.file =  new File(path);
    }

    public String obtenerTexto(){
        String text = "";
        try{
            doc = PDDocument.load(file);
            text = new PDFTextStripper().getText(doc);
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        return text;
    }

    public String obtenerPath() {
        return file.getAbsolutePath();
    }
}
