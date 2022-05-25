package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import java.awt.Point;

public class FXMLController {
	private Engine engine = new Engine();
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button Circle;

	@FXML
	private Button EllipseButton;

	@FXML
	private TextField EllipseHeight;

	@FXML
	private TextField EllipseWidth;

	@FXML
	private TextField EllipseX;

	@FXML
	private TextField EllipseY;

	@FXML
	private ColorPicker EllipseFillColor;

	@FXML
	private Button Line;

	@FXML
	private Button Rectangle;

	@FXML
	private Button Square;

	@FXML
	private ColorPicker EllipseStrokeColor;

	@FXML
	private Button Triangle;

	@FXML
	private Canvas canvas;

	@FXML
	private CheckBox EllipseisFill;

	@FXML
	private TextField EllipseName;

	@FXML
	private AnchorPane pane;

	@FXML
	private AnchorPane popup;

	@FXML
	private Button DrawEllipse;

	@FXML
	private ChoiceBox<String> ShapesBox;

	@FXML
	private Button Remove;

	@FXML
	private Button Redo;

	@FXML
	private Button Undo;

	@FXML

	public void CirclePressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.beginPath();
		gc.moveTo(50, 140);
		gc.lineTo(300, 140);
		gc.lineTo(85, 300);
		gc.lineTo(175, 50);
		gc.lineTo(285, 300);
		gc.lineTo(50, 140);
		gc.stroke();
		gc.closePath();
		gc.fillOval(300, 300, 50, 50);

	}

	@FXML
	void EllipsePressed(ActionEvent event) {
		popup.setVisible(true);
		EllipseName.setText("Ellipse" + engine.Shapes.size());

	}

	@FXML
	void DrawEllipsePressed(ActionEvent event) {
		try {
			GraphicsContext gc = canvas.getGraphicsContext2D();
			Ellipse ellipse = new Ellipse();
			Map<String, Double> prop = new HashMap<String, Double>();
			prop.put("Width", Double.parseDouble(EllipseWidth.getText()));
			prop.put("Height", Double.parseDouble(EllipseHeight.getText()));
			Point p = new Point(Integer.parseInt(EllipseX.getText()), Integer.parseInt(EllipseY.getText()));
			ellipse.setPosition(p);
			ellipse.setProperties(prop);
			ellipse.setFillColor(EllipseFillColor.getValue());
			ellipse.setColor(EllipseStrokeColor.getValue());
			boolean found = false;
			for (int i = 0; i < engine.Shapes.size(); i++) {
				if (engine.Shapes.get(i).getName().equals(EllipseName.getText())) {
					found = true;
					new Alert(Alert.AlertType.ERROR, "shape name already exists!").showAndWait();
					break;
				}
			}
			if (!found)
				ellipse.setName(EllipseName.getText());
			engine.addShape(ellipse);
			engine.refresh(gc);
			ShapesBox.getItems().add(ellipse.getName());
			popup.setVisible(false);
		} catch (NumberFormatException e) {
			new Alert(Alert.AlertType.ERROR, "please enter a valid input").showAndWait();
		}

	}

	@FXML
	void LinePressed(ActionEvent event) {

	}

	@FXML
	void RectanglePressed(ActionEvent event) {

	}

	@FXML
	void SquarePressed(ActionEvent event) {

	}

	@FXML
	void TrianglePressed(ActionEvent event) {

	}

	@FXML
	void RemovePressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		for (int i = 0; i < engine.Shapes.size(); i++) {
			if (engine.Shapes.get(i).getName().equals(ShapesBox.getSelectionModel().getSelectedItem())) {
				engine.removeShape(engine.Shapes.get(i));
				ShapesBox.getItems().remove(ShapesBox.getSelectionModel().getSelectedItem());
				ShapesBox.setSelectionModel(null);
				break;
			}

		}
		engine.refresh(gc);
	}

	@FXML
	void UndoPressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		engine.undo();
		engine.refresh(gc);
		ShapesBox.getItems().removeAll();
		for (int i = 0; i < engine.Shapes.size(); i++) {
			ShapesBox.getItems().add(engine.Shapes.get(i).getName());
			System.out.println(engine.Shapes.get(i).getName());
		}
	}

	@FXML
	void RedoPressed(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		engine.redo();
		engine.refresh(gc);
		ShapesBox.getItems().removeAll();
		for (int i = 0; i < engine.Shapes.size(); i++) {
			ShapesBox.getItems().add(engine.Shapes.get(i).getName());
		}

	}

	@FXML
	void initialize() {
		assert Circle != null : "fx:id=\"Circle\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseButton != null : "fx:id=\"Ellipse\" was not injected: check your FXML file 'FXML.fxml'.";
		assert DrawEllipse != null : "fx:id=\"DrawEllipse\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseHeight != null : "fx:id=\"EllipseHeight\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseWidth != null : "fx:id=\"EllipseWidth\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseX != null : "fx:id=\"EllipseX\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseY != null : "fx:id=\"EllipseY\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseFillColor != null : "fx:id=\"FillColor\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Line != null : "fx:id=\"Line\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Rectangle != null : "fx:id=\"Rectangle\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Square != null : "fx:id=\"Square\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseStrokeColor != null : "fx:id=\"StrokeColor\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Triangle != null : "fx:id=\"Triangle\" was not injected: check your FXML file 'FXML.fxml'.";
		assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseisFill != null : "fx:id=\"isFill\" was not injected: check your FXML file 'FXML.fxml'.";
		assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'FXML.fxml'.";
		assert popup != null : "fx:id=\"popup\" was not injected: check your FXML file 'FXML.fxml'.";
		assert ShapesBox != null : "fx:id=\"ShapesBox\" was not injected: check your FXML file 'FXML.fxml'.";
		assert EllipseName != null : "fx:id=\"EllipseName\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Remove != null : "fx:id=\"Remove\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Undo != null : "fx:id=\"Undo\" was not injected: check your FXML file 'FXML.fxml'.";
		assert Redo != null : "fx:id=\"Redo\" was not injected: check your FXML file 'FXML.fxml'.";

	}

}
