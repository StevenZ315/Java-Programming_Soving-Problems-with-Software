
/**
 * Write a description of ExportData here.
 * 
 * @author StevenZ
 * @version 05/06/20
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData{
    String countryInfo(CSVParser parser, String country){
        String res = new String("NOT FOUND.");
        for (CSVRecord record : parser){
            String myCountry = record.get("Country");
            if (myCountry.contains(country)) {
                res = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
                return res;
            } 
        }
        return res;
    }
    
    void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem)) {
                count ++;
            }
        }
        System.out.println("Number of countries to export " + exportItem + " is " + count);
        return count;
    }
    
    void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            if (record.get("Value (dollars)").length() > amount.length()) {
                System.out.println(record.get("Country") + ": " + record.get("Value (dollars)"));
            }
        }
    }
    
    void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //String res = countryInfo(parser, "Nauru");
        //System.out.println(res);
        
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "cotton", "flowers");
        
        //parser = fr.getCSVParser();
        //numberOfExporters(parser, "cocoa");
        
        //parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
        
    }
    
    public static void main () {
        ExportData e1 = new ExportData();
        e1.tester();
    }
}
