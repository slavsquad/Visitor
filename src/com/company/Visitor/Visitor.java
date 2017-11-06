package com.company.Visitor;

import com.company.Shapes.*;

public interface Visitor {

    public String visit(Dot dot);

    public String visit(Circle circle);

    public String visit(Rectangle rectangle);

    public String visit(CompoundShape cg);

    public String export(Shape... shapes);
}
