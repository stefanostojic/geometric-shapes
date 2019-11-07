package stack;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DlgStack extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private JTextField txtVisina;
	private JTextField txtSirina;
	public boolean isOk;
	private JLabel lblUpozorenje;

	/**
	 * Launch the application. Implementirati Java Swing aplikaciju koja
	 * omogućava: ● dodavanje objekata klase Rectangle na stek i ● izuzimanje
	 * objekata klase Rectangle sa steka. Za kreiranje i dodavanje objekta klase
	 * Rectangle na stek obezbediti modalan dijalog koji korisniku omogućava
	 * postavljanje osobina pravougaonika (X, Y koordinate tačke gore levo,
	 * visina, širina) na odgovarajuće vrednosti. Objekte prikazivati u J List
	 * po principu LIFO – Last In First Out (poslednji dodat mora biti na vrhu
	 * liste). Prilikom izuzimanja objekta sa steka potrebno je da aplikacija
	 * prikaže isti dijalog, sa popunjenim konkretnim vrednostima osobina tog
	 * objekta.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setModal(true);
		setBounds(100, 100, 217, 273);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblXKoordinata = new JLabel("X koordinata: ");

		JLabel lblYKoordinata = new JLabel("Y koordinata:");

		JLabel lblVisina = new JLabel("Visina: ");

		JLabel lblirina = new JLabel("Širina: ");

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
		
		lblUpozorenje = new JLabel("");

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblXKoordinata)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtXKoordinata, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblYKoordinata)
										.addComponent(lblVisina)
										.addComponent(lblirina))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtYKoordinata, 0, 0, Short.MAX_VALUE)
										.addComponent(txtSirina, 0, 0, Short.MAX_VALUE)
										.addComponent(txtVisina, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(70)
							.addComponent(lblUpozorenje)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXKoordinata)
						.addComponent(txtXKoordinata, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYKoordinata)
						.addComponent(txtYKoordinata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVisina)
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblirina)
						.addComponent(txtSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblUpozorenje))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Ulazak 1");
						if (txtXKoordinata.getText().isEmpty() || txtYKoordinata.getText().isEmpty()
								|| txtVisina.getText().isEmpty() || txtSirina.getText().isEmpty()) {
							System.out.println("Ulazak 2");
							isOk = false;
							setVisible(true);/**/
							JOptionPane.showMessageDialog(getContentPane(), "Niste popunili sva polja.", "Greška",
									JOptionPane.ERROR_MESSAGE);
						} else {
							System.out.println("Ulazak 3");
							if (Integer.parseInt(txtVisina.getText()) > 0
									&& Integer.parseInt(txtSirina.getText()) > 0) {
								System.out.println("Ulazak 4");
								isOk = true;
								dispose();
							} else {
								System.out.println("Ulazak 5");
								JOptionPane.showMessageDialog(getContentPane(),
										"Visina i širina moraju biti veći od 0.", 
										"Greška", 
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(21)
						.addComponent(btnPotvrdi)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnOdustani)
						.addGap(60))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPotvrdi)
							.addComponent(btnOdustani))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXKoordinata() {
		return txtXKoordinata;
	}

	public void setTxtXKoordinata(JTextField txtXKoordinata) {
		this.txtXKoordinata = txtXKoordinata;
	}

	public JTextField getTxtYKoordinata() {
		return txtYKoordinata;
	}

	public void setTxtYKoordinata(JTextField txtYKoordinata) {
		this.txtYKoordinata = txtYKoordinata;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public void setTxtSirina(JTextField txtSirina) {
		this.txtSirina = txtSirina;
	}

	public Boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}

	public JLabel getLblUpozorenje() {
		return lblUpozorenje;
	}

	public void setLblUpozorenje(String upozorenje) {
		this.lblUpozorenje.setText(upozorenje);
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
