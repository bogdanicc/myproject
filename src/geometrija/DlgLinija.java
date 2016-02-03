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

public class DlgLinija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textXTpocetno;
	private JTextField textYTpocetno;
	private JTextField textXTkrajnje;
	private JTextField textYTkrajnje;
	private Color boja;
	private int XTpocetno, XTkrajnje, YTpocetno, YTkrajnje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLinija dialog = new DlgLinija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLinija() {
		setModal(true);
		setBounds(100, 100, 300, 226);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 284, 155);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblXTpocetno = new JLabel("X Tpocetno:");
			lblXTpocetno.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblXTpocetno.setBounds(10, 22, 84, 14);
			contentPanel.add(lblXTpocetno);
		}
		{
			JLabel lblYTpocetno = new JLabel("Y Tpocetno:");
			lblYTpocetno.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblYTpocetno.setBounds(10, 44, 84, 14);
			contentPanel.add(lblYTpocetno);
		}
		{
			JLabel lblXTkrajnje = new JLabel("X Tkrajnje:");
			lblXTkrajnje.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblXTkrajnje.setBounds(10, 65, 84, 14);
			contentPanel.add(lblXTkrajnje);
		}
		{
			JLabel lblYTkrajnje = new JLabel("Y Tkrajnje:");
			lblYTkrajnje.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblYTkrajnje.setBounds(10, 85, 84, 14);
			contentPanel.add(lblYTkrajnje);
		}
		{
			JLabel lblBoja = new JLabel("Boja:");
			lblBoja.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBoja.setBounds(10, 110, 46, 14);
			contentPanel.add(lblBoja);
		}
		{
			textXTpocetno = new JTextField();
			textXTpocetno.setBounds(129, 20, 86, 20);
			contentPanel.add(textXTpocetno);
			textXTpocetno.setColumns(10);
		}
		{
			textYTpocetno = new JTextField();
			textYTpocetno.setBounds(129, 42, 86, 20);
			contentPanel.add(textYTpocetno);
			textYTpocetno.setColumns(10);
		}
		{
			textXTkrajnje = new JTextField();
			textXTkrajnje.setBounds(129, 63, 86, 20);
			contentPanel.add(textXTkrajnje);
			textXTkrajnje.setColumns(10);
		}
		{
			textYTkrajnje = new JTextField();
			textYTkrajnje.setBounds(129, 83, 86, 20);
			contentPanel.add(textYTkrajnje);
			textYTkrajnje.setColumns(10);
		}

		JButton btnIzaberi = new JButton("Izaberi");
		btnIzaberi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boja = JColorChooser.showDialog(null, "Izaberite boju linije", Color.white);
			}
		});
		btnIzaberi.setBounds(126, 107, 89, 23);
		contentPanel.add(btnIzaberi);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 155, 284, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							XTpocetno = Integer.parseInt(textXTpocetno.getText());
							YTpocetno = Integer.parseInt(textYTpocetno.getText());
							XTkrajnje = Integer.parseInt(textXTkrajnje.getText());
							YTkrajnje = Integer.parseInt(textYTkrajnje.getText());
							if (XTpocetno >= 0 && YTpocetno >= 0 && YTpocetno >= 0 && YTkrajnje >= 0) {
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Brojevi moraju biti pozitivni!", "Error",
										JOptionPane.ERROR_MESSAGE);
								textXTkrajnje.setText("");
								textXTpocetno.setText("");
								textYTkrajnje.setText("");
								textYTpocetno.setText("");
								textXTpocetno.requestFocus();
							}

						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Niste uneli brojeve!", "Error",
									JOptionPane.ERROR_MESSAGE);
							textXTkrajnje.setText("");
							textXTpocetno.setText("");
							textYTkrajnje.setText("");
							textYTpocetno.setText("");
							textXTpocetno.requestFocus();
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

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	public int getXTpocetno() {
		return XTpocetno;
	}

	public void setXTpocetno(int xTpocetno) {
		XTpocetno = xTpocetno;
	}

	public int getXTkrajnje() {
		return XTkrajnje;
	}

	public void setXTkrajnje(int xTkrajnje) {
		XTkrajnje = xTkrajnje;
	}

	public int getYTpocetno() {
		return YTpocetno;
	}

	public void setYTpocetno(int yTpocetno) {
		YTpocetno = yTpocetno;
	}

	public int getYTkrajnje() {
		return YTkrajnje;
	}

	public void setYTkrajnje(int yTkrajnje) {
		YTkrajnje = yTkrajnje;
	}
}
