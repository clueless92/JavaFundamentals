/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b4;

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
        gc.strokeLine(100, 0, 100, 1000);
        gc.strokeLine(0, 300, 1000, 300);
        int x = 25;
        int y = 225;
        int w = 150;
        int h = 150;
        gc.strokeOval(x, y, w, h);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
