
/**
 * Write a description of Part3 here.
 * 
 * @author (StevenZ) 
 * @version (05/09/20)
 */
public class Part3 {
    boolean twoOccurrences (String stringa, String stringb) {
        int lengtha = stringa.length();
        int lengthb = stringb.length();
        int index1 = -1;
        int index2 = -1;
        index1 = stringb.indexOf(stringa);
        if (index1 + lengtha < lengthb) {
            index2 = stringb.indexOf(stringa, index1+lengtha);
        }
        if (index1 != -1 && index2 != -1) {
            return true;
        } else {
            return false;
        }
    }
    String lastPart(String stringa, String stringb) {
        int lengtha = stringa.length();
        int occurIdx = stringb.indexOf(stringa);
        if (occurIdx == -1) {
            return stringb;
        }
        else {
            return stringb.substring(occurIdx+lengtha);
        }
    }
    void testing () {
        String[] testCaseA = {
            "a",
            "aa",
            "ab",
            "",
            "a"
        };
        String[] testCaseB = {
            "abcaf",
            "aaa",
            "afcgfeab",
            "acfed",
            ""
        };
        
        System.out.println("\nTest twoOccurences:");
        for (int i=0; i < testCaseA.length; i++) {
            System.out.println("String A: " + testCaseA[i]);
            System.out.println("String B: " + testCaseB[i]);
            System.out.println("Two Occurance: " + twoOccurrences(testCaseA[i], testCaseB[i]));
        }
        System.out.println("\nTest lastPart:");
        for (int i=0; i < testCaseA.length; i++) {
            System.out.println("The part of string after " 
                                + testCaseA[i]
                                + " in " + testCaseB[i]
                                + " is " + lastPart(testCaseA[i], testCaseB[i])
                                );
        }
    }
    
}
