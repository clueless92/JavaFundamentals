/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author tilchev
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lPause;
    @FXML
    private CheckMenuItem cmiScale;
    @FXML
    private CheckMenuItem cmiRotate;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    RotateTransition rt = new RotateTransition();
    ScaleTransition st = new ScaleTransition();

    @FXML
    private void cmiScaleAction(ActionEvent event) {
        if (cmiScale.isSelected()) {
            st.setNode(lPause);
            st.setToX(3.0);
            st.setToY(3.0);
            st.setDuration(Duration.seconds(3.0));
            st.setCycleCount(Timeline.INDEFINITE);
            st.setAutoReverse(false);
            st.play();
        } else {
            st.jumpTo(Duration.ZERO);
            st.stop();
        }
    }
    
    
    @FXML
    private void cmiRotateAction(ActionEvent event) {
        if (cmiRotate.isSelected()) {
            rt.setNode(lPause);
            rt.setDuration(Duration.seconds(2.0));
            rt.setFromAngle(-30);
            rt.setByAngle(60);
            rt.setCycleCount(Timeline.INDEFINITE);
            rt.setAutoReverse(true);
            rt.playFrom(Duration.seconds(1.0));
        } else {
            rt.jumpTo(Duration.seconds(1.0));
            rt.stop();
        }
    }
    
}
