package com.sistem.pakar;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private String damageCode;
    private List<Condition> conditions = new ArrayList<>();

    public Rule(String damageCode) {
        this.damageCode = damageCode;
    }

    public String getDamageCode() {
        return damageCode;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public boolean matches(List<Condition> selectedConditions) {
        return selectedConditions.containsAll(conditions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(damageCode + " IF ");
        for (Condition condition : conditions) {
            sb.append(condition.getCode()).append(" AND ");
        }
        sb.setLength(sb.length() - 5); // Remove trailing " AND "
        return sb.toString();
    }
}
