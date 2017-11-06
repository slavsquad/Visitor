package com.company;

import com.company.Shapes.*;
import com.company.Visitor.XMLExportVisitor;
import com.company.Visitor.YAMLExportVisitor;

public class Main {

    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);



        YAMLExportVisitor yamlExportVisitor = new YAMLExportVisitor();
        yamlExportVisitor.export(circle,compoundShape);


        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        exportVisitor.export(circle,compoundShape);
    }

}
