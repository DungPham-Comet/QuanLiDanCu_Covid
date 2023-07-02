package MVC.controller.thongke;

import java.net.URL;
import java.util.ResourceBundle;

import MVC.services.CachLyServices;
import MVC.services.KhaiTuServices;
import MVC.services.NhanKhauServices;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

public class ThongKeNhanKhauController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private PieChart doTuoiPieChart;

    @FXML
    private PieChart gioiTinhPieChart;
    
    @FXML
    private BarChart<String, Integer> sinhTuBarChart;
    
    @FXML
    private TextField yearTextField;
    
    private ObservableList<PieChart.Data> gioiTinhChartData;
    
    private ObservableList<PieChart.Data> doTuoiChartData;
    
    private XYChart.Series<String, Integer> sinhSeries = new XYChart.Series<>();
    
    private XYChart.Series<String, Integer> tuSeries = new XYChart.Series<>();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gioiTinhChartData = FXCollections.observableArrayList(
				new PieChart.Data("Nam", NhanKhauServices.getTotalNhanKhauNam("2023")),
				new PieChart.Data("Nữ", NhanKhauServices.getTotalNhanKhauNu("2023"))
				);
		gioiTinhPieChart.getData().addAll(gioiTinhChartData);
		gioiTinhPieChart.setLegendSide(Side.BOTTOM);
		gioiTinhPieChart.setLabelsVisible(false);
		gioiTinhChartData.forEach(data ->{
        data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), ": ", data.pieValueProperty()
                		)
        		);
        	Tooltip tooltip = new Tooltip();
        	String percent = String.format("%.1f", (data.getPieValue()*100)/NhanKhauServices.getTotalNhanKhau("2023"));
        	tooltip.setText(percent + "%");
        	Tooltip.install(data.getNode(), tooltip);
        	data.pieValueProperty()
            .addListener((observable, oldValue, newValue) -> 
                 tooltip.setText(newValue + "%"));
		});
		doTuoiChartData = FXCollections.observableArrayList(
				new PieChart.Data("Trẻ em", NhanKhauServices.getTotalNhanKhauTreEm("2023")),
				new PieChart.Data("Lao động", NhanKhauServices.getTotalNhanKhauLaoDong("2023")),
				new PieChart.Data("Nghỉ hưu", NhanKhauServices.getTotalNhanKhauNghiHuu("2023"))
				);
		doTuoiPieChart.getData().addAll(doTuoiChartData);
		doTuoiPieChart.setLegendSide(Side.BOTTOM);
		doTuoiPieChart.setLabelsVisible(false);
		doTuoiChartData.forEach(data ->{
	        data.nameProperty().bind(
	                Bindings.concat(
	                        data.getName(), ": ", data.pieValueProperty()
	                		)
	        		);
	        	Tooltip tooltip = new Tooltip();
	        	String percent = String.format("%.1f", (data.getPieValue()*100)/NhanKhauServices.getTotalNhanKhau("2023"));
	        	tooltip.setText(percent + "%");
	        	Tooltip.install(data.getNode(), tooltip);
	        	data.pieValueProperty()
	            .addListener((observable, oldValue, newValue) -> 
	                 tooltip.setText(newValue + "%"));
			});
		sinhSeries.setName("Sinh");
		tuSeries.setName("Tử");
		sinhSeries.getData().add(new XYChart.Data<String, Integer>("F0", NhanKhauServices.getTotalNhanKhauSinh("2023")));
		tuSeries.getData().add(new XYChart.Data<String, Integer>("F0", KhaiTuServices.getTotalNhanKhauTu("2023")));
		sinhTuBarChart.getData().addAll(sinhSeries, tuSeries);
	}

    @FXML
    void viewChart(ActionEvent event) {
    	String year = yearTextField.getText();
    	gioiTinhChartData.get(0).setPieValue(NhanKhauServices.getTotalNhanKhauNam(year));
    	gioiTinhChartData.get(1).setPieValue(NhanKhauServices.getTotalNhanKhauNu(year));
    	doTuoiChartData.get(0).setPieValue(NhanKhauServices.getTotalNhanKhauTreEm(year));
    	doTuoiChartData.get(1).setPieValue(NhanKhauServices.getTotalNhanKhauLaoDong(year));
    	doTuoiChartData.get(2).setPieValue(NhanKhauServices.getTotalNhanKhauNghiHuu(year));
    	sinhSeries.getData().get(0).setYValue(NhanKhauServices.getTotalNhanKhauSinh(year));
    	tuSeries.getData().get(0).setYValue(KhaiTuServices.getTotalNhanKhauTu(year));
    }

}
