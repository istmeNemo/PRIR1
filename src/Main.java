import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        String fileName = "text,txt";
        ReadWriteLock lock = new ReadWriteLock();
        List<Thread> readers = List.of(
                new MyThreadReader(lock,fileName),
                new MyThreadReader(lock,fileName),
                new MyThreadReader(lock,fileName),
                new MyThreadReader(lock,fileName)
        );
        List<Thread> writers = List.of(
                new MyThreadWrite(lock, fileName),
                new MyThreadWrite(lock, fileName)
        );
       // readers.stream().forEach((t)-> lock.registerReader(t));//co to kurna jest?
        writers.stream().forEach((t)->t.start());
        readers.stream().forEach((t)->t.start());
        Thread.sleep(1000);
        writers.stream().forEach(t->t.interrupt());
        readers.stream().forEach(t->t.interrupt());
    }
}
