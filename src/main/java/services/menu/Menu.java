package services.menu;

public class Menu {
    public static String[] forRetter = {"Varruller", "Sjøsuppe", "Torrnudler salat"};
    public static String[] hovedRetter = {"Crispy duck", "Pho", "Banh Xeo", "Wok"};
    public static String[] desserts = {"Is Krem", "Frukt fat", "Brownie", "Sjokolade kake", "Kanel sunurrer"};
    public static String[] mineralVann = {"Coca cola", "Villa", "Urge", "Sprite", "Fanta", "Vann"};

    public String[] getForRetter() { return forRetter; }
    public String[] getHovedRetter() { return hovedRetter; }
    public String[] getDesserts() { return desserts; }
    public String[] getMineralVann() { return mineralVann; }
}
