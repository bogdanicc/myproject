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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textStranica;
	private JTextField textVisina;
	private int stranica,visina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPravougaonik dialog = new DlgPravougaonik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPravougaonik() {
		setBounds(100, 100, 270, 177);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 254, 106);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Stranica:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 26, 72, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblVisina = new JLabel("Visina:");
			lblVisina.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblVisina.setBounds(10, 51, 57, 20);
			contentPanel.add(lblVisina);
		}
		{
			textStranica = new JTextField();
			textStranica.setBounds(77, 24, 86, 20);
			contentPanel.add(textStranica);
			textStranica.setColumns(10);
		}
		{
			textVisina = new JTextField();
			textVisina.setBounds(77, 51, 86, 20);
			contentPanel.add(textVisina);
			textVisina.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 106, 254, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							stranica = Integer.parseInt(textStranica.getText());
							visina = Integer.parseInt(textVisina.getText());
							if (stranica < 0 || visina < 0) {
								JOptionPane.showMessageDialog(null, "Ne sme biti negativan broj!", "Error",
										JOptionPane.ERROR_MESSAGE);

								textStranica.setText("");
								textVisina.setText("");
								textStranica.requestFocus();

							} else {
								dispose();
							}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							// e.printStackTrace();

							JOptionPane.showMessageDialog(null, "Morate uneti brojeve!", "Error",
									JOptionPane.ERROR_MESSAGE);
							textStranica.setText("");
							textVisina.setText("");
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
	}

	public int getStranica() {
		return stranica;
	}

	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

}
