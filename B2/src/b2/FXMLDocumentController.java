/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author tilchev
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Canvas canvas;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(200, 0, 200, 1000);
        gc.strokeLine(0, 400, 1000, 400);
        for (double x = -90; x <= 180; x += 1.0) {
            double y = 20 + 50 * Math.sin(x / 57.3);
            gc.fillOval(200 + x, 400 - y, 1, 1);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
