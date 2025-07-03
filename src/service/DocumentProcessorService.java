package service;

import model.DocumentJob;

public interface DocumentProcessorService {
    void processDocument(DocumentJob job);
}