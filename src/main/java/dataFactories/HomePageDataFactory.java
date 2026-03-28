package dataFactories;

import dataObjects.HomePageDataObject;

public class HomePageDataFactory {

    public static HomePageDataObject addOneProduct(){
        var HomePageDataObject = new HomePageDataObject();

        HomePageDataObject.setProductsWantsToAdd("MacBook");

        return HomePageDataObject;
    }

    public static HomePageDataObject addMultipleProducts(){
        var HomePageDataObject = new HomePageDataObject();

        HomePageDataObject.setProductsWantsToAdd("MacBook", "iPhone");

        return HomePageDataObject;
    }
}
