package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811855528689691726L;
	private Drawing frame;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint;
	private Shape selectedShape;

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * @return the selected shape
	 */
	public Shape getSelected() {
		return selectedShape;
	}

	public void setSelected(Shape selected) {
		this.selectedShape = selected;
	}

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	}

	public PnlDrawing(Drawing drawing) {
		frame = drawing;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	}

	protected void thisMouseClicked(MouseEvent e) {
		if (frame.getTglbtnSelektuj().isSelected()) {
			selectedShape = null;
			Point pointOfClick = new Point(e.getX(), e.getY());
			Iterator<Shape> it = shapes.iterator();
			while (it.hasNext()) {
				Shape sh = it.next();
				sh.setSelected(false);
				if (sh.contains(pointOfClick.getX(), pointOfClick.getY())) {
					selectedShape = sh;
				}
			}
		}
		
		if (frame.getTglbtnTacka().isSelected()) {
			DlgPoint dlgPoint = new DlgPoint();
			dlgPoint.setTxtXKoordinata(Integer.toString(e.getX()));
			dlgPoint.setTxtYKoordinata(Integer.toString(e.getY()));
			dlgPoint.setVisible(true);
			if (dlgPoint.isOk()) {
				System.out.println(dlgPoint.getEdge());
				if (dlgPoint.getEdge() == null)
					dlgPoint.setEdge(Color.BLACK);
				Point point = new Point(Integer.parseInt(dlgPoint.getTxtXKoordinata().getText()), Integer.parseInt(dlgPoint.getTxtYKoordinata().getText()), dlgPoint.getEdge());
				shapes.add(point);
			}
		} else if (frame.getTglbtnLinija().isSelected()) {

			if (startPoint == null)
				startPoint = new Point(e.getX(), e.getY());
			else {
				Point endPoint = new Point(e.getX(), e.getY());
				DlgLine dlgLine = new DlgLine();
				dlgLine.setTxtStartXKoordinata(Integer.toString(startPoint.getX()));
				dlgLine.setTxtStartYKoordinata(Integer.toString(startPoint.getY()));
				dlgLine.setTxtEndXKoordinata(Integer.toString(endPoint.getX()));
				dlgLine.setTxtEndYKoordinata(Integer.toString(endPoint.getY()));
				dlgLine.setVisible(true);
				if (dlgLine.isOk()) {
					if (dlgLine.getEdge() == null)
						dlgLine.setEdge(Color.black);
					Point p1 = new Point(Integer.parseInt(dlgLine.getTxtStartXKoordinata().getText()), Integer.parseInt(dlgLine.getTxtStartYKoordinata().getText()));
					Point p2 = new Point(Integer.parseInt(dlgLine.getTxtEndXKoordinata().getText()), Integer.parseInt(dlgLine.getTxtEndYKoordinata().getText()));
					Line l = new Line(p1, p2, dlgLine.getEdge());
					shapes.add(l);
					dlgLine.dispose();
				} 
				startPoint = null;

			}
		} else if (frame.getTglbtnPravougaonik().isSelected()) {
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.setTxtXKoordinata(Integer.toString(e.getX()));
			dlgRectangle.setTxtYKoordinata(Integer.toString(e.getY()));
			dlgRectangle.setVisible(true);
			if (dlgRectangle.isOk()) {
				if (dlgRectangle.getFill() == null)
					dlgRectangle.setFill(Color.white);
				if (dlgRectangle.getEdge() == null)
					dlgRectangle.setEdge(Color.black);

				Rectangle rectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangle.getTxtXKoordinata().getText()), Integer.parseInt(dlgRectangle.getTxtYKoordinata().getText())), Integer.parseInt(dlgRectangle.getTxtVisina().getText()), Integer.parseInt(dlgRectangle.getTxtSirina().getText()), dlgRectangle.getEdge(), dlgRectangle.getFill());
				shapes.add(rectangle);

			}
		} else if (frame.getTglbtnKrug().isSelected()) {
			Point center = new Point(e.getX(), e.getY());
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setTxtXKoordinata(Integer.toString(center.getX()));
			dlgCircle.setTxtYKoordinata(Integer.toString(center.getY()));
			dlgCircle.setVisible(true);
			if (dlgCircle.isOk()) {
				if (dlgCircle.getFill() == null)
					dlgCircle.setFill(Color.white);
				if (dlgCircle.getEdge() == null)
					dlgCircle.setEdge(Color.black);
				Circle circle = new Circle(new Point(Integer.parseInt(dlgCircle.getTxtXKoordinata().getText()), Integer.parseInt(dlgCircle.getTxtYKoordinata().getText())), Integer.parseInt(dlgCircle.getTxtR().getText()), dlgCircle.getEdge(), dlgCircle.getFill());
				System.out.println(circle);
				shapes.add(circle);
			}
		} else if (frame.getTglbtnKrugSaRupom().isSelected()) {
			Point center = new Point(e.getX(), e.getY());
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setTxtXKoordinata(Integer.toString(center.getX()));
			dlgDonut.setTxtYKoordinata(Integer.toString(center.getY()));
			dlgDonut.setVisible(true);

			if (dlgDonut.isOk()) {
				int innerRadius = Integer.parseInt(dlgDonut.getTxtRRupe().getText());
				int outerRadius = Integer.parseInt(dlgDonut.getTxtR().getText());
				int x = Integer.parseInt(dlgDonut.getTxtXKoordinata().getText());
				int y = Integer.parseInt(dlgDonut.getTxtYKoordinata().getText());
				center = new Point(x, y);
				Donut donut = new Donut(center, outerRadius, innerRadius);
				if (dlgDonut.getFill() == null)
					dlgDonut.setFill(Color.white);
				if (dlgDonut.getEdge() == null)
					dlgDonut.setEdge(Color.black);
				donut.setFill(dlgDonut.getFill());
				donut.setEdge(dlgDonut.getEdge());

				shapes.add(donut);

			}
		} else if (selectedShape != null) {
			selectedShape.setSelected(true);
		}

		if (shapes != null)
			repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext())
			it.next().draw(g);
	}

}
