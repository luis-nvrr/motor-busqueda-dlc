import java.util.Hashtable;

public class StopWord {
    private Hashtable<String, String> stopWord;

    public StopWord(){
        this.stopWord = new Hashtable<>();
    }

    public void agregarStopWord(String stopWord){
        this.stopWord.put(stopWord, stopWord);
    }

    public Boolean esStopWord(String termino){
        String recuperado = this.stopWord.get(termino);
        if(recuperado == null) { return false; }
        return true;
    }
}
