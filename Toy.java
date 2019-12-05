
class Toy {
    private String m_firm;

    private int m_cost;

    private int m_childAgeStart;
    private int m_childAgeFinish;

    Toy(String firm, int cost, int childAgeStart, int childAgeFinish) {
        m_firm = firm;
        m_cost = cost;
        m_childAgeStart = childAgeStart;
        m_childAgeFinish = childAgeFinish;
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