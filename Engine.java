package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;

public class Engine implements DrawingEngine {
	ArrayList<Shape> Shapes = new ArrayList();
	Stack<ArrayList<Shape>> prevShapes = new Stack();
	Stack<ArrayList<Shape>> redoShapes = new Stack();
	
	public void addShape (Shape shape) {
		ArrayList<Shape> currShapes = new ArrayList(Shapes);
		prevShapes.push(currShapes);
		Shapes.add(shape);
		
	}
	
	public void removeShape(Shape shape) {
		ArrayList<Shape> currShapes = new ArrayList(Shapes);
		prevShapes.push(currShapes);
		for (int i = 0; i <  Shapes.size(); i++) {
			if (Shapes.get(i).getName().equals(shape.getName())) {
				Shapes.remove(i);
			}
		}
	}

	@Override
	public Shape[] getShapes() {
		Shape[] shapes = new Shape[Shapes.size()];
		for (int i = 0; i < Shapes.size(); i++) {
			shapes[i] = Shapes.get(i);
		}
		return shapes;
	}

	@Override
	public void refresh(GraphicsContext canvas) {
		canvas.clearRect(0, 0, canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight());
		for (int i = 0 ; i < Shapes.size(); i++) {
			Shapes.get(i).draw(canvas);
		}
		
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void installPluginShape(Class<? extends Shape> shapeClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
	//	if (!Shapes.isEmpty())
			
		if (!prevShapes.isEmpty()) {
			redoShapes.push(Shapes);
			Shapes = prevShapes.pop();
		}
		
	}

	@Override
	public void redo() {
			
		if (!redoShapes.isEmpty()) {
			prevShapes.push(Shapes);
			Shapes = redoShapes.pop();
		}
		
	}
	
}
