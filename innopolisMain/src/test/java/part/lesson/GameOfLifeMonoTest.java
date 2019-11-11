package part.lesson;

import org.junit.Test;

import java.io.IOException;
import java.sql.Time;

public class GameOfLifeMonoTest {
    @Test
    public void generationStep_() throws IOException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        Buffer buffer = new Buffer();
        IOFile file = buffer.getFile();
        GameOfLifeMono life =
                new GameOfLifeMono(file.getLength(), file.getWidth(), file.getSteps(), file.getField());
        life.generationStep();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    @Test
    public void generationStep_2() throws IOException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        Buffer buffer = new Buffer();
        IOFile file = buffer.getFile();
        GameOfLifeThreads life =
                new GameOfLifeThreads(file.getLength(), file.getWidth(), file.getSteps(), file.getField());
        life.main();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
