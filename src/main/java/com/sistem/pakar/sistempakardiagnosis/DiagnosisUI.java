package com.sistem.pakar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Kelas untuk Diagnosa Sistem Pakar
public class DiagnosisUI extends JFrame {
    private JList<String> conditionList;
    private DefaultListModel<String> conditionListModel;
    private JList<String> damageList;
    private DefaultListModel<String> damageListModel;
    private JList<String> ruleList;
    private DefaultListModel<String> ruleListModel;
    private ExpertSystem expertSystem;
    private JTextArea diagnosisResult;
    private JButton diagnoseButton;

    public DiagnosisUI() {
        expertSystem = new ExpertSystem();
        setupUI();
        loadInitialData();
    }

    private void setupUI() {
        setTitle("Sistem Pakar Diagnosis Kerusakan Mesin Injection");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel Data Gejala
        JPanel conditionPanel = new JPanel();
        conditionPanel.setLayout(new BorderLayout());

        conditionListModel = new DefaultListModel<>();
        conditionList = new JList<>(conditionListModel);
        conditionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        conditionPanel.add(new JScrollPane(conditionList), BorderLayout.CENTER);

        JPanel conditionButtons = new JPanel();
        JButton addConditionButton = new JButton("Tambah Gejala");
        addConditionButton.addActionListener(e -> {
            String code = JOptionPane.showInputDialog("Masukkan kode gejala:");
            String description = JOptionPane.showInputDialog("Masukkan deskripsi gejala:");
            if (code != null && description != null) {
                Condition condition = new Condition(code, description);
                expertSystem.addCondition(condition);
                conditionListModel.addElement(code + ": " + description);
            }
        });
        JButton removeConditionButton = new JButton("Hapus Gejala");
        removeConditionButton.addActionListener(e -> {
            int selectedIndex = conditionList.getSelectedIndex();
            if (selectedIndex >= 0) {
                String selectedCondition = conditionListModel.getElementAt(selectedIndex);
                String code = selectedCondition.split(":")[0];
                Condition conditionToRemove = getConditionByCode(code);
                if (conditionToRemove != null) {
                    expertSystem.removeCondition(conditionToRemove);
                    conditionListModel.remove(selectedIndex);
                }
            }
        });
        conditionButtons.add(addConditionButton);
        conditionButtons.add(removeConditionButton);
        conditionPanel.add(conditionButtons, BorderLayout.SOUTH);
        tabbedPane.addTab("Data Gejala", conditionPanel);

        // Panel Data Kerusakan
        JPanel damagePanel = new JPanel();
        damagePanel.setLayout(new BorderLayout());

        damageListModel = new DefaultListModel<>();
        damageList = new JList<>(damageListModel);
        damageList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        damagePanel.add(new JScrollPane(damageList), BorderLayout.CENTER);

        JPanel damageButtons = new JPanel();
        JButton addDamageButton = new JButton("Tambah Kerusakan");
        addDamageButton.addActionListener(e -> {
            String code = JOptionPane.showInputDialog("Masukkan kode kerusakan:");
            String description = JOptionPane.showInputDialog("Masukkan deskripsi kerusakan:");
            if (code != null && description != null) {
                Damage damage = new Damage(code, description);
                expertSystem.addDamage(damage);
                damageListModel.addElement(code + ": " + description);
            }
        });
        JButton removeDamageButton = new JButton("Hapus Kerusakan");
        removeDamageButton.addActionListener(e -> {
            int selectedIndex = damageList.getSelectedIndex();
            if (selectedIndex >= 0) {
                String selectedDamage = damageListModel.getElementAt(selectedIndex);
                String code = selectedDamage.split(":")[0];
                Damage damageToRemove = getDamageByCode(code);
                if (damageToRemove != null) {
                    expertSystem.removeDamage(damageToRemove);
                    damageListModel.remove(selectedIndex);
                }
            }
        });
        damageButtons.add(addDamageButton);
        damageButtons.add(removeDamageButton);
        damagePanel.add(damageButtons, BorderLayout.SOUTH);
        tabbedPane.addTab("Data Kerusakan", damagePanel);

        // Panel Aturan
        JPanel rulePanel = new JPanel();
        rulePanel.setLayout(new BorderLayout());

        ruleListModel = new DefaultListModel<>();
        ruleList = new JList<>(ruleListModel);
        ruleList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        rulePanel.add(new JScrollPane(ruleList), BorderLayout.CENTER);

        JPanel ruleButtons = new JPanel();
        JButton addRuleButton = new JButton("Tambah Aturan");
        addRuleButton.addActionListener(e -> {
            String damageCode = JOptionPane.showInputDialog("Masukkan kode kerusakan:");
            if (damageCode != null) {
                Rule rule = new Rule(damageCode);
                String[] conditions = JOptionPane.showInputDialog("Masukkan kode gejala yang dipisahkan dengan koma:").split(",");
                for (String conditionCode : conditions) {
                    Condition condition = getConditionByCode(conditionCode.trim());
                    if (condition != null) {
                        rule.addCondition(condition);
                    }
                }
                expertSystem.addRule(rule);
                ruleListModel.addElement(rule.toString());
            }
        });
        JButton removeRuleButton = new JButton("Hapus Aturan");
        removeRuleButton.addActionListener(e -> {
            int selectedIndex = ruleList.getSelectedIndex();
            if (selectedIndex >= 0) {
                String selectedRule = ruleListModel.getElementAt(selectedIndex);
                String damageCode = selectedRule.split(" ")[0];
                Rule ruleToRemove = getRuleByDamageCode(damageCode);
                if (ruleToRemove != null) {
                    expertSystem.removeRule(ruleToRemove);
                    ruleListModel.remove(selectedIndex);
                }
            }
        });
        ruleButtons.add(addRuleButton);
        ruleButtons.add(removeRuleButton);
        rulePanel.add(ruleButtons, BorderLayout.SOUTH);
        tabbedPane.addTab("Aturan", rulePanel);

        // Panel Diagnosa
        JPanel diagnosisPanel = new JPanel();
        diagnosisPanel.setLayout(new BorderLayout());

        diagnosisResult = new JTextArea();
        diagnosisResult.setEditable(false);
        diagnosisResult.setLineWrap(true);
        diagnosisResult.setWrapStyleWord(true);
        diagnosisPanel.add(new JScrollPane(diagnosisResult), BorderLayout.CENTER);

        diagnoseButton = new JButton("Diagnosa");
        diagnoseButton.addActionListener(e -> {
            List<Condition> selectedConditions = getSelectedConditions();
            Damage result = expertSystem.diagnose(selectedConditions);
            if (result != null) {
                diagnosisResult.setText("Kerusakan yang terdiagnosis: " + result.getDescription());
            } else {
                diagnosisResult.setText("Tidak ada kerusakan yang sesuai dengan gejala.");
            }
        });
        diagnosisPanel.add(diagnoseButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Diagnosa", diagnosisPanel);

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void loadInitialData() {
        // Load initial data from ExpertSystem
        for (Condition condition : expertSystem.getConditions()) {
            conditionListModel.addElement(condition.getCode() + ": " + condition.getDescription());
        }
        for (Damage damage : expertSystem.getDamages()) {
            damageListModel.addElement(damage.getCode() + ": " + damage.getDescription());
        }
        for (Rule rule : expertSystem.getRules()) {
            ruleListModel.addElement(rule.toString());
        }
    }

    private List<Condition> getSelectedConditions() {
        List<Condition> selectedConditions = new ArrayList<>();
        for (int index : conditionList.getSelectedIndices()) {
            String selectedCondition = conditionListModel.getElementAt(index);
            String code = selectedCondition.split(":")[0];
            Condition condition = getConditionByCode(code);
            if (condition != null) {
                selectedConditions.add(condition);
            }
        }
        return selectedConditions;
    }

    private Condition getConditionByCode(String code) {
        for (Condition condition : expertSystem.getConditions()) {
            if (condition.getCode().equalsIgnoreCase(code)) {
                return condition;
            }
        }
        return null;
    }

    private Damage getDamageByCode(String code) {
        for (Damage damage : expertSystem.getDamages()) {
            if (damage.getCode().equalsIgnoreCase(code)) {
                return damage;
            }
        }
        return null;
    }

    private Rule getRuleByDamageCode(String damageCode) {
        for (Rule rule : expertSystem.getRules()) {
            if (rule.getDamageCode().equalsIgnoreCase(damageCode)) {
                return rule;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new DiagnosisUI());
    }
}
