public class NameVisit implements IElementVisitor{
    String names="";

    @Override
    public void visit(Boat boat) {
        names+=boat.getFullName()+ "\n";
    }

    @Override
    public void visit(Island island) {
        names+=island.getFullName()+ "\n";
    }

    @Override
    public void visit(Lake lake) {
        names+=lake.getFullName()+ "\n";
    }

    @Override
    public void visit(Kid kid) {
        names+=kid.getFullName()+ "\n";
    }

    @Override
    public void visit(Kite kite) {
        names+=kite.getFullName()+ "\n";
    }

    @Override
    public void visit(Flag flag) {
        names+=flag.getFullName()+ "\n";
    }

    @Override
    public void visit(Tree tree) {
        names+=tree.getFullName()+ "\n";
    }

    @Override
    public String getAns() {
        return names;
    }
}
