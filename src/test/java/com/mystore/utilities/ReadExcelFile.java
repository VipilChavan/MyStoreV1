package com.mystore.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    public static FileInputStream fileInputStream;
    public static XSSFWorkbook xssfWorkbook;
    public static XSSFSheet xssfSheet;
   // public static XSSFRow xssfRow;
    public static XSSFCell xssfCell;




    public static String getCellValue(String filename, String sheetname, int rowno, int cellno) {
        try {
           fileInputStream = new FileInputStream(filename);
             xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetname);
             xssfCell = xssfSheet.getRow(rowno).getCell(cellno);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return xssfCell.getStringCellValue();
    }


    public static int getRowCount(String filename, String sheetname) {
        try {
            fileInputStream = new FileInputStream(filename);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetname);

            int totalrow = xssfSheet.getLastRowNum();

            return totalrow + 1;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getCellCount(String filename, String sheetname) {
        try {
            fileInputStream = new FileInputStream(filename);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetname);

            int totalcell = xssfSheet.getRow(0).getLastCellNum();

            return totalcell ;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }















}
