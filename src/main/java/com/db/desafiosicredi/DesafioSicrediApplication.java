package com.db.desafiosicredi;

import com.db.desafiosicredi.service.ProcessaArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioSicrediApplication implements CommandLineRunner {

    @Autowired
    ProcessaArquivoService processaArquivoService;

    public static void main(String[] args) {
        SpringApplication.run(DesafioSicrediApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(args.length > 0) {
            processaArquivoService.processarArquivo(args[0]);
        }
    }
}
