import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Problem11_Excel {
	
	public static void townsSorter(ArrayList<String> towns){  // this is the method used to sort the "towns" list
		Collections.sort(towns, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
	}

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(new File("Incomes-Report.xlsx")); // opening the file
				             
        XSSFWorkbook myWorkBook = new XSSFWorkbook (file); // initializing the file
       
        XSSFSheet mySheet = myWorkBook.getSheetAt(0); // getting the specific sheet (there's only one here :) )
        
        Iterator<Row> rowIterator = mySheet.iterator(); // initializing iterator from the library
        
        ArrayList<BigDecimal> totals = new ArrayList<BigDecimal>(); // initializing arraylist to keep the incomes
        ArrayList<String> towns = new ArrayList<String>(); // arraylist for the towns
        
        while (rowIterator.hasNext()) { // while there are rows left in the file
            Row row = rowIterator.next();  // current row
            if(row.getRowNum()==0){  // checking if it is the first row - no data there ;)
            	   continue;
            	  }
            else{
            	String town = row.getCell(0).toString(); // getting the text value for "town" from the first cell
            	BigDecimal value = new BigDecimal(row.getCell(5).getNumericCellValue()); // getting the numeric value from the last cell
            	
            	if (!towns.contains(town)){  //checking if the town is already in the "towns" list
	              	towns.add(town); // adding the new town
	              	townsSorter(towns);  // sorting the list after adding new town
	              	totals.add(towns.indexOf(town),value);  // adding the income at the same index as the town in the incomes list
	            }
            	else{
            		BigDecimal oldValue = totals.get(towns.indexOf(town)); // getting the oldValue for the "town"
            		totals.set(towns.indexOf(town), oldValue.add(value)); // setting the new one by adding to the old
            	}
            }
        }
            	        
        for (String twn: towns){
        	System.out.printf("%s Total -> %.2f\n",twn,totals.get(towns.indexOf(twn))); //printing each town with its subtotal
        }
        BigDecimal grandTotal = new BigDecimal("0"); // variable to keep the grand total
        for (BigDecimal total: totals){
        	grandTotal = grandTotal.add(total);   // counting the grand total
        }
        System.out.printf("Grand Total -> %.2f\n",grandTotal); // printing it
        myWorkBook.close();
        file.close();
	}
}