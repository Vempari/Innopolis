package part.lesson;

import org.junit.Test;

import java.io.IOException;

public class GameOfLifeMonoTest {
    @Test
    public void generationStep() throws IOException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        Buffer buffer = new Buffer();
        IOFile file = buffer.getFile();
        GameOfLifeMono life =
                new GameOfLifeMono(file.getLength(), file.getWidth(), file.getSteps(), file.getField());
        life.generationStep();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println(file.toString());
    }

    @Test
    public void generationStep2() throws IOException, ClassNotFoundException, InterruptedException {
        long start = System.currentTimeMillis();
        Buffer buffer = new Buffer();
        IOFile file = buffer.getFile();
        GameOfLifeThreads life =
                new GameOfLifeThreads(file.getLength(), file.getWidth(), file.getSteps(), file.getField());
        life.generationStep();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println(file.toString());

    }
}
