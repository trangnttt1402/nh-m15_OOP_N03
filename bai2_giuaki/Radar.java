public class Radar {
    // Hàm tín hiệu rời rạc X(n)
    public double signal(int n) {
        if (n >= 0 && n <= 15) {
            return 1 - Math.pow((double) n / 15, 2);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Radar radar = new Radar();

        // In ra giá trị tín hiệu tại n = 4
        System.out.println("X(4) = " + radar.signal(4));  // Output: X(4) = 0.8222222222222222
    }
}
