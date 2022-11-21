package signup;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import storebase.StoreBaseTests;
import java.io.IOException;


public class SignUpTests extends StoreBaseTests {
    SoftAssert soft =new SoftAssert();

    @Test
    public void testSuccessfulSignUp() throws CsvValidationException, IOException, InterruptedException {
    signUpPage.signUp();

    }

}
