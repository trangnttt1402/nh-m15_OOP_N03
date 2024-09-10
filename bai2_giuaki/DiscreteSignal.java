public class DiscreteSignal {
    private final int[] signalValues;

    public DiscreteSignal(int[] signalValues) {
        this.signalValues = signalValues;
    }

    // Hàm xung đơn vị
    public int unitImpulse(int n) {
        return n == 0 ? 1 : 0;
    }

    // Hàm tín hiệu rời rạc
    public int signal(int n) {
        int result = 0;
        for (int k = 0; k < signalValues.length; k++) {
            result += signalValues[k] * unitImpulse(n - k);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("m: ");
        for (int value : signalValues) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Tạo đối tượng DiscreteSignal với các giá trị tín hiệu rời rạc
        int[] values = {1, 2, 3, 4};
        DiscreteSignal signal = new DiscreteSignal(values);

        // In ra giá trị tín hiệu tại các điểm khác nhau
        System.out.println(signal.signal(0));  // Output: 1
        System.out.println(signal.signal(1));  // Output: 2
        System.out.println(signal.signal(2));  // Output: 3
        System.out.println(signal.signal(3));  // Output: 4
    }
}
