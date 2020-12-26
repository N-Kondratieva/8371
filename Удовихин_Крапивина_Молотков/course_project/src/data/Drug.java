package data;

public class Drug {
    int drugID;
    int typeID;
    int stockQuantity;
    int storageID;
    String drugName;
    String drugDescription;

    public Drug(int drugID, int typeID, int stockQuantity, int storageID, String drugName, String drugDescription)
    {
        this.drugID = drugID;
        this.typeID = typeID;
        this.stockQuantity = stockQuantity;
        this.storageID = storageID;
        this.drugName = drugName;
        this.drugDescription = drugDescription;

    }
}
