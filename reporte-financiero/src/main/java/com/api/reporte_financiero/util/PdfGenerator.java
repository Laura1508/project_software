package com.api.reporte_financiero.util;

import com.api.reporte_financiero.model.Transaction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Component
public class PdfGenerator {

    public byte[] generate(List<Transaction> incomes, List<Transaction> selfTransfers) {
        try (PDDocument documento = new PDDocument(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            PDPage page = new PDPage(PDRectangle.LETTER);
            documento.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(documento, page);
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);

            // Título
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.showText("Reporte de Transacciones");
            contentStream.newLine();
            contentStream.newLine();

            // Ingresos
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Ingresos Nuevos:");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            for (Transaction tx : incomes) {
                contentStream.showText(tx.getDate() + " - " + tx.getAccountFrom() + "  " +
                        tx.getAccountTo() + " : $" + tx.getAmount());
                contentStream.newLine();
            }

            contentStream.newLine();

            // Autotransferencias
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText("Autotransferencias:");
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            for (Transaction tx : selfTransfers) {
                contentStream.showText(tx.getDate() + " - " + tx.getAccountFrom() + "  " +
                        tx.getAccountTo() + " : $" + tx.getAmount());
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            documento.save(outputStream);
            return outputStream.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error generando PDF con PDFBox: " + e.getMessage(), e);
        }
    }
}
