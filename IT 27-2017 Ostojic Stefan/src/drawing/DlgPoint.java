package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private boolean isOk;
	private Color edge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setModal(true);
		setTitle("Dodavanje ta\u010Dke");
		setModal(true);
		setBounds(100, 100, 255, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblXKoordinata = new JLabel("X koordinata: ");

		txtXKoordinata = new JTextField();
		txtXKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtXKoordinata.setColumns(10);

		JLabel lblYKoordinata = new JLabel("Y koordinata: ");

		txtYKoordinata = new JTextField();
		txtYKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtYKoordinata.setColumns(10);

		JButton btnBoja = new JButton("Boja");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edge = JColorChooser.showDialog(contentPanel, "Odaberi boju tačke", Color.WHITE);
				System.out.println(edge);
			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPanel
												.createSequentialGroup().addGroup(gl_contentPanel
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
																.createSequentialGroup().addContainerGap()
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblYKoordinata)
																		.addComponent(lblXKoordinata))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtXKoordinata,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtYKoordinata,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(78)
																.addComponent(btnBoja)))
												.addContainerGap(13, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXKoordinata)
								.addComponent(txtXKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYKoordinata)
								.addComponent(txtYKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnBoja)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtXKoordinata.getText().isEmpty() || txtYKoordinata.getText().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(contentPanel, "Niste popunili sva polja.", "Greška",
									JOptionPane.ERROR_MESSAGE);
						} else {
							isOk = true;
							dispose();
						}
					}
				});
				btnDodaj.setActionCommand("OK");
				buttonPane.add(btnDodaj);
				getRootPane().setDefaultButton(btnDodaj);
			}
			{
				JButton cancelButton = new JButton("Odustani");
				cancelButton.setActionCommand("btnOdustani");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtXKoordinata() {
		return txtXKoordinata;
	}

	public JTextField getTxtYKoordinata() {
		return txtYKoordinata;
	}

	public boolean isOk() {
		return isOk;
	}

	public Color getEdge() {
		return edge;
	}

	public void setTxtXKoordinata(String txtXKoordinata) {
		this.txtXKoordinata.setText(txtXKoordinata);
	}

	public void setTxtYKoordinata(String txtYKoordinata) {
		this.txtYKoordinata.setText(txtYKoordinata);
	}

	public void setEdge(Color edge) {
		this.edge = edge;
	}
}
