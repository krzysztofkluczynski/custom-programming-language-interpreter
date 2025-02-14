package org.example.parser;

import org.example.interpreter.Visitor;
import org.example.interpreter.error.InterpretingException;
import org.example.token.Position;

public interface Node {
    Position getPosition();

    void accept(Visitor visitor) throws InterpretingException;

//    default String print() {
//        return null;
//    }
}
