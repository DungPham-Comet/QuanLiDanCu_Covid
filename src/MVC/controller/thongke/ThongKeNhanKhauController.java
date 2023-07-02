package MVC.controller.thongke;

import java.net.URL;
import java.util.ResourceBundle;

import MVC.services.NhanKhauServices;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

public class ThongKeNhanKhauController implements Initializable {

    @FXML
    private AnchorPane basePane;

    @FXML
    private PieChart doTuoiPieChart;

    @FXML
    private PieChart gioiTinhPieChart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<PieChart.Data> gioiTinhChartData = FXCollections.observableArrayList(
				new PieChart.Data("Nam", NhanKhauServices.getTotalNhanKhauNam()),
				new PieChart.Data("Nữ", NhanKhauServices.getTotalNhanKhauNu())
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
        	String percent = String.format("%.1f", (data.getPieValue()*100)/NhanKhauServices.getTotalNhanKhau());
        	tooltip.setText(percent + "%");
        	Tooltip.install(data.getNode(), tooltip);
        	data.pieValueProperty()
            .addListener((observable, oldValue, newValue) -> 
                 tooltip.setText(newValue + "%"));
		});
		gioiTinhPieChart.setPrefSize(250, 250);
		ObservableList<PieChart.Data> doTuoiChartData = FXCollections.observableArrayList(
				new PieChart.Data("Trẻ em", NhanKhauServices.getTotalNhanKhauTreEm()),
				new PieChart.Data("Lao động", NhanKhauServices.getTotalNhanKhauLaoDong()),
				new PieChart.Data("Nghỉ hưu", NhanKhauServices.getTotalNhanKhauNghiHuu())
				);
		doTuoiPieChart.getData().addAll(doTuoiChartData);
		doTuoiPieChart.setLegendSide(Side.BOTTOM);
		doTuoiPieChart.setLabelsVisible(false);
		doTuoiPieChart.setPrefSize(270, 270);
		doTuoiChartData.forEach(data ->{
	        data.nameProperty().bind(
	                Bindings.concat(
	                        data.getName(), ": ", data.pieValueProperty()
	                		)
	        		);
	        	Tooltip tooltip = new Tooltip();
	        	String percent = String.format("%.1f", (data.getPieValue()*100)/NhanKhauServices.getTotalNhanKhau());
	        	tooltip.setText(percent + "%");
	        	Tooltip.install(data.getNode(), tooltip);
	        	data.pieValueProperty()
	            .addListener((observable, oldValue, newValue) -> 
	                 tooltip.setText(newValue + "%"));
			});		
	}

}
