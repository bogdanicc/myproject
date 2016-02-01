package geometrija;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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
			lblPoluprecnik.setBounds(10, 48, 98, 25);
			contentPanel.add(lblPoluprecnik);
		}
		{
			textPoluprecnik = new JTextField();
			textPoluprecnik.setBounds(107, 51, 86, 20);
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
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

}
