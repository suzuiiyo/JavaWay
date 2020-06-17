package multithreading;

public class AnonymosInnerClass {

    public static void main(String[] args) {
        AnonymosInnerClass ano = new AnonymosInnerClass();
        //InnerTest inner = new InnerTest();
        InnerTest inner = ano.new InnerTest();
        Test t = inner.get(3);
        System.out.println(t.getI());
    }

    class Test{
        private int i;
        public Test(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }

    class InnerTest {
        public Test get(int x) {
            return new Test(x) {};
        }
    }
}