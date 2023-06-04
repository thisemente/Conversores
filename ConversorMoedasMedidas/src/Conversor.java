import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Conversor extends JFrame {
    private JTextField inputField;
    private JLabel currencyResultLabel;
    private JLabel measureResultLabel;

    public Conversor() {
        setTitle("Conversor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 490);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 20, 10, 20)); // Aumentando as bordas laterais

        // Bem-vindo ao Conversor
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Bem-vindo ao Conversor");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomePanel.add(welcomeLabel);

        add(welcomePanel, BorderLayout.NORTH);

        // Conversor de moedas
        JPanel currencyPanel = new JPanel();
        currencyPanel.setLayout(new GridLayout(6, 2, 10, 10));
        currencyPanel.setBorder(new EmptyBorder(10, 30, 10, 30));

        JLabel currencyInputLabel = new JLabel("Digite um valor:");
        inputField = new JTextField(10);

        JLabel fromCurrencyLabel = new JLabel("De:");
        JComboBox<String> currencyFromComboBox = new JComboBox<>();
        currencyFromComboBox.addItem("Real");
        currencyFromComboBox.addItem("Dólar");
        currencyFromComboBox.addItem("Euro");
        currencyFromComboBox.addItem("Libra Esterlina");
        currencyFromComboBox.addItem("Peso Argentino");
        currencyFromComboBox.addItem("Peso Chileno");

        JLabel toCurrencyLabel = new JLabel("Para:");
        JComboBox<String> currencyToComboBox = new JComboBox<>();
        currencyToComboBox.addItem("Real");
        currencyToComboBox.addItem("Dólar");
        currencyToComboBox.addItem("Euro");
        currencyToComboBox.addItem("Libra Esterlina");
        currencyToComboBox.addItem("Peso Argentino");
        currencyToComboBox.addItem("Peso Chileno");
                
        JButton currencyConvertButton = new JButton("Converter");
        JButton currencyClearButton = new JButton("Limpar");

        currencyResultLabel = new JLabel();
        currencyResultLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        currencyConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    double value = Double.parseDouble(input);
                    convertCurrency(value, currencyFromComboBox.getSelectedItem().toString(), currencyToComboBox.getSelectedItem().toString());
                } catch (NumberFormatException ex) {
                    currencyResultLabel.setText("Valor inválido!");
                }
            }
        });

        currencyClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                currencyResultLabel.setText("");
            }
        });

        currencyPanel.add(currencyInputLabel);
        currencyPanel.add(inputField);
        currencyPanel.add(fromCurrencyLabel);
        currencyPanel.add(currencyFromComboBox);
        currencyPanel.add(toCurrencyLabel);
        currencyPanel.add(currencyToComboBox);
        currencyPanel.add(currencyConvertButton);
        currencyPanel.add(currencyClearButton);
        currencyPanel.add(new JLabel());
        currencyPanel.add(currencyResultLabel);

        // Separador
        add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.CENTER);

        // Conversor de medidas
        JPanel measurePanel = new JPanel();
        measurePanel.setLayout(new GridLayout(6, 2, 10, 10));
        measurePanel.setBorder(new EmptyBorder(10, 30, 10, 30));

        JLabel measureInputLabel = new JLabel("Digite um valor:");
        JTextField measureInputField = new JTextField(10);

        JLabel fromMeasureLabel = new JLabel("De:");
        JComboBox<String> measureFromComboBox = new JComboBox<>();
        measureFromComboBox.addItem("Metro");
        measureFromComboBox.addItem("Centímetro");
        measureFromComboBox.addItem("Polegada");
        measureFromComboBox.addItem("Quilômetro");
        measureFromComboBox.addItem("Milha");

        JLabel toMeasureLabel = new JLabel("Para:");
        JComboBox<String> measureToComboBox = new JComboBox<>();
        measureToComboBox.addItem("Metro");
        measureToComboBox.addItem("Centímetro");
        measureToComboBox.addItem("Polegada");
        measureToComboBox.addItem("Quilômetro");
        measureToComboBox.addItem("Milha");

        JButton measureConvertButton = new JButton("Converter");
        JButton measureClearButton = new JButton("Limpar");

        measureResultLabel = new JLabel();
        measureResultLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        measureConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = measureInputField.getText();
                try {
                    double value = Double.parseDouble(input);
                    convertMeasure(value, measureFromComboBox.getSelectedItem().toString(), measureToComboBox.getSelectedItem().toString());
                } catch (NumberFormatException ex) {
                    measureResultLabel.setText("Valor inválido!");
                }
            }
        });

        measureClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                measureInputField.setText("");
                measureResultLabel.setText("");
            }
        });

        measurePanel.add(measureInputLabel);
        measurePanel.add(measureInputField);
        measurePanel.add(fromMeasureLabel);
        measurePanel.add(measureFromComboBox);
        measurePanel.add(toMeasureLabel);
        measurePanel.add(measureToComboBox);
        measurePanel.add(measureConvertButton);
        measurePanel.add(measureClearButton);
        measurePanel.add(new JLabel());
        measurePanel.add(measureResultLabel);

        // Adiciona os painéis na janela
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(currencyPanel);
        mainPanel.add(measurePanel);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void setBorder(EmptyBorder emptyBorder) {
		// TODO Auto-generated method stub
		
	}

	private void convertCurrency(double value, String fromCurrency, String toCurrency) {
        double result = 0.0;
        switch (fromCurrency) {
            case "Real":
                switch (toCurrency) {
                    case "Dólar":
                        result = value * 5.26;
                        break;
                    case "Euro":
                        result = value * 6.29;
                        break;
                    case "Libra Esterlina":
                        result = value * 7.36;
                        break;
                    case "Peso Argentino":
                        result = value * 0.057;
                        break;
                    case "Peso Chileno":
                        result = value * 0.0071;
                        break;
                }
                break;
            case "Dólar":
            	result = value / 5.26;
                break;
            case "Euro":
            	result = value / 6.29;
                break;
            case "Libra Esterlina":
            	result = value / 7.36;
                break;
            case "Peso Argentino":
            	result = value / 0.057;
                break;
            case "Peso Chileno":
            	result = value * 0.0071;
                break;
        }
        String currencyResult = String.format("Resultado: %.2f %s", result, toCurrency);
        currencyResultLabel.setText(currencyResult);
    }

    private void convertMeasure(double value, String fromMeasure, String toMeasure) {
        double result = 0.0;
        switch (fromMeasure) {
            case "Metro":
                switch (toMeasure) {
                    case "Metro":
                        result = value;
                        break;
                    case "Centímetro":
                        result = value * 100;
                        break;
                    case "Polegada":
                        result = value * 39.37;
                        break;
                    case "Quilômetro":
                        result = value * 0.001;
                        break;
                    case "Milha":
                        result = value * 0.000621371;
                        break;
                }
                break;
            case "Centímetro":
                switch (toMeasure) {
                    case "Metro":
                        result = value * 0.01;
                        break;
                    case "Centímetro":
                        result = value;
                        break;
                    case "Polegada":
                        result = value * 0.3937;
                        break;
                    case "Quilômetro":
                        result = value * 0.00001;
                        break;
                    case "Milha":
                        result = value * 0.0000062137;
                        break;
                }
                break;
            case "Polegada":
                switch (toMeasure) {
                    case "Metro":
                        result = value * 0.0254;
                        break;
                    case "Centímetro":
                        result = value * 2.54;
                        break;
                    case "Polegada":
                        result = value;
                        break;
                    case "Quilômetro":
                        result = value * 0.0000254;
                        break;
                    case "Milha":
                        result = value * 0.000015783;
                        break;
                }
                break;
            case "Quilômetro":
                switch (toMeasure) {
                    case "Metro":
                        result = value * 1000;
                        break;
                    case "Centímetro":
                        result = value * 100000;
                        break;
                    case "Polegada":
                        result = value * 39370.1;
                        break;
                    case "Quilômetro":
                        result = value;
                        break;
                    case "Milha":
                        result = value * 0.621371;
                        break;
                }
                break;
            case "Milha":
                switch (toMeasure) {
                    case "Metro":
                        result = value * 1609.34;
                        break;
                    case "Centímetro":
                        result = value * 160934;
                        break;
                    case "Polegada":
                        result = value * 63360;
                        break;
                    case "Quilômetro":
                        result = value * 1.60934;
                        break;
                    case "Milha":
                        result = value;
                        break;
                }
                break;
        }
        String measureResult = String.format("Resultado: %.2f %s", result, toMeasure);
        measureResultLabel.setText(measureResult);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Conversor();
            }
        });
    }
}
