package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class FrmSort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList<Rectangle> lstRect = new JList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmSort() {
		setTitle("Stack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		pnlCentar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrlRect = new JScrollPane();
		
		lstRect.setModel(dlm);
		
		scrlRect.setViewportView(lstRect);
		pnlCentar.add(scrlRect);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dlgSort = new DlgSort();
				dlgSort.setTitle("Dodavanje");
				dlgSort.setVisible(true);
				if (dlgSort.isOk) {
					dlm.add(0, new Rectangle(new Point(Integer.parseInt(dlgSort.getTxtXKoordinata().getText()), Integer.parseInt(dlgSort.getTxtYKoordinata().getText())), Integer.parseInt(dlgSort.getTxtVisina().getText()), Integer.parseInt(dlgSort.getTxtSirina().getText())));
				}
			}
		});
		
		JButton btnSortiraj = new JButton("Sortiraj");
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(pnlCentar, "Lista je prazna. Nema šta da se sortira.", "Greška", JOptionPane.ERROR_MESSAGE);
				} else {
					List<Rectangle> rectangleList = new ArrayList<Rectangle>();
				    for (int i = 0; i < dlm.size(); i++) {
				        rectangleList.add((Rectangle)dlm.get(i));
				    }
				    Collections.sort(rectangleList);
				    dlm.removeAllElements();
				    for (Rectangle s : rectangleList) {
				        dlm.addElement(s);
				    }
				}
			}
		});
		GroupLayout gl_pnlJug = new GroupLayout(pnlJug);
		gl_pnlJug.setHorizontalGroup(
			gl_pnlJug.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlJug.createSequentialGroup()
					.addGap(60)
					.addComponent(btnDodaj)
					.addGap(18)
					.addComponent(btnSortiraj)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_pnlJug.setVerticalGroup(
			gl_pnlJug.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlJug.createSequentialGroup()
					.addGroup(gl_pnlJug.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodaj)
						.addComponent(btnSortiraj))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlJug.setLayout(gl_pnlJug);
		
	}
}
