import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public AdminPanelMainPage loginUser(String email, String password){
        $(By.cssSelector("section.col-lg-9 input[name=\"email\"]")).setValue(email);
        $(By.cssSelector("section.col-lg-9 input[name=\"password\"]")).setValue(password);
        $(By.cssSelector("section.col-lg-9 div.col-sm-offset-2 button")).click();
        return page(AdminPanelMainPage.class);
    }
}
