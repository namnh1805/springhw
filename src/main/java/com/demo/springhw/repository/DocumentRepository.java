package com.demo.springhw.repository;

import com.demo.springhw.entity.Document;
import com.demo.springhw.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document>findByDocumentName(String name);

    Document findById(long id);
}