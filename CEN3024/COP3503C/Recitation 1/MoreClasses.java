public class MoreClasses {

    private int val;

    public MoreClasses(int val) {
        this.val = val;
    }

    public static void someMethod() {
        System.out.println("Invoking an objects calss without an objects instance");
    }

    public void Information() {
        System.out.println("I was invoked WITH an objects instance");
        System.out.println(getVal());
        System.out.println("Did you notive I can display Val");
    }

    public int getVal() {
        return val;
    }

    public static void main(String[] args) {
        MoreClasses obj1 = new MoreClasses(4);
        ogj1.Information();
        someMethod();
    }
}