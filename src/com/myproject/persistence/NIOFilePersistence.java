package com.myproject.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;

public class NIOFilePersistence implements FilePersistence {

    // Use File.separator para compatibilidade entre Windows e Linux

    // Retorna o diretório atual do projeto
    private final String currentDir = System.getProperty("user.dir") + File.separator;

    // Armazenar os arquivos que vamos gerenciar
    private final String storedDir = "managedFiles" + File.separator + "NIO" + File.separator;
    private final String fileName;
    private final String fullPath;

    public NIOFilePersistence(String fileName) throws IOException {

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
    public String findAll() {

        var content = new StringBuilder();

        try (
                var file = new RandomAccessFile(new File(fullPath), "r");
                var channel = file.getChannel();) {
            var buffer = ByteBuffer.allocate(256);
            var bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return content.toString();
    }

    @Override
    public String findBy(String sentece) {

        var content = new StringBuilder();

        try (
                var file = new RandomAccessFile(new File(fullPath), "r");
                var channel = file.getChannel();) {
            var buffer = ByteBuffer.allocate(256);
            var bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    while (!content.toString().endsWith(System.lineSeparator())) {
                        content.append((char) buffer.get());
                    }
                    if (content.toString().contains(sentece)) {
                        break;
                    } else {
                        content.setLength(0);
                    }
                    if (!content.isEmpty())
                        break;
                }
                buffer.clear();
                bytesRead = channel.read(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return content.toString();
    }

    private List<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
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

    @Override
    public String write(String data) {
        try (
                var file = new RandomAccessFile(new File(fullPath), "rw")) {
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

}
