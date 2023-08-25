package com.buchstadt.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record ToUnderscore(Map<String, Object> map) {

    record NewMapKey(String oldKey, String newKey, Object value) {
    }

    private void replace(ArrayList<NewMapKey> list) {
        for (NewMapKey item : list) {
            map.remove(item.oldKey());
            map.put(item.newKey(), item.value());
        }
    }

    public void convert() {
        String regEx = "[A-Z]";
        Pattern pattern = Pattern.compile(regEx);
        ArrayList<NewMapKey> list = new ArrayList<>();

        for (String oldKey : map.keySet()) {
            Matcher matcher = pattern.matcher(oldKey);
            while (matcher.find()) {
                StringBuilder sb = new StringBuilder(oldKey);
                String newKey = "_" + matcher.group().toLowerCase();
                sb.replace(matcher.start(), matcher.start() + 1, newKey);
                list.add(new NewMapKey(oldKey, sb.toString(), map.get(oldKey)));
            }
        }

        replace(list);
    }

}
