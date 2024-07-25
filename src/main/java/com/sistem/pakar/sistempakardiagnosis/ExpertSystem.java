package com.sistem.pakar;

import java.util.ArrayList;
import java.util.List;

public class ExpertSystem {
    private List<Condition> conditions = new ArrayList<>();
    private List<Damage> damages = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public void removeCondition(Condition condition) {
        conditions.remove(condition);
    }

    public void addDamage(Damage damage) {
        damages.add(damage);
    }

    public void removeDamage(Damage damage) {
        damages.remove(damage);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void removeRule(Rule rule) {
        rules.remove(rule);
    }

    public Damage diagnose(List<Condition> selectedConditions) {
        for (Rule rule : rules) {
            if (rule.matches(selectedConditions)) {
                return getDamageByCode(rule.getDamageCode());
            }
        }
        return null;
    }

    private Damage getDamageByCode(String damageCode) {
        for (Damage damage : damages) {
            if (damage.getCode().equalsIgnoreCase(damageCode)) {
                return damage;
            }
        }
        return null;
    }
}
