package MVC.controller.thongke;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import MVC.services.CachLyServices;
import MVC.services.TamTruServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class ThongKeCovidController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private BarChart<String, Integer> hinhThucBarChart;

    @FXML
    private BarChart<String, Integer> mucDoBarChart;
    
    private XYChart.Series<String, Integer> f0Series = new XYChart.Series<>();
    
    private XYChart.Series<String, Integer> f1Series = new XYChart.Series<>();
    
    private XYChart.Series<String, Integer> f2Series = new XYChart.Series<>();
    
    private XYChart.Series<String, Integer> tainhaSeries = new XYChart.Series<>();
    
    private XYChart.Series<String, Integer> khucachlySeries = new XYChart.Series<>();
    
    private String fromdate;

    @FXML
    void viewChart(ActionEvent event) {
    	fromdate = fromDatePicker.getValue().toString();
    	
    	f0Series.getData().get(0).setYValue(CachLyServices.getTotalMucDoByDate(fromdate, "f0"));
    	f1Series.getData().get(0).setYValue(CachLyServices.getTotalMucDoByDate(fromdate, "f1"));
    	f2Series.getData().get(0).setYValue(CachLyServices.getTotalMucDoByDate(fromdate, "f2"));
    	
    	tainhaSeries.getData().get(0).setYValue(CachLyServices.getTotalHinhThucByDate(fromdate, "tại nhà"));
    	khucachlySeries.getData().get(0).setYValue(CachLyServices.getTotalHinhThucByDate(fromdate, "khu cách ly"));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fromDatePicker.setValue(LocalDate.now());
		fromdate = fromDatePicker.getValue().toString();
		
		f0Series.setName("F0");
		f1Series.setName("F1");
		f2Series.setName("F2");
		f0Series.getData().add(new XYChart.Data<String, Integer>("F0", CachLyServices.getTotalMucDoByDate(fromdate, "f0")));
		f1Series.getData().add(new XYChart.Data<String, Integer>("F1", CachLyServices.getTotalMucDoByDate(fromdate, "f1")));
		f2Series.getData().add(new XYChart.Data<String, Integer>("F2", CachLyServices.getTotalMucDoByDate(fromdate, "f2")));
		mucDoBarChart.getData().addAll(f0Series,f1Series,f2Series);
		
		tainhaSeries.setName("Tại nhà");
		khucachlySeries.setName("Khu cách ly");
		tainhaSeries.getData().add(new XYChart.Data<String, Integer>("Tại Nhà", CachLyServices.getTotalHinhThucByDate(fromdate, "tại nhà")));
		khucachlySeries.getData().add(new XYChart.Data<String, Integer>("Tại Nhà", CachLyServices.getTotalHinhThucByDate(fromdate, "khu cách ly")));
		
		hinhThucBarChart.getData().addAll(tainhaSeries,khucachlySeries);
	}
    

}
