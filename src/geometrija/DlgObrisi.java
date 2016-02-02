package geometrija;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgObrisi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean odg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgObrisi dialog = new DlgObrisi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgObrisi() {
		setModal(true);
		setTitle("Paznja");
		setBounds(100, 100, 361, 133);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 345, 62);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPitanje = new JLabel("Da li ste sigurni da zelite da obrisete objekat?");
			lblPitanje.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPitanje.setBounds(10, 23, 325, 14);
			contentPanel.add(lblPitanje);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 62, 345, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						odg=true;
						dispose();
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
						odg=false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isOdg() {
		return odg;
	}

	public void setOdg(boolean odg) {
		this.odg = odg;
	}

}
