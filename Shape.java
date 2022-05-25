package application;

public interface Shape {
	/* set position */
	public void setPosition(java.awt.Point position);

	public java.awt.Point getPosition();

	/* update shape specific properties (e.g., radius) */
	public void setProperties(java.util.Map<String, Double> properties);

	public java.util.Map<String, Double> getProperties();

	/* colorize */
	public void setColor(javafx.scene.paint.Color color);

	public javafx.scene.paint.Color getColor();

	public void setFillColor(javafx.scene.paint.Color color);

	public javafx.scene.paint.Color getFillColor();

	/* redraw the shape on the canvas */
	public void draw(javafx.scene.canvas.GraphicsContext canvas);
	
	public void setName(String Name);
	
	public String getName();

	/* create a deep clone of the shape */
	public Object clone() throws CloneNotSupportedException;
}
