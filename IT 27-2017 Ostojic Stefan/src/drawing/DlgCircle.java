package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private JTextField txtR;
	private boolean isOk;
	private Color fill;
	private Color edge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setTitle("Dodavanje kruga");
		setBounds(100, 100, 255, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCentarKruga = new JLabel("Centar kruga");
		lblCentarKruga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel lblXKoordinata = new JLabel("X koordinata: ");
		JLabel lblYKoordinata = new JLabel("Y koordinata: ");
		JLabel lblPoluprenik = new JLabel("Polupre\u010Dnik:");

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

		txtR = new JTextField();
		txtR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtR.setColumns(10);

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
								.addGroup(
										gl_contentPanel
												.createSequentialGroup().addGroup(gl_contentPanel
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
																.createSequentialGroup().addContainerGap()
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblCentarKruga)
																		.addGroup(
																				gl_contentPanel.createSequentialGroup()
																						.addComponent(lblXKoordinata)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(txtXKoordinata,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPanel
																				.createSequentialGroup()
																				.addGroup(gl_contentPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lblYKoordinata)
																						.addComponent(lblPoluprenik))
																				.addGap(14)
																				.addGroup(gl_contentPanel
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(txtYKoordinata,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(txtR,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(45)
																.addComponent(btnBojaUnutrasnjosti))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(67)
																.addComponent(btnBojaIvice)))
												.addContainerGap(5, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblCentarKruga)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXKoordinata)
								.addComponent(txtXKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYKoordinata)
								.addComponent(txtYKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPoluprenik))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnBojaIvice).addGap(13)
						.addComponent(btnBojaUnutrasnjosti).addContainerGap(15, Short.MAX_VALUE)));
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
								|| txtR.getText().isEmpty()) {
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

	public JTextField getTxtXKoordinata() {
		return txtXKoordinata;
	}

	public JTextField getTxtYKoordinata() {
		return txtYKoordinata;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public boolean isOk() {
		return isOk;
	}

	public Color getFill() {
		return fill;
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

	public void setTxtR(String txtR) {
		this.txtR.setText(txtR);
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public void setEdge(Color edge) {
		this.edge = edge;
	}

}
