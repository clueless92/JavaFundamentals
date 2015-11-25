/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author tilchev
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tf;
    ObservableList<String> names = FXCollections.observableArrayList();
    @FXML
    ListView<String> lv = new ListView<String>(names);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
        lv.setItems(names);
        names.add(tf.getText());
    }

    @FXML
    private void dell(ActionEvent event) {
        int item = lv.getSelectionModel().getSelectedIndex();
        if(item == -1) {
            return;
        }
        else {
            names.remove(item);
        }
    }

    @FXML
    private void save(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);
        if (f != null) {
            save(f.getAbsolutePath());
        }
    }
    
    void save(String fn) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fn));
        } catch (Exception e) {
            System.exit(1);
        }
        
        for(int i = 0; i < names.size(); i++) {
            pw.println(names.get(i));
        }
        pw.close();
    }
    
}
