public class Space {
    private LivingThing occupant;
    private Treasure cache;
    public Space(){
        occupant = null;
        cache = null;
    }
    public Space(LivingThing occupant){
        setOccupant(occupant);
    }


    public void setOccupant(LivingThing occupant) {
        this.occupant = occupant;
    }

    public LivingThing getOccupant() {
        return occupant;
    }

    public String getConsoleStr(){
        String scrig;
        if (occupant == null){
            scrig = "-";
        }else{
            scrig = occupant.getConsoleStr();
        }
        return scrig;
    }


    public String getConsoleStr(boolean reveal){
        if (reveal == true) {
            if (cache != null){
                return cache.getConsoleStr();
            } else if (occupant != null) {
                return occupant.getConsoleStr();
            } else {
                return "-";
            }
        } else{
            if (occupant != null && occupant instanceof Explorer){
                return occupant.getConsoleStr();
            } else {
                return "-";
            }
        }
    }

    public void setCache(Treasure cache) {
        this.cache = cache;
    }
    public Treasure getCache() {
        return cache;
    }
}
