package com.buchstadt.utils;

public class ValidateUpdatedFlag {

    private final Integer[] flags;

    public ValidateUpdatedFlag(Integer... flags) {
        this.flags = new Integer[flags.length];
        System.arraycopy(flags, 0, this.flags, 0, flags.length);
    }

    public boolean and() {
        boolean result = false;
        for (Integer flag : flags) {
            result = flag != null && flag != 0;
        }
        return result;
    }

    public boolean or() {
        boolean result = false;
        for (Integer flag : flags) {
            result = (flag != null && flag != 0) || result;
        }
        return result;
    }

}
