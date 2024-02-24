package org.eugene;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AddCustomerPage {
    public WebDriver driver;
    public AddCustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//button[@ng-class=\"btnClass1\"]")
    private WebElement btnAdd;

    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement fNameField;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement postCodeField;
    public String generatePostCode(){
        Random r = new Random(9);
        String code = "";
        int i = 0;
        while (i != 10){
            code += r.nextInt(9);
            i++;
        }
        return code;
    }
    public void inputPostCode(String code){
        postCodeField.sendKeys(code);
    }
    public void clickAdd() {
        btnAdd.click();
    }
    public void inputFirstName(String code) {
        String result = "";
        int offset = 0;
        for (int i = 0; i < code.length(); i += 2) {
            // Получаем двузначное число из строки
            int num = Integer.parseInt(code.substring(i, i + 2));

            // Преобразуем число в букву алфавита с учетом смещения
             offset = num / 26;

            // Преобразуем число в букву алфавита с учетом смещения
            char letter = (char) ((num % 26) + 'a');
            result += letter;

            // Если число было больше 25, увеличиваем смещение
            if (num > 25)
                offset++;
        }
        fNameField.sendKeys(result);
    }

}
