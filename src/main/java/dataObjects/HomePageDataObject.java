package dataObjects;

import lombok.Data;

@Data
public class HomePageDataObject {
    private String[] productsWantsToAdd;

    public void setProductsWantsToAdd(String... itemsWantsToAdd) {
        this.productsWantsToAdd = itemsWantsToAdd;
    }

    public String[] getProductsWantsToAdd() {
        return productsWantsToAdd;
    }
}
