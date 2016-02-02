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
import java.awt.HeadlessException;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textPoluprecnik;
	private int poluprecnik;
	private Color okvir,unutrasnjost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKrug dialog = new DlgKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKrug() {
		setModal(true);
		setTitle("Crtanje kruga");
		setBounds(100, 100, 318, 183);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPoluprecnik = new JLabel("Poluprecnik:");
			lblPoluprecnik.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPoluprecnik.setBounds(10, 11, 98, 25);
			contentPanel.add(lblPoluprecnik);
		}
		{
			textPoluprecnik = new JTextField();
			textPoluprecnik.setBounds(151, 14, 86, 20);
			contentPanel.add(textPoluprecnik);
			textPoluprecnik.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(-135, 110, 434, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							poluprecnik = Integer.parseInt(textPoluprecnik.getText());
							if(poluprecnik > 0)
							{
								dispose();
							}
							else
							{							
								JOptionPane.showMessageDialog(null, "Broj mora biti pozitivan", "Error", JOptionPane.ERROR_MESSAGE);
								textPoluprecnik.setText("");
								textPoluprecnik.requestFocus();
							}

						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Niste uneli brojeve!", "Error", JOptionPane.ERROR_MESSAGE);
							textPoluprecnik.setText("");
							textPoluprecnik.requestFocus();
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
			lblBojaOkvira.setBounds(10, 47, 98, 14);
			contentPanel.add(lblBojaOkvira);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
			lblBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBojaUnutrasnjosti.setBounds(10, 74, 118, 14);
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
			btnIzaberi1.setBounds(151, 44, 89, 23);
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
			btnIzaberi2.setBounds(151, 71, 89, 23);
			contentPanel.add(btnIzaberi2);
		}
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
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
