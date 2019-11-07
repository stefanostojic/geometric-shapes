package drawing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import drawing.Circle;
import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgLine;
import drawing.DlgPoint;
import drawing.DlgRectangle;
import drawing.Donut;
import drawing.Line;
import drawing.PnlDrawing;
import drawing.Point;
import drawing.Rectangle;
import drawing.Shape;

import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Drawing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JToggleButton tglbtnTacka;
	private JToggleButton tglbtnLinija;
	private JToggleButton tglbtnPravougaonik;
	private JToggleButton tglbtnKrug;
	private JToggleButton tglbtnKrugSaRupom;
	private JToggleButton tglbtnSelektuj;
	private JToggleButton tglbtnModifikuj;
	private JToggleButton tglbtnObrisi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing drawing = new Drawing();
					drawing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Drawing() {
		setTitle("Drawing");
		PnlDrawing pnlDrawing = new PnlDrawing(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		pnlDrawing.setPreferredSize(new Dimension(600, 800));
		contentPane.add(pnlDrawing);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);

		ButtonGroup btnGroup = new ButtonGroup();

		tglbtnTacka = new JToggleButton("Tačka");
		toolBar.add(tglbtnTacka);
		btnGroup.add(tglbtnTacka);

		tglbtnLinija = new JToggleButton("Linija");
		toolBar.add(tglbtnLinija);
		btnGroup.add(tglbtnLinija);

		tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		toolBar.add(tglbtnPravougaonik);
		btnGroup.add(tglbtnPravougaonik);

		tglbtnKrug = new JToggleButton("Krug");
		toolBar.add(tglbtnKrug);
		btnGroup.add(tglbtnKrug);

		tglbtnKrugSaRupom = new JToggleButton("Krug sa rupom");
		btnGroup.add(tglbtnKrugSaRupom);
		toolBar.add(tglbtnKrugSaRupom);

		tglbtnSelektuj = new JToggleButton("Selektuj");
		btnGroup.add(tglbtnSelektuj);
		toolBar.add(tglbtnSelektuj);

		tglbtnModifikuj = new JToggleButton("Modifikuj");
		btnGroup.add(tglbtnModifikuj);
		toolBar.add(tglbtnModifikuj);
		tglbtnModifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (pnlDrawing.getSelected() != null) {
					Shape tempShape = pnlDrawing.getSelected();
					ArrayList<Shape> allShapesOnDrawing = pnlDrawing.getShapes();
					int tempShapeIndex = allShapesOnDrawing.indexOf(tempShape);
					if (pnlDrawing.getSelected() instanceof Point) {
						
						DlgPoint dlgPoint = new DlgPoint();
						dlgPoint.setTitle("Modifikacija tačke");
						dlgPoint.setTxtXKoordinata(Integer.toString(((Point) tempShape).getX()));
						dlgPoint.setTxtYKoordinata(Integer.toString(((Point) tempShape).getY()));
						dlgPoint.setEdge(((Point) tempShape).getEdge());
						dlgPoint.setVisible(true);

						if (dlgPoint.isOk()) {
							((Point) tempShape).setX(Integer.parseInt(dlgPoint.getTxtXKoordinata().getText()));
							((Point) tempShape).setY(Integer.parseInt(dlgPoint.getTxtYKoordinata().getText()));
							((Point) tempShape).setEdge(dlgPoint.getEdge());
							allShapesOnDrawing.set(tempShapeIndex, tempShape);
							pnlDrawing.setShapes(allShapesOnDrawing);
							tempShape.setSelected(true);
							pnlDrawing.setSelected(tempShape);
							pnlDrawing.repaint();
						}
					} else if (pnlDrawing.getSelected() instanceof Line) {
						DlgLine dlgLine = new DlgLine();
						dlgLine.setTitle("Modifikacija linije");
						dlgLine.setTxtStartXKoordinata(Integer.toString(((Line) tempShape).getStartPoint().getX()));
						dlgLine.setTxtStartYKoordinata(Integer.toString(((Line) tempShape).getStartPoint().getY()));
						dlgLine.setTxtEndXKoordinata(Integer.toString(((Line) tempShape).getEndPoint().getX()));
						dlgLine.setTxtEndYKoordinata(Integer.toString(((Line) tempShape).getEndPoint().getY()));
						dlgLine.setEdge(((Line) tempShape).getEdge());
						dlgLine.setVisible(true);

						if (dlgLine.isOk()) {
							((Line) tempShape).setStartPoint(
									new Point((Integer.parseInt(dlgLine.getTxtStartXKoordinata().getText())),
											(Integer.parseInt(dlgLine.getTxtStartYKoordinata().getText()))));
							((Line) tempShape)
									.setEndPoint(new Point((Integer.parseInt(dlgLine.getTxtEndXKoordinata().getText())),
											(Integer.parseInt(dlgLine.getTxtEndYKoordinata().getText()))));
							((Line) tempShape).setEdge(dlgLine.getEdge());
							allShapesOnDrawing.set(tempShapeIndex, tempShape);
							pnlDrawing.setShapes(allShapesOnDrawing);
							tempShape.setSelected(true);
							pnlDrawing.setSelected(tempShape);
							pnlDrawing.repaint();
						}
					} else if (pnlDrawing.getSelected() instanceof Rectangle) {
						DlgRectangle dlgRectangle = new DlgRectangle();
						dlgRectangle.setTitle("Modifikacija pravougaonika");
						dlgRectangle.setTxtXKoordinata(
								Integer.toString(((Rectangle) tempShape).getUpperLeftPoint().getX()));
						dlgRectangle.setTxtYKoordinata(
								Integer.toString(((Rectangle) tempShape).getUpperLeftPoint().getY()));
						dlgRectangle.setTxtSirina(Integer.toString(((Rectangle) tempShape).getWidth()));
						dlgRectangle.setTxtVisina(Integer.toString(((Rectangle) tempShape).getHeight()));
						dlgRectangle.setFill(((Rectangle) tempShape).getFill());
						dlgRectangle.setEdge(((Rectangle) tempShape).getEdge());
						dlgRectangle.setOk(false);
						dlgRectangle.setVisible(true);

						if (dlgRectangle.isOk()) {
							((Rectangle) tempShape).setWidth(Integer.parseInt(dlgRectangle.getTxtSirina().getText()));
							((Rectangle) tempShape).setHeight(Integer.parseInt(dlgRectangle.getTxtVisina().getText()));
							((Rectangle) tempShape).setFill(dlgRectangle.getFill());
							((Rectangle) tempShape).setEdge(dlgRectangle.getEdge());
							((Rectangle) tempShape).setUpperLeftPoint(
									new Point(Integer.parseInt(dlgRectangle.getTxtXKoordinata().getText()),
											Integer.parseInt(dlgRectangle.getTxtYKoordinata().getText())));
							allShapesOnDrawing.set(tempShapeIndex, tempShape);
							pnlDrawing.setShapes(allShapesOnDrawing);
							tempShape.setSelected(true);
							pnlDrawing.setSelected(tempShape);
							pnlDrawing.repaint();
						}

					} else if (pnlDrawing.getSelected() instanceof Donut) {
						DlgDonut dlgDonut = new DlgDonut();
						dlgDonut.setTitle("Modifikacija kruga sa rupom");
						dlgDonut.setTxtXKoordinata(Integer.toString(((Donut) tempShape).getCenter().getX()));
						dlgDonut.setTxtYKoordinata(Integer.toString(((Donut) tempShape).getCenter().getY()));
						dlgDonut.setTxtRRupe(Integer.toString(((Donut) tempShape).getInnerRadius()));
						dlgDonut.setTxtR(Integer.toString(((Donut) tempShape).getRadius()));
						dlgDonut.setFill(((Donut) tempShape).getFill());
						dlgDonut.setEdge(((Donut) tempShape).getEdge());
						dlgDonut.setVisible(true);

						if (dlgDonut.isOk()) {
							((Donut) tempShape)
									.setCenter(new Point(Integer.parseInt(dlgDonut.getTxtXKoordinata().getText()),
											Integer.parseInt(dlgDonut.getTxtYKoordinata().getText())));
							((Donut) tempShape).setInnerRadius(Integer.parseInt(dlgDonut.getTxtRRupe().getText()));
							((Donut) tempShape).setRadius(Integer.parseInt(dlgDonut.getTxtR().getText()));
							((Donut) tempShape).setFill(dlgDonut.getFill());
							((Donut) tempShape).setEdge(dlgDonut.getEdge());
							allShapesOnDrawing.set(tempShapeIndex, tempShape);
							pnlDrawing.setShapes(allShapesOnDrawing);
							tempShape.setSelected(true);
							pnlDrawing.setSelected(tempShape);
							pnlDrawing.repaint();

						}

					} else if (pnlDrawing.getSelected() instanceof Circle) {
						DlgCircle dlgCircle = new DlgCircle();
						dlgCircle.setTxtXKoordinata(Integer.toString(((Circle) tempShape).getCenter().getX()));
						dlgCircle.setTxtYKoordinata(Integer.toString(((Circle) tempShape).getCenter().getY()));
						dlgCircle.setTxtR(Integer.toString(((Circle) tempShape).getRadius()));
						dlgCircle.setFill(((Circle) tempShape).getFill());
						dlgCircle.setEdge(((Circle) tempShape).getEdge());
						dlgCircle.setVisible(true);
						((Circle) tempShape)
								.setCenter(new Point(Integer.parseInt(dlgCircle.getTxtXKoordinata().getText()),
										Integer.parseInt(dlgCircle.getTxtYKoordinata().getText())));
						((Circle) tempShape).setRadius(Integer.parseInt(dlgCircle.getTxtR().getText()));
						((Circle) tempShape).setFill(dlgCircle.getFill());
						((Circle) tempShape).setEdge(dlgCircle.getEdge());
						if (dlgCircle.isOk()) {
							tempShape.setSelected(false);
							allShapesOnDrawing.set(tempShapeIndex, tempShape);
							pnlDrawing.setShapes(allShapesOnDrawing);
							tempShape.setSelected(true);
							pnlDrawing.setSelected(tempShape);
							pnlDrawing.repaint();
						}
					}

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Nijedan oblik nije selektovan.", "Greška!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		tglbtnObrisi = new JToggleButton("Obriši");
		btnGroup.add(tglbtnObrisi);
		toolBar.add(tglbtnObrisi);
		tglbtnObrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (pnlDrawing.getSelected() != null) {
					if (JOptionPane.showConfirmDialog(new JFrame(),
							"Da li ste sigurni da želite da obrišete selektovani oblik?", "Potvrda",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Shape tempShape = pnlDrawing.getSelected();
						ArrayList<Shape> list = pnlDrawing.getShapes();
						int index = list.indexOf(tempShape);
						list.remove(index);
						pnlDrawing.setShapes(list);
						pnlDrawing.setSelected(null);
						pnlDrawing.repaint();
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Nijedan oblik nije selektovan.", "Greška!",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
				.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

	public JToggleButton getTglbtnTacka() {
		return tglbtnTacka;
	}

	public JToggleButton getTglbtnLinija() {
		return tglbtnLinija;
	}

	public JToggleButton getTglbtnPravougaonik() {
		return tglbtnPravougaonik;
	}

	public JToggleButton getTglbtnKrug() {
		return tglbtnKrug;
	}

	public JToggleButton getTglbtnKrugSaRupom() {
		return tglbtnKrugSaRupom;
	}

	public JToggleButton getTglbtnSelektuj() {
		return tglbtnSelektuj;
	}

	public JToggleButton getTglbtnModifikuj() {
		return tglbtnModifikuj;
	}

	public JToggleButton getTglbtnObrisi() {
		return tglbtnObrisi;
	}
}
