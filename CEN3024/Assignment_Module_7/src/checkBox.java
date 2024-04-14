import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class checkBox {

	public static void main(String[] args) {

		new checkBox();

	}

	public checkBox() {

		// LAYOUT
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);

		// FRAMES
		JFrame frame = new JFrame("ORDER");
		JFrame frame2 = new JFrame("TOTAL");
		frame.setSize(400, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(400, 400);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// BUTTONS
		JButton b1 = new JButton();
		b1.setSize(50, 50);
		b1.setText("Order");

		// TEXT ENTRY
		JTextField text = new JTextField(20);

		// CHECKBOXES
		Checkbox c1 = new Checkbox("Cheeseburger \t\t $4.50");
		Checkbox c2 = new Checkbox("Bacon Cheeseburger \t\t $5.50");
		Checkbox c3 = new Checkbox("French Fries \t\t $3.00");
		Checkbox c4 = new Checkbox("Onion Rings \t\t $3.50");
		Checkbox c5 = new Checkbox("Fountain Drink \t\t $2.99");
		Checkbox c6 = new Checkbox("Ice-Cream Shake \t\t $5.50");
		Checkbox c7 = new Checkbox("Mega Burger \t\t $9.50");
		Checkbox c8 = new Checkbox("Ultra Mega Burger \t\t $25.00");

		// LABELS
		JLabel label1 = new JLabel("Cheeseburger \t\t $4.50");
		JLabel label2 = new JLabel("Bacon Cheeseburger \t\t $5.50");
		JLabel label3 = new JLabel("French Fries \t\t $3.00");
		JLabel label4 = new JLabel("Onion Rings \t\t $3.50");
		JLabel label5 = new JLabel("Fountain Drink \t\t $2.99");
		JLabel label6 = new JLabel("Ice-Cream Shake \t\t $5.50");
		JLabel label7 = new JLabel("Mega Burger \t\t $9.50");
		JLabel label8 = new JLabel("Ultra Mega Burger \t\t $25.00");
		JLabel labelTop = new JLabel("***************************");
		JLabel labelBot = new JLabel("***************************");

		frame.add(c1);
		c1.setBounds(50, 50, 250, 30);
		frame.add(c2);
		c2.setBounds(50, 100, 250, 30);
		frame.add(c3);
		c3.setBounds(50, 150, 250, 30);
		frame.add(c4);
		c4.setBounds(50, 200, 250, 30);
		frame.add(c5);
		c5.setBounds(50, 250, 250, 30);
		frame.add(c6);
		c6.setBounds(50, 300, 250, 30);
		frame.add(c7);
		c7.setBounds(50, 350, 250, 30);
		frame.add(c8);
		c8.setBounds(50, 400, 250, 30);
		frame.add(text);
		text.setBounds(50, 450, 250, 30);
		frame.add(b1);
		b1.setBounds(75, 500, 250, 30);

		frame.setLayout(null);
		frame.setVisible(true);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.add(labelTop);
				String instructions = text.getText();
				DecimalFormat df = new DecimalFormat("0.00");
				double total = 0;

				if (c1.getState()) {
					panel.add(label1);
					total += 4.50;
				}
				if (c2.getState()) {
					panel.add(label2);
					total += 5.50;
				}
				if (c3.getState()) {
					panel.add(label3);
					total += 3.00;
				}
				if (c4.getState()) {
					panel.add(label4);
					total += 3.50;
				}
				if (c5.getState()) {
					panel.add(label5);
					total += 2.99;
				}
				if (c6.getState()) {
					panel.add(label6);
					total += 5.50;
				}
				if (c7.getState()) {
					panel.add(label7);
					total += 9.50;
				}
				if (c8.getState()) {
					panel.add(label8);
					total += 25.00;
				}
				JLabel labelInstructions = new JLabel("Special Instructions: " + instructions);
				JLabel labelTotal = new JLabel("Your Total is: $" + df.format(total));
				panel.add(labelBot);
				panel.add(labelInstructions);
				panel.add(labelTotal);
				frame2.add(panel);
				frame2.setVisible(true);
			}
		});
	}
}
