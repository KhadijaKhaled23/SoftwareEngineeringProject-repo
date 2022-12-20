package application;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;




public class CustomerHomePageController implements Initializable {

  

    @FXML
    private TableColumn<FlightsModel, String> FromCol = new TableColumn<FlightsModel,String>("from");
   
    @FXML
    private TableColumn<FlightsModel, String> ToCol = new TableColumn<FlightsModel,String>("to");
    
    @FXML
    private TableColumn<FlightsModel, Number> PriceCol = new TableColumn<FlightsModel,Number>("price");
    
    
    @FXML
    private TableColumn<FlightsModel, String> DateCol =  new TableColumn<FlightsModel,String>("col");
    
    @FXML
    private TableColumn<FlightsModel, String> TimeCol = new TableColumn<FlightsModel,String>("time");

//    @FXML
//    private TableColumn<?, ?> TripID;

    @FXML
    private TableView<FlightsModel> trips_table = new TableView<FlightsModel>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	        
	        FromCol.setCellValueFactory(features->features.getValue().FlightFromProperty());
	        ToCol.setCellValueFactory(features->features.getValue().FlightToProperty());
	        PriceCol.setCellValueFactory(features->features.getValue().FlightPriceProperty());
	        DateCol.setCellValueFactory(features->features.getValue().FlightDateProperty());
	        //DateCol.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("Date"));
	        TimeCol.setCellValueFactory(features->features.getValue().FlightTimeProperty());
	        //add your data to the table here.
	        trips_table.setItems(flightsModel);
	        
	}
	
	
	private ObservableList<FlightsModel> flightsModel = FXCollections.observableArrayList(
            
            new FlightsModel("Egypt", "China", 200, "12/01/2023", "11AM"),
            new FlightsModel("Italy", "Egypt", 300, "24/02/2023", "2PM"),
            new FlightsModel("Egypt", "USA", 230, "18/01/2023", "5PM"),
            new FlightsModel("UAE", "Egypt", 250, "13/01/2023", "9AM"),
            new FlightsModel("Egypt", "Japan", 150, "03/03/2023", "7AM")
            
            
    );


}
