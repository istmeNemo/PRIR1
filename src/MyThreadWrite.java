import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;

public class MyThreadWrite extends Thread {
    final private ReadWriteLock lock;
    final private String fileName;

    public MyThreadWrite(ReadWriteLock lock, String fileName) {
        this.lock = lock;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        while (true) {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream.collect(Files);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
