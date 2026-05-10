package com.myproject.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;

public class IOFilePersistence implements FilePersistence {

    // Use File.separator para compatibilidade entre Windows e Linux

    // Retorna o diretório atual do projeto
    private final String currentDir = System.getProperty("user.dir") + File.separator;

    // Armazenar os arquivos que vamos gerenciar
    private final String storedDir = "managedFiles" + File.separator + "IO" + File.separator;
    private final String fileName;
    private final String fullPath;

    public IOFilePersistence(String fileName) throws IOException {

        this.fileName = fileName;
        this.fullPath = currentDir + storedDir + fileName;

        File directory = new File(currentDir + storedDir);

        // Garantimos que as PASTAS existam
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("Erro ao criar os diretórios: " + directory.getAbsolutePath());
            }
        }

        // Agora verificamos o ARQUIVO
        File file = new File(fullPath);
        if (!file.exists()) {
            file.createNewFile(); // Cria o arquivo vazio se não existir
        }

        clearFile();
    }

    private void clearFile() {
        // Usar o bloco try-with-resources para fechar o stream automaticamente
        try (OutputStream outputStream = new FileOutputStream(fullPath)) {
            System.out.printf("Inicializando recursos (%s) \n", fullPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String write(String data) {
        try (
                var fileWriter = new FileWriter(fullPath, true);
                var bufferedWrite = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWrite)) {
            printWriter.println(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {

        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(sentence)))
            return false;

        clearFile();
        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {

        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(oldContent)))
            return "";

        clearFile();
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);
        return newContent;
    }

    private List<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
    }

    @Override
    public String findBy(String sentece) {
        var found = "";
        try (var reader = new BufferedReader(new FileReader(fullPath))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(sentece)) {
                    found = line;
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return found;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(fullPath))) {
            String line;
            do {
                line = reader.readLine();
                if ((line != null))
                    content.append(line)
                            .append(System.lineSeparator());
            } while (line != null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }
}
