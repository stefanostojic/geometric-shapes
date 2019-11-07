package stack;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class FrmStack extends JFrame {

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
					FrmStack frame = new FrmStack();
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
	public FrmStack() {
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
				DlgStack dlgStack = new DlgStack();
				dlgStack.setTitle("Dodavanje");
				dlgStack.setVisible(true);
				if (dlgStack.isOk) {
					dlm.add(0, new Rectangle(new Point(Integer.parseInt(dlgStack.getTxtXKoordinata().getText()), Integer.parseInt(dlgStack.getTxtYKoordinata().getText())), Integer.parseInt(dlgStack.getTxtVisina().getText()), Integer.parseInt(dlgStack.getTxtSirina().getText())));
				}
			}
		});
		
		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(pnlCentar, "Stek je prazan.", "Greska", JOptionPane.ERROR_MESSAGE);
				} else {
					DlgStack dlgStackBrisanje = new DlgStack();
					
					dlgStackBrisanje.getTxtXKoordinata().setText(Integer.toString(dlm.getElementAt(0).getUpperLeftPoint().getX()));
					dlgStackBrisanje.getTxtXKoordinata().setEnabled(false);
					dlgStackBrisanje.getTxtYKoordinata().setText(Integer.toString(dlm.getElementAt(0).getUpperLeftPoint().getY()));
					dlgStackBrisanje.getTxtYKoordinata().setEnabled(false);
					dlgStackBrisanje.getTxtVisina().setText(Integer.toString(dlm.getElementAt(0).getHeight()));
					dlgStackBrisanje.getTxtVisina().setEnabled(false);
					dlgStackBrisanje.getTxtSirina().setText(Integer.toString(dlm.getElementAt(0).getWidth()));
					dlgStackBrisanje.getTxtSirina().setEnabled(false);
					
					dlgStackBrisanje.setTitle("Brisanje");
					dlgStackBrisanje.setLblUpozorenje("Obriši?");
					dlgStackBrisanje.getLblUpozorenje().setForeground(Color.RED);
					dlgStackBrisanje.setVisible(true);
					if (dlgStackBrisanje.getIsOk())
						dlm.removeElementAt(0);
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
					.addComponent(btnIzuzmi)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_pnlJug.setVerticalGroup(
			gl_pnlJug.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlJug.createSequentialGroup()
					.addGroup(gl_pnlJug.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodaj)
						.addComponent(btnIzuzmi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlJug.setLayout(gl_pnlJug);
		
	}
}
