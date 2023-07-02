package MVC.controller.thongke;

import java.net.URL;
import java.util.ResourceBundle;

import MVC.services.HoKhauServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class ThongKeHoKhauController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private BarChart<String, Integer> hoKhauBarChart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series<String, Integer> hokhauSeries = new XYChart.Series<>();
		hokhauSeries.setName("Số hộ khẩu");
		hokhauSeries.getData().add(new XYChart.Data<String, Integer>("2005", HoKhauServices.getTotalSoHoKhauByYear(2005)));
		hokhauSeries.getData().add(new XYChart.Data<String, Integer>("2010", HoKhauServices.getTotalSoHoKhauByYear(2010)));
		hokhauSeries.getData().add(new XYChart.Data<String, Integer>("2015", HoKhauServices.getTotalSoHoKhauByYear(2015)));
		hokhauSeries.getData().add(new XYChart.Data<String, Integer>("2020", HoKhauServices.getTotalSoHoKhauByYear(2020)));
		hokhauSeries.getData().add(new XYChart.Data<String, Integer>("2025", HoKhauServices.getTotalSoHoKhauByYear(2025)));
		
		hoKhauBarChart.getData().addAll(hokhauSeries);
	}

}
