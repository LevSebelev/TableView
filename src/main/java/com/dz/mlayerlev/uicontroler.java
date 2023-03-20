package com.dz.mlayerlev;

import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.FileNotFoundException;
import java.io.IOException;

public class uicontroler {
    logic lg;
    @FXML
    private ListView lv;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextArea searchstr;
    public void start(){
        try {
            lg = new logic("./file.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l1.setText(String.valueOf(lg.GetEndIndex()));
        update();
    }
public void update(){
        lv.getItems().clear();
    for(int i=0;i!=lg.GetEndIndex();i++)
        lv.getItems().add(lg.getName(i));
}
    public void listclick(){
        int n = lv.getSelectionModel().getSelectedIndex();
        l1.setText(lg.getName(n));
        l2.setText(lg.getHomeAddress(n));
        l3.setText(lg.getEmail(n));
        l4.setText(lg.getPhoneNumber(n));
    }
    public void delbut(){
        int n = lv.getSelectionModel().getSelectedIndex();
        lg.remove(n);
        update();
    }

    public  void addbut(){
        String a,b,c,d;
        a = t1.getText();
        b = t2.getText();
        c = t3.getText();
        d = t4.getText();
        lg.add(a,b,c,d);
        update();
    }
    public void save() throws IOException {
        lg.save();

    }
    public void search(){
    lv.getSelectionModel().select(lg.search(searchstr.getText()));
        listclick();
    }
}