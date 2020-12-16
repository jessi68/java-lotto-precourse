package exception;

import javafx.application.Application;
import javafx.stage.Stage;

public class LottoGameException extends IllegalArgumentException {

    public LottoGameException(String message) {
        super(message);
        System.out.println(message);
    }
}