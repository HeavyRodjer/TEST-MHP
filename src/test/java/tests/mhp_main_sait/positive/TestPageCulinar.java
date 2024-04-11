package tests.mhp_main_sait.positive;

import org.junit.jupiter.api.Test;
import tests.base.baseTest;

import static constans.Constans.Urls.MHP_PAGE;

public class TestPageCulinar extends baseTest {
    @Test
    public void checkIsSAIT(){
        //Метод для підставляння силки ITSM_MAIN_URL - сама силка, яка знаходиться в константах
        basePage.goToURL(MHP_PAGE);
        MainPageMHP.click();
        MainPageMHP.click_list();
        MainPageMHP.click_product();
//        MainPageMHP.check_text();





    }
}
