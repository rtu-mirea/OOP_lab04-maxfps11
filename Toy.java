import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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

    Toy() {}
    
    boolean isEqFirm(String firm) {
        return this.m_firm.equals(firm);
    }

    boolean setData(String firm, float cost, int childAgeStart, int childAgeFinish) {
        this.m_firm = firm;

        if (cost > 0)
            this.m_cost = cost;
        else return false;

        if (childAgeStart > 0  && childAgeStart < 18 && childAgeFinish >= childAgeStart && childAgeFinish < 18) {
            this.m_childAgeStart = childAgeStart;
            this.m_childAgeFinish = childAgeFinish;
        } else return false;

        return true;
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

    public void writeToFile(DataOutputStream dOStream) {
        try {
            dOStream.writeUTF(this.m_firm);
            dOStream.writeFloat(this.m_cost);
            dOStream.writeInt(this.m_childAgeStart);
            dOStream.writeInt(this.m_childAgeFinish);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(DataInputStream dIStream) {
        try {
            this.m_firm = dIStream.readUTF();
            this.m_cost = dIStream.readFloat();
            this.m_childAgeStart = dIStream.readInt();
            this.m_childAgeFinish = dIStream.readInt();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printInfo() {
        System.out.println("Наименование фирмы производителя: " + this.m_firm +
                            "\nЦена: " + this.m_cost +
                            "\nВозрастные ограничения: от " + this.m_childAgeStart + " до " + this.m_childAgeFinish);
    }
}