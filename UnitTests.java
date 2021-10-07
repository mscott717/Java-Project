import java.util.Arrays;

/**
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class UnitTests {
    
    public static void runTests() {
        testFindMajor();
        testGetName();
        testGetMajors();
        Logger.setDebug(true);
        testAddStudent();
        testJson();
        testCSVReader();
        testDataLoading();
        
    }

    public static void testFindMajor(){
        Department newMajor = new Department("Made up Department"); //Creating tests for findMajor method in Department class
        newMajor.createMajor("Wind Surfing");
        System.out.println(newMajor.findMajor("Wind Surfing").toJson()); //uses toJson method in Major class

    }
    public static void testAddStudent() { //I added this test
        Major test = new Major("Made up");
        test.addStudent("M");
        Logger.debug("%s%n", test.toJson());


    }
    public static void testGetMajors(){
        Department test = new Department("Liberal Arts");
        System.out.println(Arrays.toString(test.getMajors()));
    }
    public static void testGetName(){
        Department test = new Department ("Blah Blah");
        System.out.println(test.getName());
    }

    private static void testDataLoading() {
        UniversityData data = new UniversityData();
        data.loadData("data/CollegeData10sample.csv");
        Logger.debug("%s%n", data.toJson());
        data.saveData("testOut.json");  // use https://jsonlint.com/  to help make sure format is correct
    }

    private static void testCSVReader() {
        CSVReader reader = new CSVReader("Data/test.csv");
        while(reader.hasNext()) {
            Logger.debug("%s%n", Arrays.toString(reader.getNext()));
        }

        Logger.debug("\n");
        Logger.debug("\n");
    }

    private static void testJson() {
        GenderCounter counter = new GenderCounter();
        counter.addCount("F");
        counter.addCount("F");
        counter.addCount("M");
        Logger.debug("%s%n", counter.toJson()); // use https://jsonlint.com/  to help make sure format is correct
        
        Major m1 = new Major("Astronomy");
        Major m2 = new Major("Basket Weaving");
        Major m3 = new Major ("Computer Science");

        m1.addStudent("F"); //Add female students to Astronomy major
        m1.addStudent("M"); //Test I added. Adds Male student to Astronomy major
        m1.addStudent("M");

        m2.addStudent("M");
        m2.addStudent("F");

        m3.addStudent("F");//Test i added
        m3.addStudent("F");//Test I added

        Logger.debug("%s%n", m1.toJson());
        Logger.debug("%s%n", m2.toJson());
        Logger.debug("%s%n", m3.toJson()); //Test I added



        Department department = new Department("Frivolities");
        department.addStudent("Astronomy", "F");
        department.addStudent("Basket Weaving", "M");
        department.addStudent("Basket Weaving", "F");

        Logger.debug("%s%n", department.toJson());

        Logger.debug("\n");
        Logger.debug("\n");
    }


}
