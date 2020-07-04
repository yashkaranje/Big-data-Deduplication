package package1;

import java.io.*;
import java.util.*;

public class Heap {
    PriorityQueue<RetrieveFilePOJO> pq = null;
    
    public Heap() {
        pq = new PriorityQueue<RetrieveFilePOJO>(new RetrieveFileComparator());
    }
    
    boolean doShowHeap(String opFileName) throws FileNotFoundException {
        try{
            PrintWriter out = new PrintWriter(new FileOutputStream("C:\\DRIVE\\NBN SSOE\\BE\\BE Project\\Implementation\\Chunking\\Download\\" + opFileName), true);
            System.out.println("begin pq printing");
            System.out.println(pq);
            System.out.println("end pq printing");
            while (!pq.isEmpty()) { 
    //            System.out.println(pq.poll().getSentenceInFile());            
                out.println(pq.poll().getSentenceInFile());
    //            System.out.println(pq);
            }
            System.out.println("File created successfully @C:\\DRIVE\\NBN SSOE\\BE\\BE Project\\Implementation\\Chunking\\Download\\" + opFileName);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    void doInsertIntoHeap(String str, int index){
        pq.add(new RetrieveFilePOJO(str, index));
    }
    
    public static void main(String[] args) throws FileNotFoundException{ 
//        Heap heapObj = new Heap();
//        heapObj.doInsertIntoHeap("Nan", 2);
//        heapObj.doInsertIntoHeap("An", 1);
//        heapObj.doInsertIntoHeap("Pal", 4);
//        heapObj.doInsertIntoHeap("Yash", 3);
//        heapObj.doInsertIntoHeap("Hole", 5);
//        heapObj.doShowHeap("opFileName.txt");
    }
}

class RetrieveFileComparator implements Comparator<RetrieveFilePOJO> {
    public int compare(RetrieveFilePOJO o1, RetrieveFilePOJO o2) { 
        if (o1.indexOfSentence < o2.indexOfSentence) 
            return -1; 
	else if (o1.indexOfSentence > o2.indexOfSentence) 
            return 1; 
	return 0; 
    }
}













