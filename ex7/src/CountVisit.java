public class CountVisit implements IElementVisitor{
    Integer countElement=0;
    @Override
    public void visit(Boat boat) {
        countElement+=1;
    }

    @Override
    public void visit(Island island) {
        countElement+=1;

    }

    @Override
    public void visit(Lake lake) {
        countElement+=1;

    }

    @Override
    public void visit(Kid kid) {
        countElement+=1;
    }

    @Override
    public void visit(Kite kite) {
        countElement+=1;
    }

    @Override
    public void visit(Flag flag) {
        countElement+=1;
    }

    @Override
    public void visit(Tree tree) {
        countElement+=1;
    }

    @Override
    public String getAns() {
        return countElement.toString();
    }
}
