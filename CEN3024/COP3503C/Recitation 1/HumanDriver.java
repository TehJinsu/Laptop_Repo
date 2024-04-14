public class HumanDriver {
    
    public static void main(String[] args) {
        System.out.println("Making Humans!!!");

        Human h1 = new Human();

        System.out.println(h1.getAge());
        System.out.println(h1.getName());


        System.out.println("Time for a new Human");
        Human h2 = new Human(30, "Jenny Bilfort");

        System.out.println(h2.getAge());
        System.out.println(h2.getName());
    }
}
