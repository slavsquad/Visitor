package com.company.Visitor;


import com.company.Shapes.*;

public class XMLExportVisitor implements Visitor {


    @Override
    public String export(Shape... shapes) {
        StringBuilder sb = new StringBuilder();
        int shapeId = 0;
        for (Shape shape : shapes) {
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
            sb.append(shape.accept(this) + "\n");
            System.out.println(sb.toString());
            sb.setLength(0);
            shapeId++;
        }
        return sb.toString();
    }

    public String visit(Dot d) {
        return "<dot>" + "\n" +
                "    <id>" + d.getId() + "</id>" + "\n" +
                "    <x>" + d.getX() + "</x>" + "\n" +
                "    <y>" + d.getY() + "</y>" + "\n" +
                "</dot>";
    }

    public String visit(Circle c) {
        return "<circle>" + "\n" +
                "    <id>" + c.getId() + "</id>" + "\n" +
                "    <x>" + c.getX() + "</x>" + "\n" +
                "    <y>" + c.getY() + "</y>" + "\n" +
                "    <radius>" + c.getRadius() + "</radius>" + "\n" +
                "</circle>";
    }

    public String visit(Rectangle r) {
        return "<rectangle>" + "\n" +
                "    <id>" + r.getId() + "</id>" + "\n" +
                "    <x>" + r.getX() + "</x>" + "\n" +
                "    <y>" + r.getY() + "</y>" + "\n" +
                "    <width>" + r.getWidth() + "</width>" + "\n" +
                "    <height>" + r.getHeight() + "</height>" + "\n" +
                "</rectangle>";
    }

    public String visit(CompoundShape cg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<compound_graphic>\n");
        sb.append("<id>" + cg.getId() + "</id>" + "\n");
        for (Shape shape : cg.children) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        sb.append("</compound_graphic>");
        return sb.toString();
    }
}