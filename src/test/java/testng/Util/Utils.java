package testng.Util;

import Util.Constant.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testng.Method.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Utils {

    private static Workbook createWorkbookToUrl(String filepath) {
        String fileUrl = ResourceLocal.DIRECT_URL_EXCEL;
        if (!filepath.isEmpty()){
            fileUrl = filepath;
        }
        try(Workbook workbook =  WorkbookFactory.create(new FileInputStream(fileUrl))) {
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(Issue.ERROR_IO_EXCEPTION_FILE+"line code 21 Util");
            return null;
        }
    }
    public static List<Account> readWorkBookAccounts(String filepath, Object object, String  sheetName){
        Workbook workbook = createWorkbookToUrl(filepath);
        List<Account> accounts = new ArrayList<>();
        List<String> nameFiledObject = UtilClass.getFieldNamesByClass(object);
        Sheet sheet = workbook.getSheet(sheetName);
         for (Row row:sheet){
             Cell userCell = row.getCell(0);
             Cell passwordCell = row.getCell(1);
             Account account = new Account();
             if (userCell==null) {
                 account.setUserName("");
             }else account.setUserName(userCell.toString());
             if (passwordCell==null) {
                 account.setPassword("");
             }else account.setPassword(passwordCell.toString());
             accounts.add(account);
         }
        return accounts;
    }
    public static boolean writingExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("account");
        sheet.setColumnWidth(0,6000);
        sheet.setColumnWidth(1,6000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = setupCellStyleHeader(workbook,IndexedColors.LIGHT_BLUE.getIndex(),
                                                    FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = setupFont(workbook,"Arial",true,(short) 16);
        headerStyle.setFont(font);

        Cell headerCell = setValueStringCell(header,0,"username");
        headerCell.setCellStyle(headerStyle);

        headerCell = setValueStringCell(header,1,"password");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = setupCellStyleWrapText(workbook);

//        Row row = sheet.createRow(1);
//        Cell cell =setValueStringCell(row,0,"panda.toila@gmail.com");
//        cell.setCellStyle(style);
//
//        cell= setValueStringCell(row,1,"Matkhau@123");
//        cell.setCellStyle(style);
        for (int i =1;i<10;i++){
            String j="";
            if (i!=1) j+=i;
            Row rowFor = sheet.createRow(i);
            if (i!=5){
            Cell cellCheck =setValueStringCell(rowFor,0,"panda.toila@gmail.com"+j);
            cellCheck.setCellStyle(style);
            }

            if (i != 7) {
                Cell cellCheck= setValueStringCell(rowFor,1,"Matkhau@123");
                cellCheck.setCellStyle(style);
            }else {
                Cell cellCheck= setValueStringCell(rowFor,1,"3");
                cellCheck.setCellStyle(style);
            }
        }


        String fileLocation = setupUrlFile("account.xlsx");

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
        return false;
    }

//    public static void main(String[] args) {
//        Account account = new Account();
////        UtilClass.getFieldNamesByClass(account).stream().forEach(System.out::println);
//        try {
//            readWorkBookAccounts(setupUrlFile("account.xlsx"),new Account(),0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static CellStyle setupCellStyleWrapText(Workbook workbook){
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        return cellStyle;
    }
    public static CellStyle setupCellStyleHeader(Workbook workbook,short foregroundColorIndex,FillPatternType patternType){
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(foregroundColorIndex);
        headerStyle.setFillPattern(patternType);
        return headerStyle;
    }
    public static XSSFFont setupFont(Workbook workbook,String fontName, boolean bold,short fontHeight){
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontHeight);
        font.setBold(bold);
        return font;
    }

    public static Cell setValueStringCell(Row row,int indexCell, String valueCell){
        Cell cell = row.createCell(indexCell);
        cell.setCellValue(valueCell);
        return cell;
    }
    public static String setupUrlFile(String nameFile){
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        StringBuilder fileLocation = new StringBuilder(path.substring(0,path.length()-1));
        fileLocation.append("/src/main/resources/");
        fileLocation.append(nameFile);
        return fileLocation.toString();
    }
}
