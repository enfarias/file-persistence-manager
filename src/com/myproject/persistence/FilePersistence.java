package com.myproject.persistence;

public interface FilePersistence {

    String write(String data);

    boolean remove(String sentence);

    String replace(String oldContent, String newContent);

    String findAll();

    String findBy(String sentece);

}
