import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Pos pos = new Pos();

        while (pos.getLoopBoolean()) {
            pos.turnOn();
        }

    }
}
