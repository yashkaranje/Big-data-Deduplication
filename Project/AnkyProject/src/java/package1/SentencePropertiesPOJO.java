package package1;

public class SentencePropertiesPOJO {
    static boolean isDup;
    static int belongingClusterNumber;

    public SentencePropertiesPOJO() {
        
    }

    public static boolean getIsDup() {
        return isDup;
    }

    public static void setIsDup(boolean isDup) {
        SentencePropertiesPOJO.isDup = isDup;
    }

    public static int getBelongingClusterNumber() {
        return belongingClusterNumber;
    }

    public static void setBelongingClusterNumber(int belongingClusterNumber) {
        SentencePropertiesPOJO.belongingClusterNumber = belongingClusterNumber;
    }
            
    public static void main(String[] args) {
//        System.out.println(isDup);
//        System.out.println(belongingClusterNumber);
    }
}
