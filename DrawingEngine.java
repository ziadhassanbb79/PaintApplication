package application;

public interface DrawingEngine {
	/* manage shapes objects */
	public void addShape(Shape shape);

	public void removeShape(Shape shape);

	/* return the created shapes objects */
	public Shape[] getShapes();

	/* redraw all shapes on the canvas */
	public void refresh(javafx.scene.canvas.GraphicsContext canvas);

	/*
	 * return the classes (types) of supported shapes that can be dynamically loaded
	 * at runtime (see Part 3)
	 */
	public java.util.List<Class<? extends Shape>> getSupportedShapes();

	/* add to the supported shapes the new shape class (see Part 3) */
	public void installPluginShape(Class<? extends Shape> shapeClass);

	/*
	 * limited to 20 steps. Only consider in undo & redo these actions: addShape,
	 * removeShape
	 */
	public void undo();

	public void redo();

}
