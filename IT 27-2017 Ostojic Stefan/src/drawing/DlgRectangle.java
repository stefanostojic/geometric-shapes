package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private boolean isOk;
	private Color fill;
	private Color edge;
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private JTextField txtVisina;
	private JTextField txtSirina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setTitle("Dodavanje pravougaonika");
		setBounds(100, 100, 290, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblTakaGoreLevo = new JLabel("Ta\u010Dka gore levo");
		lblTakaGoreLevo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel lblXKoordinata = new JLabel("X koordinata: ");
		JLabel lblYKoordinata = new JLabel("Y koordinata: ");
		JLabel lblVisina = new JLabel("Visina: ");
		JLabel lblirina = new JLabel("\u0160irina: ");

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

		txtVisina = new JTextField();
		txtVisina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtVisina.setColumns(10);

		txtSirina = new JTextField();
		txtSirina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtSirina.setColumns(10);

		JButton btnBojaIvice = new JButton("Boja ivice");
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edge = JColorChooser.showDialog(contentPanel, "Odaberi boju ivice", Color.WHITE);
			}
		});

		JButton btnBojaUnutrasnjosti = new JButton("Boja unutra\u0161njosti");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(contentPanel, "Odaberi boju unutrašnjosti", Color.WHITE);
			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
										.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
												.createSequentialGroup().addContainerGap().addGroup(gl_contentPanel
														.createParallelGroup(Alignment.LEADING)
														.addComponent(
																lblTakaGoreLevo)
														.addGroup(
																gl_contentPanel.createSequentialGroup()
																		.addComponent(lblXKoordinata)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(txtXKoordinata,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPanel.createSequentialGroup().addGroup(
																gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblYKoordinata)
																		.addComponent(lblVisina)
																		.addComponent(lblirina))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtSirina,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtVisina,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtYKoordinata,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))))
										.addGroup(gl_contentPanel.createSequentialGroup().addGap(74)
												.addComponent(btnBojaIvice))
										.addGroup(gl_contentPanel.createSequentialGroup().addGap(48)
												.addComponent(btnBojaUnutrasnjosti)))
										.addContainerGap(48, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblTakaGoreLevo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXKoordinata)
								.addComponent(txtXKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYKoordinata).addComponent(txtYKoordinata, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVisina).addComponent(txtVisina, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblirina)
								.addComponent(txtSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnBojaIvice)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBojaUnutrasnjosti)
						.addContainerGap(21, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXKoordinata.getText().isEmpty() || txtYKoordinata.getText().isEmpty()
								|| txtVisina.getText().isEmpty() || txtSirina.getText().isEmpty()) {
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("btnOdustani");
				buttonPane.add(cancelButton);
			}
		}
	}

	/*public JTextField getTxtStartXKoordinata() {
		return txtStartXKoordinata;
	}

	public JTextField getTxtStartYKoordinata() {
		return txtStartYKoordinata;
	}

	public JTextField getTxtEndXKoordinata() {
		return txtEndXKoordinata;
	}

	public JTextField getTxtEndYKoordinata() {
		return txtEndYKoordinata;
	}*/

	public boolean isOk() {
		return isOk;
	}

	public Color getFill() {
		return fill;
	}

	public Color getEdge() {
		return edge;
	}

	public JTextField getTxtXKoordinata() {
		return txtXKoordinata;
	}

	public JTextField getTxtYKoordinata() {
		return txtYKoordinata;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	/*public void setTxtStartXKoordinata(JTextField txtStartXKoordinata) {
		this.txtStartXKoordinata = txtStartXKoordinata;
	}

	public void setTxtStartYKoordinata(JTextField txtStartYKoordinata) {
		this.txtStartYKoordinata = txtStartYKoordinata;
	}

	public void setTxtEndXKoordinata(JTextField txtEndXKoordinata) {
		this.txtEndXKoordinata = txtEndXKoordinata;
	}

	public void setTxtEndYKoordinata(JTextField txtEndYKoordinata) {
		this.txtEndYKoordinata = txtEndYKoordinata;
	}*/

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public void setEdge(Color edge) {
		this.edge = edge;
	}

	public void setTxtXKoordinata(String txtXKoordinata) {
		this.txtXKoordinata.setText(txtXKoordinata);
	}

	public void setTxtYKoordinata(String txtYKoordinata) {
		this.txtYKoordinata.setText(txtYKoordinata);
	}

	public void setTxtVisina(String txtVisina) {
		this.txtVisina.setText(txtVisina);
	}

	public void setTxtSirina(String txtSirina) {
		this.txtSirina.setText(txtSirina);
	}
}
