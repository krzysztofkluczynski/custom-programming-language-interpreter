package org.example.parser.Structure.Expression;

import lombok.Value;
import org.example.parser.Structure.OtherComponents.TypeDeclaration;
import org.example.parser.Visitor;
import org.example.token.Position;

import java.beans.Expression;
@Value
public class CastExpression implements IExpression {
    TypeDeclaration type;
    IExpression expression;
    Position position;


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
