package ba;
import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
        InputHandler ih = new InputHandler(new Logic());
        ih.handleEvents();
    }
}
