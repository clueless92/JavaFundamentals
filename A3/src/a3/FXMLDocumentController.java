/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3;

import java.net.URL;
import java.time.Clock;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author tilchev
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label chronoLabel;
    int hours =0;
    int min = 0;
    int sec = 0;
    Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), new UpdateTimer()));
    
    private class UpdateTimer implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            sec++;
            if(sec == 60){
                min++;
                sec = 0;
                if(min == 60){
                    hours++;
                    min = 0;
                }
            }
            String print = String.format("%02d : %02d : %02d" , hours, min, sec);
            chronoLabel.setText(print);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void start(ActionEvent event) {
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    @FXML
    private void stop(ActionEvent event) {
        t.stop();
    }
}
