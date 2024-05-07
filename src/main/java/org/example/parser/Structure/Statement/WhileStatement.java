package org.example.parser.Structure.Statement;

import lombok.Value;
import org.example.parser.Node;
import org.example.parser.Structure.Expression.Expression;
import org.example.parser.Visitor;
import org.example.token.Position;

@Value
public class WhileStatement implements Statement {

    Expression expression;
    BlockStatement blockStatement;
    Position position;

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.accept(this);
    }
}
