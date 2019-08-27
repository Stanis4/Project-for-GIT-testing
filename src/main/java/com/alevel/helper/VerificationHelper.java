package com.alevel.helper;

public class VerificationHelper {

    public boolean containsIgnoreCase(String text, String searchString) {
        return text.toLowerCase().contains(searchString.toLowerCase());
    }
}
