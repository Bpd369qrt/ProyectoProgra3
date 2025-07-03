package factory;

import src.factory.DocumentReader;

// Patrón Factory Method: delega creación de lectores
public abstract class DocumentReaderFactory {
    public abstract DocumentReader createReader(String source);
}

