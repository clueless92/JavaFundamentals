/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3;

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
        gc.strokeLine(300, 0, 300, 1000);
        gc.strokeLine(0, 100, 1000, 100);
        int x = 250;
        int y = 75;
        int w = 100;
        int h = 50;
        gc.strokeRect(x, y, w, h);
        gc.strokeLine(x, y, x+w, y+h);
        gc.strokeLine(x, y+h, x+w, y);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
