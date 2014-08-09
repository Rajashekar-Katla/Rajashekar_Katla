package lamda_expression;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 */

interface Executor {
    int execute(int a);
}

class Runner {

    void run(Executor executor) {
        System.out.println("value==" + executor.execute(12));
    }
}

public class LamdaExpression {

    public static void main(String[] args) {
        new Runner().run(new Executor() {
            @Override
            public int execute(int a) {
                return 7 + a;
            }
        });

//        Runnable r2 = () -> System.out.println("Hello world two!");
        Runner runner = new Runner();
//        Executor executor = (a) -> 8 + a;
//        runner.run(executor);

    }
}
