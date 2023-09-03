import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private double balance;
    private List<String> transactionHistory;

    public BankAccount() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            return true;
        }
        return false;
    }
}

class ATMGUI extends JFrame {
    private BankAccount account;

    private JTextField amountField;
    private JTextArea displayArea;

    public ATMGUI(BankAccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel amountLabel = new JLabel("Enter amount: ");
        amountField = new JTextField(10);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton balanceButton = new JButton("Check Balance");
        JButton miniStatementButton = new JButton("Mini Statement");
        topPanel.add(amountLabel);
        topPanel.add(amountField);
        topPanel.add(withdrawButton);
        topPanel.add(depositButton);
        topPanel.add(balanceButton);
        topPanel.add(miniStatementButton);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (account.withdraw(amount)) {
                        displayMessage("Withdrawn: ₹" + amount);
                    } else {
                        displayMessage("Insufficient balance.");
                    }
                } catch (NumberFormatException ex) {
                    displayMessage("Invalid input.");
                }
                amountField.setText("");
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    displayMessage("Deposited: ₹" + amount);
                } catch (NumberFormatException ex) {
                    displayMessage("Invalid input.");
                }
                amountField.setText("");
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayMessage("Account Balance: ₹" + account.getBalance());
            }
        });

        miniStatementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArea.append("Mini Statement:\n");
                List<String> transactions = account.getTransactionHistory();
                int numTransactions = transactions.size();
                int startIndex = Math.max(0, numTransactions - 10);
                for (int i = startIndex; i < numTransactions; i++) {
                    displayArea.append(transactions.get(i) + "\n");
                }
            }
        });
    }

    private void displayMessage(String message) {
        displayArea.append(message + "\n");
    }
}

public class Task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ATMGUI atm = new ATMGUI(account);
        atm.setVisible(true);
    }
}
