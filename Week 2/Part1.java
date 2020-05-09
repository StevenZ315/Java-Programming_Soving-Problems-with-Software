
/**
 * Write a description of Part1 here.
 * 
 * @author (StevenZ) 
 * @version (05/06/20)
 */
public class Part1 {
    String findSimpleGene (String dna) {
        int startIdx = dna.indexOf("ATG");
        if (startIdx == -1) {
            return "";
        }
        int endIdx = dna.indexOf("TAA", startIdx+3);
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
            "ATCGTA"
        };
        
        for (String s: testCases) {
            System.out.println("\nOriginal string: " + s);
            System.out.println("DNA string: " + findSimpleGene(s));
        }
    }
}

