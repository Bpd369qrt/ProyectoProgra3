package src;

import model.DocumentJob;
import model.User;
import proxy.DocumentProcessorProxy;
import service.RealDocumentProcessor;
import service.DocumentProcessorService;

public class Main {
    public static void main(String[] args) {
        User user = new User("juanse", "Premium");
        DocumentJob job = new DocumentJob("document.txt", "PDF", "", true, user, "juan@example.com");

        DocumentProcessorService processor = new DocumentProcessorProxy(new RealDocumentProcessor());
        processor.processDocument(job);
    }
}