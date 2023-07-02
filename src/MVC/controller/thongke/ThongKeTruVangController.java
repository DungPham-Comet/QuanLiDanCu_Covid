package MVC.controller.thongke;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import MVC.services.TamTruServices;
import MVC.services.TamVangServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class ThongKeTruVangController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private BarChart<String, Integer> truVangBarChart;
    
    private XYChart.Series<String, Integer> tamtruSeries = new XYChart.Series<>();
    
    private XYChart.Series<String, Integer> tamVangSeries = new XYChart.Series<>();
    
    private String fromdate;
    
    private String todate;
    
    @FXML
    void viewChart(ActionEvent event) {
    	fromdate = fromDatePicker.getValue().toString();
    	todate = toDatePicker.getValue().toString();
    	tamtruSeries.getData().get(0).setYValue(TamTruServices.getTotalTamTruByDate(fromdate, todate));
    	tamVangSeries.getData().get(0).setYValue(TamVangServices.getTotalTamVangByDate(fromdate, todate));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fromDatePicker.setValue(LocalDate.now());
		toDatePicker.setValue(LocalDate.now());
    	fromdate = fromDatePicker.getValue().toString();
    	todate = toDatePicker.getValue().toString();		
    	tamtruSeries.setName("Tạm trú");
    	tamtruSeries.getData().add(new XYChart.Data<String, Integer>("Tạm Trú", TamTruServices.getTotalTamTruByDate(fromdate, todate)));
    	tamVangSeries.setName("Tạm vắng");
    	tamVangSeries.getData().add(new XYChart.Data<String, Integer>("Tạm Vắng", TamVangServices.getTotalTamVangByDate(fromdate, todate)));
    	truVangBarChart.getData().addAll(tamtruSeries, tamVangSeries);
	}

}
