package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField fromBox;
    @FXML
    TextField toBox;
    @FXML
    TextArea outputArea;

    Thread thread;

    @FXML
    void onStart(ActionEvent actionEvent) {
        outputArea.clear();
        int from = Integer.parseInt(fromBox.getText());
        int to = Integer.parseInt(toBox.getText());
        thread = new Thread(() -> printPrimesInRange(from, to));
        thread.start();
    }

    private void printPrimesInRange(int from, int to) {
        StringBuilder primesBuilder = new StringBuilder();

        for (int number = from; number < to; number++) {
            boolean isPrime = true;
            for (int divider = 2; divider < number; divider++) {
                if (number % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primesBuilder.append(String.format("%d%n", number));
            }
            if(thread.isInterrupted()) {
                primesBuilder.insert(0,
                        String.format(
                                "Thread %d interrupted! Here are the results so far:%n",
                                thread.getId()));
                break;
            }
        }

        Platform.runLater(() -> outputArea.appendText(primesBuilder.toString()));
    }

    @FXML
    void onStop(ActionEvent actionEvent) {
        thread.interrupt();
    }
}
