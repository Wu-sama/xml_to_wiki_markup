package com.test.astraia.model;

public class Heading {
    private final String heading;
    private int order;
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
