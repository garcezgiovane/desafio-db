package com.db.desafiosicredi.service;

import com.db.desafiosicredi.ReceitaService;
import com.db.desafiosicredi.dto.ContaDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class ProcessaArquivoService {

    @Autowired
    GeraReceitaCsvService geraReceitaCsv;

    public void processarArquivo(String fileName) throws IOException, InterruptedException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        List<ContaDTO> contas = carregarContas(fileName);
        atualizarContas(contas);
        geraReceitaCsv.gravarArquivo(contas);
    }

    private List<ContaDTO> carregarContas(String fileName) throws FileNotFoundException {
        try {
            List<ContaDTO> contas = new CsvToBeanBuilder<ContaDTO>(new FileReader(fileName))
                    .withSeparator(';')
                    .withType(ContaDTO.class)
                    .build()
                    .parse();

            formatarNumeroConta(contas);

            return contas;
        } catch (Exception ex) {
            throw new FileNotFoundException("Arquivo não encontrado");
        }
    }

    private static void formatarNumeroConta(List<ContaDTO> contas) {
        contas.forEach(conta -> conta.setConta(conta.getConta().replace("-", "")));
    }

    private void atualizarContas(List<ContaDTO> contas) throws InterruptedException {
        ReceitaService receitaService = new ReceitaService();

        for (ContaDTO conta : contas) {
            conta.setResultado(receitaService.atualizarConta(
                    conta.getAgencia(),
                    conta.getConta(),
                    conta.getSaldo(),
                    conta.getStatus())
            );
        }
    }
}
