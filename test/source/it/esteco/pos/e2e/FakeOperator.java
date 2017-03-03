package it.esteco.pos.e2e;

import java.io.ByteArrayInputStream;

public class FakeOperator {
    public void input(String commands) {
        System.setIn(new ByteArrayInputStream(commands.getBytes()));
    }
}
