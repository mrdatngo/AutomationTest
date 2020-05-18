import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    interface LoggerInterface {
        public void Write(String content);
    }

    class Log2Screen implements LoggerInterface {
        @Override
        public void Write(String content) {
            System.out.println(content);
        }
    }

    class Log2Mail implements LoggerInterface {
        @Override
        public void Write(String content) {
            System.out.println("Send to mail....");
        }
    }

    class Log2File implements LoggerInterface {
        @Override
        public void Write(String content) {
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write(content);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public void start() {
        LoggerInterface logger = new Log2File();
        logger.Write("hihi");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Logger myprogram = new Logger();
        myprogram.start();
    }
}
