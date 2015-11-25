/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

/**
 *
 * @author tilchev
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> names = FXCollections.observableArrayList();
    @FXML
    ListView<String> lv = new ListView<String>(names);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void load(String fn) {
        names.clear();
        Scanner sc = null;
        
        try {
            sc = new Scanner(new File(fn));
            sc.useLocale(Locale.ENGLISH);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        
        
        while (sc.hasNext()) {
            String s = sc.next();
            names.add(s);
        }
        sc.close();
    }

    @FXML
    private void open(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);
        if(f != null) {
            load(f.getAbsolutePath());
            lv.setItems(names);
        }
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
    
}
