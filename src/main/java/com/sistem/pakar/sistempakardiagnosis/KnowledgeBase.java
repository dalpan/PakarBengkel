package com.sistem.pakar;

public class KnowledgeBase {
    public KnowledgeBase(ExpertSystem expertSystem) {
        // Conditions
        expertSystem.addCondition(new Condition("G01", "Bau aneh pada knalpot"));
        expertSystem.addCondition(new Condition("G02", "Konsumsi bahan bakar lebih besar"));
        expertSystem.addCondition(new Condition("G03", "Tarikan gas brebet"));
        expertSystem.addCondition(new Condition("G04", "Spedometer mati"));
        expertSystem.addCondition(new Condition("G05", "Kelistrikan tidak menyala"));
        expertSystem.addCondition(new Condition("G06", "Motor mati total"));
        expertSystem.addCondition(new Condition("G07", "Saat handle rem depan ditarik timbul suara di bagian cakram"));
        expertSystem.addCondition(new Condition("G08", "Timbul suara di bagian tromol belakang ketika handle rem belakang ditarik"));
        expertSystem.addCondition(new Condition("G09", "Motor seperti habis bensin"));
        expertSystem.addCondition(new Condition("G10", "Motor mudah mati"));
        expertSystem.addCondition(new Condition("G11", "Motor kesulitan untuk menyala"));
        expertSystem.addCondition(new Condition("G12", "Akselerasi lambat"));
        expertSystem.addCondition(new Condition("G13", "Suara mesin kasar"));
        expertSystem.addCondition(new Condition("G14", "Terdapat suara mengelitik di bagian mesin"));
        expertSystem.addCondition(new Condition("G15", "Knalpot mengeluarkan asap hitam"));
        expertSystem.addCondition(new Condition("G16", "Kebocoran oli di sekitaran as shock"));
        expertSystem.addCondition(new Condition("G17", "As shock baret"));
        expertSystem.addCondition(new Condition("G18", "Motor ngejedug ketika melewati polisi tidur"));
        expertSystem.addCondition(new Condition("G19", "Motor seperti diayun ketika dikendarai"));
        expertSystem.addCondition(new Condition("G20", "Performa mesin tidak maksimal"));
        expertSystem.addCondition(new Condition("G21", "Emisi gas buang yang dihasilkan pun tidak bagus"));
        expertSystem.addCondition(new Condition("G22", "Rpm bisa naik dengan sendirinya"));
        expertSystem.addCondition(new Condition("G23", "Timbul suara di bagian cvt"));

        // Damages
        expertSystem.addDamage(new Damage("K01", "Kerusakan pada sensor MAP"));
        expertSystem.addDamage(new Damage("K02", "Kerusakan pada sensor ECT"));
        expertSystem.addDamage(new Damage("K03", "Kerusakan pada sensor TPS"));
        expertSystem.addDamage(new Damage("K04", "Kerusakan pada sensor IAT"));
        expertSystem.addDamage(new Damage("K05", "Kerusakan pada Oxygen sensor"));
        expertSystem.addDamage(new Damage("K06", "Kerusakan pada sensor CKP"));
        expertSystem.addDamage(new Damage("K07", "Kerusakan pada rem depan"));
        expertSystem.addDamage(new Damage("K08", "Kerusakan pada rem belakang"));
        expertSystem.addDamage(new Damage("K09", "Kerusakan pada shock depan"));
        expertSystem.addDamage(new Damage("K10", "Kerusakan pada Sistem injector"));
        expertSystem.addDamage(new Damage("K11", "Kerusakan pada stang seher"));
        expertSystem.addDamage(new Damage("K12", "Kerusakan pada klep"));
        expertSystem.addDamage(new Damage("K13", "Kerusakan pada seher"));
        expertSystem.addDamage(new Damage("K14", "Kerusakan pada shock belakang"));

        // Rules
        Rule rule1 = new Rule("K01");
        rule1.addCondition(new Condition("G01", "Bau aneh pada knalpot"));
        rule1.addCondition(new Condition("G02", "Konsumsi bahan bakar lebih besar"));
        rule1.addCondition(new Condition("G12", "Akselerasi lambat"));
        rule1.addCondition(new Condition("G21", "Emisi gas buang yang dihasilkan pun tidak bagus"));
        expertSystem.addRule(rule1);

        Rule rule2 = new Rule("K02");
        rule2.addCondition(new Condition("G02", "Konsumsi bahan bakar lebih besar"));
        rule2.addCondition(new Condition("G11", "Motor kesulitan untuk menyala"));
        rule2.addCondition(new Condition("G15", "Knalpot mengeluarkan asap hitam"));
        expertSystem.addRule(rule2);

        Rule rule3 = new Rule("K03");
        rule3.addCondition(new Condition("G02", "Konsumsi bahan bakar lebih besar"));
        rule3.addCondition(new Condition("G03", "Tarikan gas brebet"));
        rule3.addCondition(new Condition("G20", "Performa mesin tidak maksimal"));
        rule3.addCondition(new Condition("G22", "Rpm bisa naik dengan sendirinya"));
        expertSystem.addRule(rule3);

        Rule rule4 = new Rule("K04");
        rule4.addCondition(new Condition("G10", "Motor mudah mati"));
        rule4.addCondition(new Condition("G20", "Performa mesin tidak maksimal"));
        rule4.addCondition(new Condition("G21", "Emisi gas buang yang dihasilkan pun tidak bagus"));
        expertSystem.addRule(rule4);

        Rule rule5 = new Rule("K05");
        rule5.addCondition(new Condition("G11", "Motor kesulitan untuk menyala"));
        rule5.addCondition(new Condition("G21", "Emisi gas buang yang dihasilkan pun tidak bagus"));
        expertSystem.addRule(rule5);

        Rule rule6 = new Rule("K06");
        rule6.addCondition(new Condition("G04", "Spedometer mati"));
        rule6.addCondition(new Condition("G05", "Kelistrikan tidak menyala"));
        rule6.addCondition(new Condition("G06", "Motor mati total"));
        expertSystem.addRule(rule6);

        Rule rule7 = new Rule("K07");
        rule7.addCondition(new Condition("G07", "Saat handle rem depan ditarik timbul suara di bagian cakram"));
        expertSystem.addRule(rule7);

        Rule rule8 = new Rule("K08");
        rule8.addCondition(new Condition("G08", "Timbul suara di bagian tromol belakang ketika handle rem belakang ditarik"));
        expertSystem.addRule(rule8);

        Rule rule9 = new Rule("K09");
        rule9.addCondition(new Condition("G16", "Kebocoran oli di sekitaran as shock"));
        rule9.addCondition(new Condition("G17", "As shock baret"));
        rule9.addCondition(new Condition("G18", "Motor ngejedug ketika melewati polisi tidur"));
        expertSystem.addRule(rule9);

        Rule rule10 = new Rule("K10");
        rule10.addCondition(new Condition("G09", "Motor seperti habis bensin"));
        rule10.addCondition(new Condition("G10", "Motor mudah mati"));
        rule10.addCondition(new Condition("G11", "Motor kesulitan untuk menyala"));
        rule10.addCondition(new Condition("G12", "Akselerasi lambat"));
        expertSystem.addRule(rule10);

        Rule rule11 = new Rule("K11");
        rule11.addCondition(new Condition("G13", "Suara mesin kasar"));
        expertSystem.addRule(rule11);

        Rule rule12 = new Rule("K12");
        rule12.addCondition(new Condition("G13", "Suara mesin kasar"));
        rule12.addCondition(new Condition("G14", "Terdapat suara mengelitik di bagian mesin"));
        expertSystem.addRule(rule12);

        Rule rule13 = new Rule("K13");
        rule13.addCondition(new Condition("G13", "Suara mesin kasar"));
        rule13.addCondition(new Condition("G14", "Terdapat suara mengelitik di bagian mesin"));
        rule13.addCondition(new Condition("G15", "Knalpot mengeluarkan asap hitam"));
        expertSystem.addRule(rule13);

        Rule rule14 = new Rule("K14");
        rule14.addCondition(new Condition("G16", "Kebocoran oli di sekitaran as shock"));
        rule14.addCondition(new Condition("G17", "As shock baret"));
        rule14.addCondition(new Condition("G19", "Motor seperti diayun ketika dikendarai"));
        expertSystem.addRule(rule14);
    }
}

