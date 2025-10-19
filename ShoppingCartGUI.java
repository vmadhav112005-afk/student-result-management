import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartGUI extends JFrame {

    private JCheckBox laptopCheckBox;
    private JCheckBox phoneCheckBox;
    private JCheckBox headphonesCheckBox;
    private JButton generateBillButton;

    private Map<String, Double> prices;

    public ShoppingCartGUI() {
        setTitle("Shopping Cart");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        prices = new HashMap<String, Double>();
        prices.put("Laptop", 1000.00);
        prices.put("Phone", 500.00);
        prices.put("Headphones", 100.00);

        laptopCheckBox = new JCheckBox("Laptop - $" + prices.get("Laptop"));
        phoneCheckBox = new JCheckBox("Phone - $" + prices.get("Phone"));
        headphonesCheckBox = new JCheckBox("Headphones - $" + prices.get("Headphones"));
        generateBillButton = new JButton("Generate Bill");

        add(laptopCheckBox);
        add(phoneCheckBox);
        add(headphonesCheckBox);
        add(Box.createVerticalStrut(10));
        add(generateBillButton);

        // ActionListener implemented as an anonymous inner class
        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });

        setVisible(true);
    }

    private void generateBill() {
        StringBuilder bill = new StringBuilder("Your Bill:\n");
        double total = 0.0;

        if (laptopCheckBox.isSelected()) {
            bill.append("- Laptop: $1000.00\n");
            total += prices.get("Laptop");
        }
        if (phoneCheckBox.isSelected()) {
            bill.append("- Phone: $500.00\n");
            total += prices.get("Phone");
        }
        if (headphonesCheckBox.isSelected()) {
            bill.append("- Headphones: $100.00\n");
            total += prices.get("Headphones");
        }

        bill.append("\nTotal: $" + String.format("%.2f", total));
        JOptionPane.showMessageDialog(this, bill.toString(), "Bill Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCartGUI();
            }
        });
    }
}