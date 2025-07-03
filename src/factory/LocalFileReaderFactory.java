package factory;

import src.factory.DocumentReader;

public class LocalFileReaderFactory extends factory.DocumentReaderFactory {
    @Override
    public DocumentReader createReader(String source) {
        // Crea lector para archivos locales
        return new factory.LocalFileReader(source);
    }
}

public class S3ReaderFactory extends factory.DocumentReaderFactory {
    @Override
    public DocumentReader createReader(String source) {
        // Crea lector para archivos en S3
        return new S3Reader(source);
    }
}

