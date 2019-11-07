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

public class DlgDonut extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private JTextField txtR;
	private JTextField txtRRupe;
	private boolean isOk;
	private Color fill;
	private Color edge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		setTitle("Dodavanje kruga sa rupom");
		setBounds(100, 100, 275, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCentarKruga = new JLabel("Centar kruga sa rupom");
		lblCentarKruga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel lblXKoordinata = new JLabel("X koordinata: ");
		JLabel lblYKoordinata = new JLabel("Y koordinata: ");
		JLabel lblPoluprenik = new JLabel("Polupre\u010Dnik:");
		JLabel lblUnutranjiPoluprenik = new JLabel("Polupre\u010Dnik rupe:");

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

		txtRRupe = new JTextField();
		txtRRupe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtRRupe.setColumns(10);

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
						gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
								.createSequentialGroup().addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addGroup(
												gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblCentarKruga).addGroup(
																gl_contentPanel.createSequentialGroup()
																		.addComponent(
																				lblXKoordinata)
																		.addPreferredGap(ComponentPlacement.RELATED, 30,
																				Short.MAX_VALUE)
																		.addComponent(txtXKoordinata,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblYKoordinata)
																		.addComponent(lblPoluprenik))
																.addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(
																				gl_contentPanel.createSequentialGroup()
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								137, Short.MAX_VALUE)
																						.addComponent(txtR,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPanel
																				.createSequentialGroup().addGap(31)
																				.addComponent(txtYKoordinata,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))))))
										.addGroup(gl_contentPanel.createSequentialGroup().addGap(45)
												.addComponent(btnBojaUnutrasnjosti))
										.addGroup(gl_contentPanel.createSequentialGroup().addGap(70)
												.addComponent(btnBojaIvice))
										.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
												.addComponent(lblUnutranjiPoluprenik)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtRRupe,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
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
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblPoluprenik)
								.addComponent(txtR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnutranjiPoluprenik).addComponent(txtRRupe, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE).addComponent(btnBojaIvice)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBojaUnutrasnjosti)
						.addContainerGap()));
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
								|| txtR.getText().isEmpty() || txtRRupe.getText().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(contentPanel, "Niste popunili sva polja.", "Greška",
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (Integer.parseInt(txtR.getText()) > Integer.parseInt(txtRRupe.getText())) {
								isOk = true;
								dispose();
							} else {
								JOptionPane.showMessageDialog(contentPanel, "Poluprečnik mora biti veći od prečnika rupe.", "Greška",
										JOptionPane.ERROR_MESSAGE);
							}
							
							
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

	public JTextField getTxtRRupe() {
		return txtRRupe;
	}

	public void setTxtRRupe(String txtRRupe) {
		this.txtRRupe.setText(txtRRupe);
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
