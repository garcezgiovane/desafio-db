package com.db.desafiosicredi.service;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileNotFoundException;
import java.io.IOException;

@ExtendWith(SpringExtension.class)
class ProcessaArquivoServiceTest {

    @InjectMocks
    ProcessaArquivoService processaArquivoService;

    @Mock
    GeraReceitaCsvService geraReceitaCsvService;

    @Test
    void deveProcessarArquivoComSucessoQuandoEncontrarArquivo() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, InterruptedException {
        processaArquivoService.processarArquivo("src/test/resources/contas.csv");
        Mockito.verify(geraReceitaCsvService, Mockito.times(1)).gravarArquivo(Mockito.anyList());
    }

    @Test
    void deveRetornarExceptionQuandoProcessarArquivoNaoEncontrarArquivo() {
        Assertions.assertThrows(FileNotFoundException.class,
                () -> processaArquivoService.processarArquivo("contas.csv"),
                "Arquivo não encontrado");
    }
}