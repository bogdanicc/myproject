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
import java.awt.Panel;
import java.awt.Color;

public class DlgPomeri extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textPomeriPoX;
	private JTextField textPomeriPoY;
	private int pomeriX, pomeriY, x, y;
	private JTextField textPomeriNaX;
	private JTextField textPomeriNaY;
	private boolean stanje;

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
		setBounds(100, 100, 385, 215);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 369, 144);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblPomeriPoX = new JLabel("Pomeri po X osi:");
		lblPomeriPoX.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPomeriPoX.setBounds(10, 11, 99, 14);
		contentPanel.add(lblPomeriPoX);

		JLabel lblPomeriPoY = new JLabel("Pomeri po Y osi:");
		lblPomeriPoY.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPomeriPoY.setBounds(10, 36, 99, 14);
		contentPanel.add(lblPomeriPoY);

		textPomeriPoX = new JTextField();
		textPomeriPoX.setBounds(144, 9, 86, 20);
		contentPanel.add(textPomeriPoX);
		textPomeriPoX.setColumns(10);

		textPomeriPoY = new JTextField();
		textPomeriPoY.setBounds(144, 34, 86, 20);
		contentPanel.add(textPomeriPoY);
		textPomeriPoY.setColumns(10);

		JButton btnPomeriZa = new JButton("PomeriZa");
		btnPomeriZa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pomeriX = Integer.parseInt(textPomeriPoX.getText());
					pomeriY = Integer.parseInt(textPomeriPoY.getText());
					dispose();
					stanje = true;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Niste uneli brojeve!", "Error", JOptionPane.ERROR_MESSAGE);
					textPomeriNaX.setText("");
					textPomeriNaY.setText("");
					textPomeriPoX.setText("");
					textPomeriPoY.setText("");
					textPomeriPoX.requestFocus();
				}
			}
		});
		btnPomeriZa.setBounds(251, 8, 99, 46);
		contentPanel.add(btnPomeriZa);

		JLabel lblXKoordinata = new JLabel("X koordinata:");
		lblXKoordinata.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblXKoordinata.setBounds(10, 82, 99, 14);
		contentPanel.add(lblXKoordinata);

		JLabel lblYKoordinata = new JLabel("Y koordinata:");
		lblYKoordinata.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYKoordinata.setBounds(10, 107, 99, 14);
		contentPanel.add(lblYKoordinata);

		Panel pnl1 = new Panel();
		pnl1.setBackground(Color.LIGHT_GRAY);
		pnl1.setBounds(0, 71, 369, 5);
		contentPanel.add(pnl1);

		textPomeriNaX = new JTextField();
		textPomeriNaX.setBounds(144, 80, 86, 20);
		contentPanel.add(textPomeriNaX);
		textPomeriNaX.setColumns(10);

		textPomeriNaY = new JTextField();
		textPomeriNaY.setBounds(144, 105, 86, 20);
		contentPanel.add(textPomeriNaY);
		textPomeriNaY.setColumns(10);

		JButton btnPomeriNa = new JButton("PomeriNa");
		btnPomeriNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x = Integer.parseInt(textPomeriNaX.getText());
					y = Integer.parseInt(textPomeriNaY.getText());
					if (x < 0 || y < 0) {
						JOptionPane.showMessageDialog(null, "Brojevi moraju biti pozitivni!", "Error",
								JOptionPane.ERROR_MESSAGE);
						textPomeriNaX.setText("");
						textPomeriNaY.setText("");
						textPomeriPoX.setText("");
						textPomeriPoY.setText("");
						textPomeriNaX.requestFocus();
					} else
						dispose();
					stanje = false;
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Niste uneli brojeve!", "Error", JOptionPane.ERROR_MESSAGE);
					textPomeriNaX.setText("");
					textPomeriNaY.setText("");
					textPomeriPoX.setText("");
					textPomeriPoY.setText("");
					textPomeriNaX.requestFocus();
				}
			}
		});
		btnPomeriNa.setBounds(251, 79, 99, 46);
		contentPanel.add(btnPomeriNa);

		Panel pnl2 = new Panel();
		pnl2.setBackground(Color.LIGHT_GRAY);
		pnl2.setBounds(0, 139, 369, 5);
		contentPanel.add(pnl2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 144, 369, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isStanje() {
		return stanje;
	}

	public void setStanje(boolean stanje) {
		this.stanje = stanje;
	}
}
