package com.company.Shapes;


import com.company.Visitor.Visitor;

public class Circle extends Dot {
    public int radius;

    public Circle(int id, int x, int y, int radius) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public int getRadius() {
        return radius;
    }
}