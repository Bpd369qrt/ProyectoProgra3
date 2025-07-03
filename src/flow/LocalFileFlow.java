package flow;

import factory.DocumentReaderFactory;
import model.DocumentJob;
import factory.DocumentReader;

public class LocalFileFlow extends flow.AbstractDocumentFlow {
    public LocalFileFlow(DocumentReaderFactory factory) {
        super(factory);
    }

    @Override
    protected byte[] fetchDocument(DocumentJob job) {
        // Crea lector vía factoría y lee
        DocumentReader reader = readerFactory.createReader(job.getSourceFilePath());
        return reader.read();
    }
}
