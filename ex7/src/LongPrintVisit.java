import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

public class LongPrintVisit implements IElementVisitor{
    String longPrint="";

    @Override
    public void visit(Boat boat) {
        longPrint+="A ";
        longPrint+=boat.getName();
        longPrint+=" made of "+boat.getMaterial().toString().toLowerCase()+" material. ";
    }

    @Override
    public void visit(Island island) {
      longPrint+="An ";
      longPrint+=island.empty()?"empty ":"";
      longPrint+="island named ";
      longPrint+=island.getName();
      longPrint+=island.empty()?". ":" containing: ";
    }

    @Override
    public void visit(Lake lake) {
        longPrint+="A ";
        longPrint+=lake.empty()?"empty":"";
        longPrint+="lake named ";
        longPrint+=lake.getName();
        longPrint+=lake.empty()?". ":" containing: ";
    }

    @Override
    public void visit(Kid kid) {

        longPrint+="A ";
        longPrint+= LocalDate.now().getYear()-kid.getBirthYear()+ " year old kid with "+ kid.getHairColor().toString().toLowerCase()+" hair. ";
    }

    @Override
    public void visit(Kite kite) {
        longPrint+="A "+kite.getName()+" of color: "+kite.getColor().toString().toLowerCase()+". ";
    }

    @Override
    public void visit(Flag flag) {
        longPrint+="A "+flag.getName()+" with color: "+flag.getColor().toString()+" of height "+flag.getCarrierHeight()+". ";
    }

    @Override
    public void visit(Tree tree) {
        longPrint+="A ";
        longPrint+=tree.getName();
        longPrint+=" with an amount of "+tree.leavesAmount+" leaves. ";
    }

    @Override
    public String getAns() {
        return longPrint;
    }
}
