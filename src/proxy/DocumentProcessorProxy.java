package proxy;

import model.DocumentJob;
import model.User;
import service.DocumentProcessorService;

public class DocumentProcessorProxy implements DocumentProcessorService {
    private DocumentProcessorService realProcessor;

    public DocumentProcessorProxy(DocumentProcessorService realProcessor) {
        this.realProcessor = realProcessor;
    }

    @Override
    public void processDocument(DocumentJob job) {
        User user = job.getRequestingUser();
        if (job.isHighPriority() && !"Premium".equals(user.getPlan())) {
            System.out.println("Acceso denegado: solo usuarios Premium pueden usar alta prioridad.");
            return;
        }
        realProcessor.processDocument(job);
    }
}