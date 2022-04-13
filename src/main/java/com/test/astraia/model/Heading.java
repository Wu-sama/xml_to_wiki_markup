package com.test.astraia.model;

// todo maybe move to inner private class
public class Heading {
    private String heading;
    private int order = 1;
    private static String BRACE_CHARACTER = "=";

    public Heading(String heading, int order) {
        this.heading = heading;
        if (order <= 0) {
            throw new RuntimeException("Wrong order");
        }
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getHeading() {
        return heading;
    }

    @Override
    public String toString() {
        String braces = BRACE_CHARACTER.repeat(order);
        return braces + heading + braces;
    }
}
