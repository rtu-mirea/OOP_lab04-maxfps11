
class Toy {
    private String m_firm;

    private float m_cost;

    private int m_childAgeStart;
    private int m_childAgeFinish;

    Toy(String firm, float cost, int childAgeStart, int childAgeFinish) {
        this.m_firm = firm;

        if (cost > 0)
            this.m_cost = cost;

        if (childAgeStart > 0  && childAgeStart < 18 && childAgeFinish >= childAgeStart && childAgeFinish < 18) {
            this.m_childAgeStart = childAgeStart;
            this.m_childAgeFinish = childAgeFinish;
        }
    }

    public String getToyInfo(int startAge, int finishAge) {
        if (this.m_childAgeStart >= startAge && this.m_childAgeFinish <= finishAge)
            return this.m_firm + " " + this.m_cost;
        else
            return "Inappropriate age.";
    }
    
    public boolean isAppropriateAge(Toy toy) {
        return this.m_childAgeStart >= toy.m_childAgeStart && this.m_childAgeFinish <= toy.m_childAgeFinish;
    }
}