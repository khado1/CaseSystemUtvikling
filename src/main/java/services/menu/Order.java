package services.menu;

public class Order {
    int[] forRetter = new int[Menu.forRetter.length];
    int[] hovedRetter = new int[Menu.hovedRetter.length];
    int[] desserts = new int[Menu.desserts.length];
    int[] mineralVann = new int[Menu.mineralVann.length];
    int c = 0;
    int x = 0;

    int tableId;
    int bookingId;

    public Order(){}

    public int[] getForRetter() { return forRetter; }
    public void setForRetter(int e) { if(e != -1) forRetter[e] = 1; }
    public int[] getHovedRetter() { return hovedRetter; }
    public void setHovedRetter(int m) { if(m != -1) hovedRetter[m] = 1; }
    public int[] getDesserts() { return desserts; }
    public void setDesserts(int d) { if(d != -1) desserts[d] = 1; }
    public int[] getMineralVann() { return mineralVann; }
    public void setMineralVann(int d) { if(d != -1) mineralVann[d] = 1; }
    public int getC(){ return c; }
    public void setC(int p){ c = p; }
    public int getX() { return x; }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void fix(){
        for(int i = 0; i < forRetter.length; i++){
            if(forRetter[i] == 1){
                forRetter[i] = c;
                x++;
                break;
            }
        }
        for(int i = 0; i < hovedRetter.length; i++){
            if(hovedRetter[i] == 1){
                hovedRetter[i] = c;
                x++;
                break;
            }
        }
        for(int i = 0; i < desserts.length; i++){
            if(desserts[i] == 1){
                desserts[i] = c;
                x++;
                break;
            }
        }
        for(int i = 0; i < mineralVann.length; i++){
            if(mineralVann[i] == 1){
                mineralVann[i] = c;
                break;
            }
        }
    }
}
