package netzwerkerfassung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;

public class BearbeitenDialog extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BearbeitenDialog dialog = new BearbeitenDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BearbeitenDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton jBtnBearbeiten = new JButton("Bearbeiten");
				buttonPane.add(jBtnBearbeiten);
			}
			{
				JButton jBtnLoeschen = new JButton("L\u00F6schen");
				buttonPane.add(jBtnLoeschen);
			}
			{
				JButton jBtnOk = new JButton("OK");
				jBtnOk.setActionCommand("OK");
				buttonPane.add(jBtnOk);
				getRootPane().setDefaultButton(jBtnOk);
			}
			{
				JButton jBtnCancel = new JButton("Cancel");
				jBtnCancel.setActionCommand("Cancel");
				buttonPane.add(jBtnCancel);
			}
		}
		{
			table = new JTable();
			getContentPane().add(table, BorderLayout.CENTER);
		}
	}

}
