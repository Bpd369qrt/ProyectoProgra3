package service;

import command.BillingCommand;
import command.Command;
import model.DocumentJob;
import observer.EmailNotifier;
import observer.NotifierSubject;
import observer.SlackNotifier;

public class RealDocumentProcessor implements DocumentProcessorService {
    @Override
    public void processDocument(DocumentJob job) {
        System.out.println("Procesando documento...");

        if (job.getRequestingUser() == null) {
            System.out.println("Usuario no especificado.");
            return;
        }

        byte[] convertedFile = job.getOutputFormat().equals("PDF") ? new byte[100] : new byte[50];

        System.out.println("Documento convertido y archivado.");

        NotifierSubject notifier = new NotifierSubject();
        notifier.addObserver(new EmailNotifier());
        notifier.addObserver(new SlackNotifier());
        notifier.notifyAllObservers("Documento procesado correctamente.");

        Command billing = new BillingCommand(job.getRequestingUser(), job.getOutputFormat());
        billing.execute();
    }
}