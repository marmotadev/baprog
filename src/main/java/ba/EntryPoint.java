package ba;
import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
    	Logic logic = new Logic();
        InputHandler ih = new InputHandler(logic);
        ih.handleEvents();
    }
}
