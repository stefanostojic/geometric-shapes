package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtStartXKoordinata;
	private JTextField txtStartYKoordinata;
	private JTextField txtEndXKoordinata;
	private JTextField txtEndYKoordinata;
	private boolean isOk;
	private Color edge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setTitle("Dodavanje linije");
		setBounds(100, 100, 255, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Po\u010Detna ta\u010Dka");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		JLabel lblXKoordinata = new JLabel("X koordinata: ");
		JLabel lblYKoordinata = new JLabel("Y koordinata: ");
		JLabel lblKrajnjaTaka = new JLabel("Krajnja ta\u010Dka");
		lblKrajnjaTaka.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel lblXKoordinata_1 = new JLabel("X koordinata");
		JLabel lblYKoordinata_1 = new JLabel("Y koordinata: ");

		txtStartXKoordinata = new JTextField();
		txtStartXKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtStartXKoordinata.setColumns(10);

		txtStartYKoordinata = new JTextField();
		txtStartYKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtStartYKoordinata.setColumns(10);

		txtEndXKoordinata = new JTextField();
		txtEndXKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtEndXKoordinata.setColumns(10);

		txtEndYKoordinata = new JTextField();
		txtEndYKoordinata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtEndYKoordinata.setColumns(10);

		JButton btnBoja = new JButton("Boja");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edge = JColorChooser.showDialog(contentPanel, "Odaberi boju linije", Color.WHITE);
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
																		.addGroup(gl_contentPanel
																				.createSequentialGroup()
																				.addComponent(lblXKoordinata)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(txtStartXKoordinata,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPanel
																				.createSequentialGroup()
																				.addComponent(lblYKoordinata)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(txtStartYKoordinata,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPanel
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addGroup(gl_contentPanel
																						.createSequentialGroup()
																						.addComponent(lblXKoordinata_1)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								20, Short.MAX_VALUE)
																						.addComponent(txtEndXKoordinata,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																				.addGroup(gl_contentPanel
																						.createSequentialGroup()
																						.addComponent(lblYKoordinata_1)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(txtEndYKoordinata,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(63)
																.addComponent(lblNewLabel))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(65)
																.addComponent(lblKrajnjaTaka))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(80)
																.addComponent(btnBoja)))
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXKoordinata)
								.addComponent(txtStartXKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYKoordinata)
								.addComponent(txtStartYKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblKrajnjaTaka)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXKoordinata_1)
								.addComponent(txtEndXKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYKoordinata_1)
								.addComponent(txtEndYKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnBoja)
						.addContainerGap(22, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtStartXKoordinata.getText().isEmpty() || txtStartYKoordinata.getText().isEmpty()
								|| txtEndXKoordinata.getText().isEmpty() || txtEndYKoordinata.getText().isEmpty()) {
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
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Cancel");
				buttonPane.add(btnOdustani);
			}
		}
	}

	public JTextField getTxtStartXKoordinata() {
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
	}
	
	public void setTxtStartXKoordinata(String txtStartXKoordinata) {
		this.txtStartXKoordinata.setText(txtStartXKoordinata);
	}

	public void setTxtStartYKoordinata(String txtStartYKoordinata) {
		this.txtStartYKoordinata.setText(txtStartYKoordinata);
	}
	
	public void setTxtEndXKoordinata(String txtEndXKoordinata) {
		this.txtEndXKoordinata.setText(txtEndXKoordinata);
	}

	public void setTxtEndYKoordinata(String txtEndYKoordinata) {
		this.txtEndYKoordinata.setText(txtEndYKoordinata);
	}

	public boolean isOk() {
		return isOk;
	}

	public Color getEdge() {
		return edge;
	}

	public void setEdge(Color edge) {
		this.edge = edge;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
	

}
