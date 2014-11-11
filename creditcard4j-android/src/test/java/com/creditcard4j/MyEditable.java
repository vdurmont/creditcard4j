package com.creditcard4j;

import android.text.Editable;
import android.text.InputFilter;

public class MyEditable implements Editable {
    private String text;

    public MyEditable(String text) {
        this.text = text;
    }

    @Override public Editable replace(int i, int i1, CharSequence charSequence, int i2, int i3) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable replace(int i, int i1, CharSequence charSequence) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable insert(int i, CharSequence charSequence, int i1, int i2) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable insert(int i, CharSequence charSequence) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable delete(int i, int i1) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable append(CharSequence charSequence) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable append(CharSequence charSequence, int i, int i1) {
        throw new RuntimeException("Not implemented");
    }

    @Override public Editable append(char c) {
        this.text += c;
        return this;
    }

    @Override public void clear() {
        throw new RuntimeException("Not implemented");
    }

    @Override public void clearSpans() {
        throw new RuntimeException("Not implemented");
    }

    @Override public void setFilters(InputFilter[] inputFilters) {
        throw new RuntimeException("Not implemented");
    }

    @Override public InputFilter[] getFilters() {
        throw new RuntimeException("Not implemented");
    }

    @Override public void getChars(int i, int i1, char[] chars, int i2) {
        throw new RuntimeException("Not implemented");
    }

    @Override public void setSpan(Object o, int i, int i1, int i2) {
        throw new RuntimeException("Not implemented");
    }

    @Override public void removeSpan(Object o) {
        throw new RuntimeException("Not implemented");
    }

    @Override public <T> T[] getSpans(int i, int i1, Class<T> aClass) {
        throw new RuntimeException("Not implemented");
    }

    @Override public int getSpanStart(Object o) {
        throw new RuntimeException("Not implemented");
    }

    @Override public int getSpanEnd(Object o) {
        throw new RuntimeException("Not implemented");
    }

    @Override public int getSpanFlags(Object o) {
        throw new RuntimeException("Not implemented");
    }

    @Override public int nextSpanTransition(int i, int i1, Class aClass) {
        throw new RuntimeException("Not implemented");
    }

    @Override public int length() {
        throw new RuntimeException("Not implemented");
    }

    @Override public char charAt(int index) {
        throw new RuntimeException("Not implemented");
    }

    @Override public CharSequence subSequence(int start, int end) {
        throw new RuntimeException("Not implemented");
    }

    @Override public String toString() {
        return this.text;
    }
}
