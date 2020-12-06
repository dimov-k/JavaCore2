import java.io.IOException;
import java.io.PrintStream;

public class ExceptMatrix extends IOException {

    public ExceptMatrix(String message) {
        super(message);
    }


    public void printStackTrace(PrintStream s) {
        System.out.println("Исключение!!");
        StackTraceElement[]  ste = getStackTrace();

        for (int i = 0; i < ste.length; i++) {
            System.out.println("5)В классе: " + ste[i].getClassName() + " " + ste[i].getFileName() + " произошла ошибка:'( " +getMessage());
        }

    }
}
