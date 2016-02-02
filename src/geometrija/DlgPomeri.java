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

public class DlgPomeri extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textPomeriPoX;
	private JTextField textPomeriPoY;
	private int pomeriX,pomeriY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPomeri dialog = new DlgPomeri();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPomeri() {
		setModal(true);
		setTitle("Pomeri");
		setBounds(100, 100, 284, 215);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 268, 144);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblPomeriPoX = new JLabel("Pomeri po X osi:");
		lblPomeriPoX.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPomeriPoX.setBounds(10, 31, 99, 14);
		contentPanel.add(lblPomeriPoX);
		
		JLabel lblPomeriPoY = new JLabel("Pomeri po Y osi:");
		lblPomeriPoY.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPomeriPoY.setBounds(10, 66, 99, 14);
		contentPanel.add(lblPomeriPoY);
		
		textPomeriPoX = new JTextField();
		textPomeriPoX.setBounds(144, 29, 86, 20);
		contentPanel.add(textPomeriPoX);
		textPomeriPoX.setColumns(10);
		
		textPomeriPoY = new JTextField();
		textPomeriPoY.setBounds(144, 64, 86, 20);
		contentPanel.add(textPomeriPoY);
		textPomeriPoY.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 144, 268, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							pomeriX=Integer.parseInt(textPomeriPoX.getText());
							pomeriY=Integer.parseInt(textPomeriPoY.getText());
							dispose();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Niste uneli brojeve!", "Error", JOptionPane.ERROR_MESSAGE);
							textPomeriPoX.setText("");
							textPomeriPoY.setText("");
							textPomeriPoX.requestFocus();
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public int getPomeriX() {
		return pomeriX;
	}

	public void setPomeriX(int pomeriX) {
		this.pomeriX = pomeriX;
	}

	public int getPomeriY() {
		return pomeriY;
	}

	public void setPomeriY(int pomeriY) {
		this.pomeriY = pomeriY;
	}
}
