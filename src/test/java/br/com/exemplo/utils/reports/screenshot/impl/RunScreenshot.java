package br.com.exemplo.utils.reports.screenshot.impl;

import com.google.common.base.Function;

public class RunScreenshot {
    public <V, T> V take(Function<? super T, V> isTrue) {
        try {
            return isTrue.apply(null);
        } catch (Exception e) {
            System.out.printf("Exception na screenshot");
            throw new RuntimeException();
        }
    }
}
