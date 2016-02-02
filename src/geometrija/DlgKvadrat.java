package geometrija;

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

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textStranica;
	private int stranica;
	private Color okvir,unutrasnjost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKvadrat dialog = new DlgKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKvadrat() {
		setModal(true);
		setTitle("Crtanje kvadrata");
		setBounds(100, 100, 253, 169);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 238, 148);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Stranica:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 11, 71, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textStranica = new JTextField();
			textStranica.setBounds(142, 9, 86, 20);
			contentPanel.add(textStranica);
			textStranica.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 92, 238, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							stranica = Integer.parseInt(textStranica.getText());
							if(stranica < 0){
								JOptionPane.showMessageDialog(null, "Ne sme biti negativan broj!", 
										"Error", JOptionPane.ERROR_MESSAGE);
								
								textStranica.setText("");
								textStranica.requestFocus();
							}
							else{
								dispose();
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Niste uneli brojeve!", "Error", JOptionPane.ERROR_MESSAGE);
							textStranica.setText("");
							textStranica.requestFocus();

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblBojaOkvira = new JLabel("Boja okvira:");
			lblBojaOkvira.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBojaOkvira.setBounds(10, 43, 93, 14);
			contentPanel.add(lblBojaOkvira);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
			lblBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBojaUnutrasnjosti.setBounds(10, 67, 119, 14);
			contentPanel.add(lblBojaUnutrasnjosti);
		}
		{
			JButton btnIzaberi1 = new JButton("Izaberi");
			btnIzaberi1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 okvir = JColorChooser.showDialog(null,
				               "Izaberite boju okvira", Color.white);
				}
			});
			btnIzaberi1.setBounds(142, 34, 89, 23);
			contentPanel.add(btnIzaberi1);
		}
		{
			JButton btnIzaberi2 = new JButton("Izaberi");
			btnIzaberi2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					unutrasnjost = JColorChooser.showDialog(null,
				               "Izaberite boju unutrasnjosti", Color.white);
				}
			});
			btnIzaberi2.setBounds(142, 58, 89, 23);
			contentPanel.add(btnIzaberi2);
		}
	}

	public int getStranica() {
		return stranica;
	}

	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

	public Color getOkvir() {
		return okvir;
	}

	public void setOkvir(Color okvir) {
		this.okvir = okvir;
	}

	public Color getUnutrasnjost() {
		return unutrasnjost;
	}

	public void setUnutrasnjost(Color unutrasnjost) {
		this.unutrasnjost = unutrasnjost;
	}

}
