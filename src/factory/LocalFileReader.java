package factory;

import src.factory.DocumentReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class LocalFileReader implements DocumentReader {
    private final String path;
    public LocalFileReader(String path) { this.path = path; }

    @Override
    public byte[] read() {
        try {
            // Lee bytes desde archivo local
            return Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}

