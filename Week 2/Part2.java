
/**
 * Write a description of Part2 here.
 * 
 * @author (StevenZ) 
 * @version (50/09/20)
 */
public class Part2 {
    String findSimpleGene (String dna, String startCodon, String stopCodon) {
        if (Character.isUpperCase(dna.charAt(0))) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int startIdx = dna.indexOf(startCodon);
        if (startIdx == -1) {
            return "";
        }
        int endIdx = dna.indexOf(stopCodon, startIdx+3);
        if (endIdx == -1) {
            return "";
        }
        if ((endIdx-startIdx)%3 == 0) {
            return dna.substring(startIdx, endIdx+3);
        } else {
            return "";
        }
    }
    void testSimpleGene () {
        String[] testCases = {
            "ATGAGATAA",
            "ATGCGAT",
            "AGCTAA",
            "ATGATAA",
            "ATCGTA",
            "atgagataa"
        };
        
        for (String s: testCases) {
            System.out.println("\nOriginal string: " + s);
            System.out.println("DNA string: " + findSimpleGene(s, "ATG", "TAA"));
        }
    }
}
