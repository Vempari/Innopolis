package part.lesson;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Buffer {
    public static void main(String[] args) throws IOException {
        Buffer buffer = new Buffer();
        buffer.setFile();
    }

    //Запись в файл
    public void setFile() throws IOException {
        IOFile file = new IOFile();
        Scanner in = new Scanner(System.in);
        System.out.print("Input a length: ");
        file.setLength(in.nextInt());
        System.out.print("Input a width: ");
        file.setWidth(in.nextInt());
        System.out.print("Input number of steps: ");
        file.setSteps(in.nextInt());
        boolean[][] field = new boolean[file.getLength()][file.getWidth()];
        int i;
        int j;
        System.out.println("Print any number more than 0 to continue: ");
        while (in.nextInt() > 0) {
            System.out.println("Input length of field: ");
            i = in.nextInt() - 1;
            System.out.println("Input width of field: ");
            j = in.nextInt() - 1;
            field[i][j] = true;
            System.out.println("If you want to quit input a number less than 0.");
        }
        in.close();
        file.setField(field);
        FileOutputStream fileOutputStream =
                new FileOutputStream("innopolisMain/src/main/resources/file.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(file);

        objectOutputStream.close();
    }

    //Получение из файла
    public IOFile getFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream =
                new FileInputStream("src/main/resources/file.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        IOFile file = (IOFile) objectInputStream.readObject();
        objectInputStream.close();
        return file;
    }
}
