package InnerClass;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 22/07/14
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class InnerClass {
    private static final int c = 0;
    public static int b;
    private int a;

    public static void sayGoodbyeInEnglish() {
        PriorityQueue priorityQueue = new PriorityQueue();
        InnerClass innerClass = new InnerClass();
        priorityQueue.add(innerClass);
        class EnglishGoodbye {

            public void sayGoodbye() {
                System.out.println("Bye bye");
            }
        }
    }

    static class A {

        static void hello() {
            System.out.println(b);
        }

        interface b {

        }
    }

    class B {
        private void hello() {
            final int aa = 0;
            final String bb = null;
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            class Hello {
                void dodo() {
                    System.out.println(aa);
                    System.out.println(bb);
                }
            }
        }
    }
}
