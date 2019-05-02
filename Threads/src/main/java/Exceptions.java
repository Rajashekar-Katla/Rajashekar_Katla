/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 14/07/14
 * Time: 16:25
 * To change this template use File | Settings | File Templates.
 */
public class Exceptions {
    public static void main(String[] args) {
        long[] longs = new long[20];
        longs[0] = 0;
        longs[1] = 1;
        for (int i = 2; i < longs.length; i++) {
            longs[i] = longs[i - 1] + longs[i - 2];
        }
        for (long l : longs)
//            System.out.println(l);

            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
//                System.out.println("Even=="+i);
                }
            }
        for (int g = 1; g < 50; g++) {
            boolean isPrime = true;
            for (int h = 2; h < g; h++) {
                if (g % h == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.println("prime=="+g);
        }
    }


}
