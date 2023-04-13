package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable{

    @FXML
    private TextField txtTime2;

    @FXML
    private TextField txtTime1;

    @FXML
    private Button convertTime;

    @FXML
    private ComboBox<String> comboMass1;

    @FXML
    private ComboBox<String> comboTime1;

    @FXML
    private Button convertMass;

    @FXML
    private ComboBox<String> comboTime2;

    @FXML
    private Button convertVol;

    @FXML
    private ComboBox<String> comboVol1;

    @FXML
    private TextField txtVol2;

    @FXML
    private ComboBox<String> comboVol2;

    @FXML
    private TextField txtVol1;

    @FXML
    private ComboBox<String> comboMass2;

    @FXML
    private TextField txtMass1;

    @FXML
    private TextField txtMass2;
    
    
    private ObservableList<String> listVol=(ObservableList<String>)FXCollections.observableArrayList("Meters","Kilometers","Centimeters","Millimetes"); // crée le liste pour la distance

    private double Volume[]= {1, 0.001, 100, 1000};
    
    private ObservableList<String> listMass=(ObservableList<String>)FXCollections.observableArrayList("Gram","Kilogram","Milligram");// crée le liste pour la masse

    private double Mass[]= {1, 0.001, 1000};
    
    private ObservableList<String> listTime=(ObservableList<String>)FXCollections.observableArrayList("Second","Minute","Hour","Day"); // crée le liste pour le temps

    private double Time[]= {1, 0.01666666666666666666666666666666, 0.0002777777777777777777,0.0000115740740740740740740740740740740740740740740740};
   @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
    
	comboVol1. setItems (listVol); // ceci initialize tout les combobox avec les lesites
    comboVol2. setItems(listVol);
    comboVol1.getSelectionModel().selectFirst();
    comboVol2. getSelectionModel ().selectFirst();
    comboMass1. setItems (listMass);
    comboMass2. setItems(listMass);
    comboMass1.getSelectionModel().selectFirst();
    comboMass2. getSelectionModel ().selectFirst();
    comboTime1. setItems (listTime);
    comboTime2. setItems(listTime);
    comboTime1.getSelectionModel().selectFirst();
    comboTime2. getSelectionModel ().selectFirst();
    
    }
    
    private double setTaux(ComboBox<String> a, double tbl[])
    {
    int item=a.getSelectionModel().getSelectedIndex();
    double val=tbl[item];
    return val;
    }
    
  
    private void convert(ComboBox<String>a, ComboBox<String> b, TextField c, TextField d, double tbl [])
    {
    double from=setTaux(a, tbl); // code pour converter les nombres quand l'utilisateur veut changer l'unité ou le nombre
    double depart=0;
    
    if(c.getText().equals(""))
    depart=0;
    
    else depart=Double.parseDouble(c.getText());
    double to=setTaux(b, tbl);
    double dest=(to/from)*depart; d.setText(String.valueOf(dest));
    
    }
    
    @FXML
	 void CheckText(KeyEvent e)
	   {
	   	
	   	TextField txt=(TextField)e.getSource() ;  // ceci verifie que tout les entres sont pas numériques
	   	txt.textProperty( ).addListener ( (observable, oldValue, newValue) ->
	   	{
	   	if(!newValue.matches("^-?[0-9](11.[0-9]+)?5")) 
	   	{
	   	txt. setText (newValue. replaceAll("[^\\d*\\.\\-]",""));
	   	{
	    
{
	   	}
	   	}
	   
	   	}
	   	});
	   }

    
    
@FXML
private void ConvertVol1()

{
	convert(comboVol1, comboVol2, txtVol1, txtVol2, Volume); //fair apelle a private void convert pour communiquer a javafx pour se convertir
}
@FXML
private void ConvertVol2()

{
	convert(comboVol2, comboVol1, txtVol2, txtVol1, Volume);
}

@FXML
private void ConvertMass1()

{
	convert(comboMass1, comboMass2, txtMass1, txtMass2, Mass);
}
@FXML
private void ConvertMass2()

{
	convert(comboMass2, comboMass1, txtMass2, txtMass1, Mass); 
}

@FXML
private void ConvertTime1()

{
	convert(comboTime1, comboTime2, txtTime1, txtTime2, Time);
}
@FXML
private void ConvertTime2()

{
	convert(comboTime2, comboTime1, txtTime2, txtTime1, Time);
}


@FXML 

void Quitter() 
{
Alert alert=new Alert(AlertType.CONFIRMATION);   alert.setHeaderText("Confirmation"); // crée l'alerte pour que quand l'utilisateur veut quitter, il faut une confirmation
  alert.setTitle("Sortie");
  alert.setContentText("Voudrais tu vraiment quitter"); 
  Optional<ButtonType> result=alert.showAndWait();
  if (result.get()==ButtonType.OK)
  System.exit(0);
  }
     

{


}



}
