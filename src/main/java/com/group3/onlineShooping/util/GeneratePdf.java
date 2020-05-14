package com.group3.onlineShooping.util;

import com.group3.onlineShooping.constants.Constants;
import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.domain.Order;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdf {
    public static ByteArrayInputStream orderReport(List<Order> orders) {
        Order oneOrder = orders.stream().findFirst().get();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        try {
            Font topHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            topHeaderFont.setColor(BaseColor.BLACK);
            topHeaderFont.setSize(16);

            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPTable tableHeader = new PdfPTable(4);
            tableHeader.setWidthPercentage(100);
            tableHeader.setWidths(new int[]{2, 2, 2, 2});

            PdfPCell tableHeaderCell;
            tableHeaderCell = new PdfPCell(new Phrase("Fancy Online Inc.", topHeaderFont));
            tableHeaderCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableHeaderCell.setColspan(3);
            tableHeaderCell.setBorder(0);
            tableHeader.addCell(tableHeaderCell);

            tableHeaderCell = new PdfPCell(new Phrase("RECEIPT", topHeaderFont));
            tableHeaderCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableHeaderCell.setColspan(1);
            tableHeaderCell.setBorder(0);
            tableHeader.addCell(tableHeaderCell);

            PdfPCell shippingAddress;
            shippingAddress = new PdfPCell(new Phrase("Shipping \nAddress", headerFont));
            shippingAddress.setVerticalAlignment(Element.ALIGN_MIDDLE);
            shippingAddress.setHorizontalAlignment(Element.ALIGN_LEFT);
            shippingAddress.setBorder(2);
            tableHeader.addCell(shippingAddress);

            PdfPCell receiptDetail;
            receiptDetail = new PdfPCell(new Phrase("RECEIPT #", topHeaderFont));
            receiptDetail.setVerticalAlignment(Element.ALIGN_MIDDLE);
            receiptDetail.setHorizontalAlignment(Element.ALIGN_RIGHT);
            receiptDetail.setBorder(0);
            tableHeader.addCell(receiptDetail);

            receiptDetail = new PdfPCell(new Phrase(oneOrder.getId().toString(), topHeaderFont));
            receiptDetail.setVerticalAlignment(Element.ALIGN_MIDDLE);
            receiptDetail.setHorizontalAlignment(Element.ALIGN_LEFT);
            receiptDetail.setBorder(0);
            tableHeader.addCell(receiptDetail);


            PdfPTable tableBody = new PdfPTable(4);
            tableBody.setWidthPercentage(100);
            tableBody.setWidths(new int[]{1, 3, 2, 2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("No.", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableBody.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Product Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableBody.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableBody.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Price", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableBody.addCell(hcell);


            BigDecimal totalPrice = new BigDecimal(0);
            Integer index = 0;
            for (Order order : orders) {

                PdfPCell cell;

                for (Item itm : order.getCartItem().getItem()) {
                    BigDecimal price = itm.getProduct().getPrice().multiply(new BigDecimal(itm.getQuantity()));
                    totalPrice = totalPrice.add(price);

                    cell = new PdfPCell(new Phrase((++index).toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableBody.addCell(cell);

                    cell = new PdfPCell(new Phrase(itm.getProduct().getTitle()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableBody.addCell(cell);

                    cell = new PdfPCell(new Phrase(itm.getQuantity().toString()));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableBody.addCell(cell);

                    cell = new PdfPCell(new Phrase(itm.getItemPrice().toString()));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableBody.addCell(cell);

//                    cell = new PdfPCell(new Phrase(String.valueOf(order.getOrderDate().toString())));
//                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                    cell.setPaddingRight(5);
//                    tableBody.addCell(cell);
                }
            }

            hcell = new PdfPCell(new Phrase("Total"));
            hcell.setPaddingLeft(5);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            hcell.setColspan(3);
            tableBody.addCell(hcell);

            hcell = new PdfPCell(new Phrase(totalPrice.toString()));
            hcell.setPaddingLeft(5);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableBody.addCell(hcell);


            Font footerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            footerFont.setColor(BaseColor.BLACK);
            footerFont.setSize(15);

            PdfPTable tableFooter = new PdfPTable(4);
            tableFooter.setWidthPercentage(100);
            tableFooter.setWidths(new int[]{2, 2, 2, 2});

            PdfPCell tableFooterCell;
            tableFooterCell = new PdfPCell(new Phrase("Thank You!", headerFont));
            tableFooterCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableFooterCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableFooterCell.setColspan(3);
            tableFooterCell.setBorder(0);
            tableFooter.addCell(tableFooterCell);

            tableFooterCell = new PdfPCell(new Phrase("Terms & Conditions", headerFont));
            tableFooterCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableFooterCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableFooterCell.setColspan(1);
            tableFooterCell.setBorder(0);
            tableFooter.addCell(tableFooterCell);


            PdfPTable tableSpace = new PdfPTable(1);
            tableSpace.setWidthPercentage(100);
            PdfPCell emptyCell = new PdfPCell(new Phrase("   \n    "));
            emptyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            emptyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            emptyCell.setColspan(1);
            emptyCell.setPadding(10);
            emptyCell.setBorder(0);
            tableSpace.addCell(emptyCell);

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(tableHeader);
            document.add(tableSpace);
            document.add(tableBody);
            document.add(tableSpace);
            document.add(tableSpace);
            document.add(tableFooter);

            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(GeneratePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
