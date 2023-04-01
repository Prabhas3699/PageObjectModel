package com.bridgelabz.util;

import com.bridgelabz.base.BassClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class utility extends BassClass{

    static String testSheetPath="src/main/resources/facbookLoginTestData.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    public static Object[][] Testdata(String sheetName){
        FileInputStream fileInputStream;
        try {
            fileInputStream=new FileInputStream(testSheetPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            workbook= WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet=workbook.getSheet(sheetName);

        Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0;i< sheet.getLastRowNum();i++){
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

    public static void captureScreenshot(){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs((OutputType.FILE));

        File destinationFile = new File("./screenshots/"+System.currentTimeMillis() + "_screenshot.png");

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
