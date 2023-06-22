import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDemo {


    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook;
        XSSFSheet sheet;

        FileInputStream fis = new FileInputStream("C:\\Users\\amayra\\Desktop\\SeleniumFrameworkPractice\\Book1.xlsx");

        workbook= new XSSFWorkbook(fis);

        sheet= workbook.getSheetAt(0);

        int totalrows= sheet.getLastRowNum() +1;
        int totalcolumn= sheet.getRow(0).getLastCellNum();
        System.out.println("Total Rows are "+totalrows);//Indexing Starts from 0 
        System.out.println("Total Columns are "+totalcolumn);//Indexing Starts From 0 but method returns +1

//
//        for (int currentrow = 0; currentrow <totalrows ; currentrow++) {
//
//            for (int currentcoloumn = 0; currentcoloumn < totalcolumn ; currentcoloumn++) {
//
//                System.out.print(sheet.getRow(currentrow).getCell(currentcoloumn).toString());
//                System.out.print("\t");
//
//            }
//            System.out.println();
//        }


        for (int currentrow = 1; currentrow <totalrows ; currentrow++) {


            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.facebook.com/login/");
            driver.findElement(By.id("email")).sendKeys(sheet.getRow(currentrow).getCell(0).toString());
            driver.findElement(By.id("pass")).sendKeys(sheet.getRow(currentrow).getCell(1).toString());
            driver.quit();


        }


    }
}
