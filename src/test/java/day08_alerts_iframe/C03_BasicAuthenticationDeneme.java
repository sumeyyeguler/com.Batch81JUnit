package day08_alerts_iframe;

import org.junit.Test;
import utilities.TestBase;

public class C03_BasicAuthenticationDeneme extends TestBase {
//1 Bir class olusturun : BasicAuthentication
//2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
//3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//    Html komutu : https://username:password@URL
//    Username : admin
//    password : admin
//4 Basarili sekilde sayfaya girildigini dogrulayin

    @Test
    public void Test01() {
       // driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }


}
