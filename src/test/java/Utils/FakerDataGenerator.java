package Utils;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

    static Faker faker = new Faker();

    public static String firstName =faker.name().firstName();
    public static String address =faker.address().cityName();
    public static String surname =faker.name().lastName();


//    @Test
//    public void test(){
//        System.out.println(firstName);
//        System.out.println(address);
//        System.out.println(surname);
//
//    }
}
