package Steps;

import Pages.SearchPage;
public class Base_StepDefinitions {
    protected SearchPage searchPage;
    protected Base_StepDefinitions(){
        searchPage=new SearchPage();
    }
}