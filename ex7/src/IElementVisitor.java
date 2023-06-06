public interface IElementVisitor {

    public void visit(Boat boat);
    public void visit(Island island);
    public void visit(Lake lake);
    public void visit(Kid kid);
    public void visit(Kite kite);
    public void visit(Flag flag);

    public void visit(Tree tree);

    public String getAns();





}
