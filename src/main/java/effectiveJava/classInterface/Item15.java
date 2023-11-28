package effectiveJava.classInterface;

public class Item15 {
    public static void main(String[] args) {
        A1 a2 = new A2();
        a2.test();
    }
}
class A1{
    protected void test(){
        System.out.println("code ngu vl");
    }
}
class A2 extends A1{
}
