package com.dz.mlayerlev;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;





public class uicontroler {

    public class phone_sting{
        public String phone;
        public String name;
        public String adress;
        public String email;
        phone_sting(String a, String b,String c, String f){
            this.phone = a;
            this.name = b;
            this.adress = c;
            this.email = f;
        }
        public String getname() {
            return name;
        }

        public String getphone() {
            return phone;
        }

        public String getadress() {
            return adress;
        }

        public String getemail() {
            return email;
        }
    }
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
    @FXML
    private TableView tab;


    public void initialize() {
        // ...

    }

    public void start(){
        try {
            lg = new logic("./file.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn adressColumn = new TableColumn("Adress");
        adressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));

        TableColumn emailColumn = new TableColumn("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn phoneColumn = new TableColumn("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tab.getColumns().addAll(nameColumn, adressColumn, emailColumn, phoneColumn);
        l1.setText(String.valueOf(lg.GetEndIndex()));
        update();
    }
public void update(){
        lv.getItems().clear();
    for(int i=0;i!=lg.GetEndIndex();i++) {
        lv.getItems().add(lg.getName(i));

    }
    phone_sting row = new phone_sting("value 1", "value 2", "value 3", "value 4");

// Получаем список элементов таблицы и добавляем в него новую строку
    tab.getItems().add(row);

}
    public void listclick(){
        int n = lv.getSelectionModel().getSelectedIndex();
       // tab.getColumns().add()
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