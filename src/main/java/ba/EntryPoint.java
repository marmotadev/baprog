package ba;
import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Starting testing of strategy");

        BasicShootingStrategy war = new BasicShootingStrategy();

        String coords = war.shoot(HitStatus.FIRST);
        int counter = 0;

        war.helper.changeSymbolTo("a2", ActionSymbols.MOVED.getSymbol());

        while ( coords != "NONE" ) {
            System.out.println( "I got those coords to shoot '" + coords + "'");
            

            if (counter > 200) break;
            counter++;


            // Assume all misses
            war.helper.changeSymbolTo(coords, ActionSymbols.SHOT.getSymbol());
            coords = war.shoot(HitStatus.MISSED);

            if ( counter % 10 == 0 ) {
                war.helper.print();
                Thread.sleep(1000);
            }

        }

        war.helper.print();


    }
}
