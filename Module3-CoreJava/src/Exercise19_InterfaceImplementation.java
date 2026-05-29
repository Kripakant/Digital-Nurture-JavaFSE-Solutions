// Exercise 19: Interface Implementation
// Objective: Use interfaces in Java.
public class Exercise19_InterfaceImplementation {

    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Strumming the guitar: twang twang!");
        }
    }

    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Playing the piano: plink plonk!");
        }
    }

    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }
}
