package part.lesson;

import java.io.*;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Buffer {
    public static void main(String[] args) throws IOException {
        Buffer buffer = new Buffer();
        buffer.setFile();
    }

    public void setFile() throws IOException {
        IOFile file = new IOFile();
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Hi! We`re going to play game of life. Let`s make the field.");
            System.out.print("Enter length: ");
            file.setLength(in.nextInt());
            while (file.getLength() == 0) {
                System.out.print("Length should be greater than 0. Try one more time: ");
                file.setLength(in.nextInt());
            }
            System.out.print("Enter width: ");
            file.setWidth(in.nextInt());
            while (file.getLength() == 0) {
                System.out.print("Width should be greater than 0. Try one more time: ");
                file.setWidth(in.nextInt());
            }
            System.out.print("Enter the number of steps: ");
            file.setSteps(in.nextInt());
            boolean[][] field = new boolean[file.getLength()][file.getWidth()];
            int i;
            int j;
            System.out.println("Good! Let`s create our first life.");
            System.out.print("Enter '1' to continue or '0' to quit: ");
            while (in.nextInt() == 1) {
                System.out.print("Enter number of line: ");
                i = in.nextInt() - 1;
                if (i > file.getLength()) {
                    System.out.println("Number of line cannot be greater than length");
                    System.out.print("Enter '1' to continue or '0' to quit: ");
                    continue;
                }
                System.out.print("Enter number of column: ");
                j = in.nextInt() - 1;
                if (j > file.getWidth()) {
                    System.out.println("Number of column cannot be greater than width");
                    System.out.print("Enter '1' to continue or '0' to quit: ");
                    continue;
                }
                field[i][j] = true;
                System.out.print("Life was created! It`s alive!!!");
                System.out.print("Enter '1' to continue or '0' to quit: ");
            }
            in.close();
            file.setField(field);
        } catch (InputMismatchException e) {
            System.out.println("You should write the number. Try one more time!");
        }

        FileOutputStream fileOutputStream =
                new FileOutputStream("innopolisMain/src/main/resources/file.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(file);

        objectOutputStream.close();
    }

    public IOFile getFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream =
                new FileInputStream("src/main/resources/file.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        IOFile file = (IOFile) objectInputStream.readObject();
        objectInputStream.close();
        return file;
    }
}
