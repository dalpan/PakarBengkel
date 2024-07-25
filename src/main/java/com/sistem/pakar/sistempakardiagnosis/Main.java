package com.sistem.pakar;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DiagnosisUI().setVisible(true);
            }
        });
    }
}
