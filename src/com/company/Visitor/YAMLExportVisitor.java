package com.company.Visitor;

import com.company.Shapes.*;

public class YAMLExportVisitor implements Visitor {
    @Override
    public String export(Shape... shapes) {
        StringBuilder sb = new StringBuilder();
        int shapeId = 0;
        for (Shape shape : shapes) {
            sb.append("YAML 1.0 utf-8\n");
            sb.append("shapes:\n");
            sb.append(shape.accept(this) + "\n");
            System.out.println(sb.toString());
            sb.setLength(0);
            shapeId++;
        }
        return sb.toString();
    }

    public String visit(Dot d) {
        return  "  - shape:  " +d.getClass().getSimpleName() + "\n" +
                "    id:     " + d.getId() + "\n" +
                "    x:      " + d.getX() + "\n" +
                "    y:      " + d.getY();
    }

    public String visit(Circle c) {
        return  "  - shape:  " +c.getClass().getSimpleName() + "\n" +
                "    id:     " + c.getId() + "\n" +
                "    x:      " + c.getX() + "\n" +
                "    y:      " + c.getY() + "\n" +
                "    radius: " + c.getRadius();
    }

    public String visit(Rectangle r) {
        return  "  - shape:  " +r.getClass().getSimpleName() + "\n" +
                "    id:     " + r.getId() + "\n" +
                "    x:      " + r.getX() + "\n" +
                "    y:      " + r.getY() + "\n" +
                "    width:  " + r.getWidth() + "\n" +
                "    height: " + r.getHeight();
    }

    public String visit(CompoundShape cg) {
        StringBuilder sb = new StringBuilder();
        sb.append("  - shape: " +cg.getClass().getSimpleName() + "\n");
        sb.append("    id:    " + cg.getId() + "\n");
        for (Shape shape : cg.children) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            obj = "    " + obj.replace("\n", "\n    ") + "\n";
            sb.append(obj);
        }
        return sb.toString();
    }
}
