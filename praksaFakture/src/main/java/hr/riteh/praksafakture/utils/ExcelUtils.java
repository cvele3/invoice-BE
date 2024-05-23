package hr.riteh.praksafakture.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import hr.riteh.praksafakture.database.entity.InvoiceEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {

    public static ByteArrayInputStream invoicesToExcel(List<InvoiceEntity> invoices){
        String[] COLUMNs = {"Id", "Invoice Date", "Invoice Number", "Invoice Amount", "Customer Username", "Payment Type"};
        try(
            Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Invoices");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            int rowIdx = 1;
            for (InvoiceEntity invoice : invoices) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(invoice.getId());
                row.createCell(1).setCellValue(invoice.getInvoiceDate().toString());
                row.createCell(2).setCellValue(invoice.getInvoiceNumber());
                row.createCell(3).setCellValue(invoice.getInvoiceAmount());
                row.createCell(4).setCellValue(invoice.getCustomerUsername());
                row.createCell(5).setCellValue(invoice.getPaymentType().getType());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
