package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.awt.Point;
import javafx.scene.paint.Color;
import java.util.*;

public class Ellipse implements Shape{
		protected Point Position = new Point();
		protected Map<String, Double> Properties = new HashMap<String, Double>();
		protected Color StrokeColor;
		protected Color FillColor;
		protected String Name;
		
		public Ellipse () {
			Position.x = 0;
			Position.y = 0;
			Properties.put("Width", 100.0);
			Properties.put("Height", 100.0);
		}

		public void setPosition(Point position) {
			this.Position = position;
			
		}
		
		public Point getPosition () {
			return Position;
		}	
		
		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public void setProperties(Map<String,Double> prop) {
			Properties = prop;
		}
		
		public Map<String,Double> getProperties () {
			return Properties;
		}
		
		
		public void setColor(Color color) {
			StrokeColor = color;
		}
		
		public Color getColor() {
			return StrokeColor;
		}
		
		public void setFillColor (Color color) {
			FillColor = color;
		}
		
		public Color getFillColor(){
			return FillColor;
		}
		
		public void draw (GraphicsContext gc) {
			if (FillColor.equals(Color.WHITE)) {
				
				gc.setStroke(StrokeColor);
				gc.strokeOval(Position.x, Position.y, Properties.get("Width"), Properties.get("Height"));
				gc.stroke();
			
			}
			else {
				gc.setFill(FillColor);
				gc.fillOval(Position.x, Position.y, Properties.get("Width"), Properties.get("Height"));
				gc.fill();
			}
		}
		
		public Object clone () {
			return null;
	}

}
