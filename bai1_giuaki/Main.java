
// Lớp Main để kiểm tra
public class Main {
    public static void main(String[] args) {
        Signal discreteSignal = new DiscreteSignal();
        Signal continuousSignal = new ContinuousSignal();

        discreteSignal.transmit();
        continuousSignal.transmit();
    }
}
