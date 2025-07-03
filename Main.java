import proxy.DocumentProcessorProxy;
import service.RealDocumentProcessor;
import service.DocumentProcessorService;
import model.*;

public class Main {
    public static void main(String[] args) {
        User user = new User("juan", "Premium");
        DocumentJob job = new DocumentJob("document.txt", "PDF", "", true, user, "juan@example.com");

        DocumentProcessorService processor = new DocumentProcessorProxy(new RealDocumentProcessor());
        processor.processDocument(job);
    }
}