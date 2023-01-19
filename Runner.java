public class Runner {

public static void main(String[] args) {   // If you need to choose a different Scheme, you must change inside the home getInstance. e.g. getInstance(new Context(new Scheme2()))
        HomeBase home = HomeBase.getInstance(new Context(new Scheme1()));  // Create only one homebase using Singleton Pattern
        FieldBases fieldbase1 = new FieldBases(home);
        spies s1 = new spies(fieldbase1);
        //fieldbase1.godark();
        //fieldbase1.golight();
        FieldBases fieldbase2 = new FieldBases(home);
        spies s2 = new spies(fieldbase2);
        // s1.dead();
        home.start();                                       // The start funtion always at the bottom before any new object
        fieldbase1.sendMessage(fieldbase1, s1, "Hello");
        s1.sendMessage(s1, fieldbase1, "Home");
    }
}
