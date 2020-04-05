import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MyThreadReader extends Thread {
    final private ReadWriteLock lock;
    final private String fileName;

    public MyThreadReader(ReadWriteLock lock, String fileName) {
        this.lock = lock;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        while (true) {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
