package com.company.Shapes;

import com.company.Visitor.Visitor;

public interface Shape {
    public void move(int x, int y);
    public void draw();
    public String accept(Visitor visitor);
}