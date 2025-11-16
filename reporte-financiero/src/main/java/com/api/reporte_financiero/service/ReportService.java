package com.api.reporte_financiero.service;

import com.api.reporte_financiero.model.Transaction;
import com.api.reporte_financiero.util.CsvReader;
import com.api.reporte_financiero.util.PdfGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ReportService {

        private final CsvReader csvReader;
        private final TransactionClassifier classifier;
        private final PdfGenerator pdfGenerator;

        public ReportService(CsvReader csvReader, TransactionClassifier classifier, PdfGenerator pdfGenerator) {
            this.csvReader = csvReader;
            this.classifier = classifier;
            this.pdfGenerator = pdfGenerator;
        }

        // Procesa el archivo CSV y genera el PDF
        public byte[] processFile(MultipartFile file) {
            try {
                //Lee el archivo que se carga y posteriormente se convierte a una lista de transacciones
                List<Transaction> transactions = csvReader.read(file);

                //Clasifica las transacciones
                List<Transaction> incomes = classifier.filterIncomes(transactions);
                List<Transaction> selfTransfers = classifier.filterSelfTransfers(transactions);

                //Genera el PDF con la información organizada
                return pdfGenerator.generate(incomes, selfTransfers);

            } catch (Exception e) {
                throw new RuntimeException("Error al procesar archivo y generar reporte: " + e.getMessage(), e);
            }
        }
    }