package com.db.desafiosicredi.service;

import com.db.desafiosicredi.dto.ContaDTO;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class GeraReceitaCsvService {
    public void gravarArquivo(List<ContaDTO> contasProcessadas) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        try (Writer writer = new FileWriter("/home/user/Documents/file.csv")) {
            StatefulBeanToCsv<ContaDTO> statefulBeanToCsv = new StatefulBeanToCsvBuilder<ContaDTO>(writer)
                    .withSeparator(';')
                    .withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            statefulBeanToCsv.write(contasProcessadas);
        }
    }
}
