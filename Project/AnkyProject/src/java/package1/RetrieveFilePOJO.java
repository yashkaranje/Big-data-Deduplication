package package1;

public class RetrieveFilePOJO {
    public String sentenceInFile; 
    public int indexOfSentence; 

    public RetrieveFilePOJO(String sentenceInFile, int indexOfSentence) { 
        this.sentenceInFile = sentenceInFile; 
	this.indexOfSentence = indexOfSentence; 
    } 

    public String getSentenceInFile() {
        return sentenceInFile;
    }

    public void setSentenceInFile(String sentenceInFile) {
        this.sentenceInFile = sentenceInFile;
    }

    public int getIndexOfSentence() {
        return indexOfSentence;
    }

    public void setIndexOfSentence(int indexOfSentence) {
        this.indexOfSentence = indexOfSentence;
    } 
    
    @Override
    public String toString() {
        return this.indexOfSentence + " " + this.sentenceInFile; 
    }
}
