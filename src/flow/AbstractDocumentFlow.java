package flow;

import factory.DocumentReader;
import factory.DocumentReaderFactory;
import model.DocumentJob;
import service.DocumentProcessorService;

public abstract class AbstractDocumentFlow implements DocumentProcessorService {
    protected DocumentReaderFactory readerFactory;

    public AbstractDocumentFlow(DocumentReaderFactory factory) {
        this.readerFactory = factory;
    }

    @Override
    public final void processDocument(DocumentJob job) {
        // Patrón Template Method: define el flujo y delega pasos específicos
        byte[] data = fetchDocument(job); // paso concreto
        validate(job, data);              // paso común
        byte[] converted = convert(job, data);
        store(job, converted);
    }

    // Paso variable: cada flujo implementa su propia fuente
    protected abstract byte[] fetchDocument(DocumentJob job);

    protected void validate(DocumentJob job, byte[] data) {
        // Validación de usuario y formato (común)
        if (job.getRequestingUser() == null) {
            throw new RuntimeException("Usuario nulo");
        }
        // Otras validaciones...
    }

    protected byte[] convert(DocumentJob job, byte[] data) {
        // Lógica de conversión común según outputFormat
        if ("PDF".equals(job.getOutputFormat())) return new byte[100];
        else return new byte[50];
    }

    protected void store(DocumentJob job, byte[] converted) {
        // Guardado común usando clase LegacyArchiver
        LegacyArchiver arch = new LegacyArchiver();
        arch.save(converted, "archive/" + job.getUserEmail());
    }
}

