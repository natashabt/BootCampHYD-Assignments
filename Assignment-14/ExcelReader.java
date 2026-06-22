package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
		public static XSSFSheet getSheet() throws IOException {

			File src = new File("C:\\CoforgeBootCampTesting\\ExternalDocuments\\EasyCalculationRegistrationData.xlsx");

			FileInputStream fis = new FileInputStream(src);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheetAt(0);

			return sheet;
			}
		}
