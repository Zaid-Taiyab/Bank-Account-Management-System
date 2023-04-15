import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankAccountGUI gui = new BankAccountGUI();
            gui.createAndShowGUI();
        });
    }
}

class BankAccountGUI {
    private String accountType;
    private JFrame frame;
    private JPanel mainPanel;
    private JComboBox<String> accountTypeComboBox;
    private JButton selectAccountButton;
    private JTextField accountIdField;
    private JTextField amountField;
    private JButton performActionButton;
    private JTextArea accountInfoTextArea;
    private JComboBox<String> actionComboBox;

    public void createAndShowGUI() {
        frame = new JFrame("Bank Account Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2));
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(new JLabel("Account Type:"));
        accountTypeComboBox = new JComboBox<>(new String[]{"Checking Account", "Savings Account", "Credit Card Account"});
        accountTypeComboBox.addItemListener(new AccountTypeListener()); // Add this line
        mainPanel.add(accountTypeComboBox);

        mainPanel.add(new JLabel("Account ID:"));
        accountIdField = new JTextField();
        mainPanel.add(accountIdField);

        mainPanel.add(new JLabel("Action:"));
        actionComboBox = new JComboBox<>(new String[]{"Withdraw", "Deposit", "Make Payment"});
        mainPanel.add(actionComboBox);

        mainPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        mainPanel.add(amountField);

        performActionButton = new JButton("Perform Action");
        mainPanel.add(performActionButton);

        accountInfoTextArea = new JTextArea();
        accountInfoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(accountInfoTextArea);
        frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);

        performActionButton.addActionListener(new PerformActionListener());
        frame.setVisible(true);
    }
    class AccountTypeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                accountType = (String) e.getItem();
            }
        }
    }


    class PerformActionListener implements ActionListener {
        private BankAccount account;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (account == null) {
                createAccount();
            } else {
                performAction();
            }
        }

        private void createAccount() {
            String accountType = (String) accountTypeComboBox.getSelectedItem();
            String accountId = accountIdField.getText();
            if (accountId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an Account ID.");
                return;
            }
            switch (accountType) {
                case "Checking Account":
                    account = new CheckingAccount();
                    break;
                case "Savings Account":
                    account = new SavingsAccount();
                    break;
                case "Credit Card Account":
                    account = new CreditcardAccount();
                    break;
            }
            account.setAccountID(accountId);
            accountInfoTextArea.setText(account.accountInfo());
            accountInfoTextArea.repaint(); // Add this line to refresh the JTextArea
            performActionButton.setText("Perform Action");
        }

        private void performAction() {
            String action = (String) actionComboBox.getSelectedItem();
            double amount;
            try {
                amount = Double.parseDouble(amountField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
                return;
            }
            switch (action) {
                case "Withdraw":
                    account.withdraw(amount);
                    break;
                case "Deposit":
                    account.deposit(amount);
                    break;
                case "Make Payment":
                    if (account instanceof CreditcardAccount) {
                        ((CreditcardAccount) account).Payment(amount);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Make Payment is only applicable to Credit Card Accounts.");
                        return;
                    }
                    break;
            }
            accountInfoTextArea.setText(account.accountInfo());
            accountInfoTextArea.repaint(); // Add this line to refresh the JTextArea
        }
    }
}
