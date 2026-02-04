package com.kjp0411.jdcollector.infra.csv;

public class CsvEscapeUtil {

    public static String escape(String value) {
        if (value == null) {
            return "";
        }

        boolean hasSpecialChar =
            value.contains(",") ||
                value.contains("\n") ||
                value.contains("\r") ||
                value.contains("\"");

        String escaped = value.replace("\"", "\"\"");

        if (hasSpecialChar) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}
