public class AreaVisit implements IElementVisitor{
    private Double sumArea=0.0;

    @Override
    public void visit(Boat boat) {
        double area= circleArea(boat.getWidth()/2)/2
                +rectangleArea(boat.getWidth(), boat.getLength()-boat.getWidth()/2);
        sumArea+=area;

    }

    @Override
    public void visit(Island island) {
        Double area = circleArea(island.getWidth()/2);
        sumArea+=area;

    }

    @Override
    public void visit(Lake lake) {
        Double area = circleArea(lake.getWidth()/2);
        sumArea+=area;

    }

    @Override
    public void visit(Kid kid) {
        double area= circleArea(kid.getWidth()/2)
                +rectangleArea(kid.getWidth(), kid.getLength()-kid.getWidth());
        sumArea+=area;

    }

    @Override
    public void visit(Kite kite) {
        Double area = traingleArea(kite.getWidth(), kite.getLength());
        sumArea+=area;

    }

    @Override
    public void visit(Flag flag) {
        Double area = rectangleArea(flag.getWidth(),flag.getLength());
        sumArea+=area;

    }

    @Override
    public void visit(Tree tree)
    {
        sumArea+=rectangleArea(tree.getWidth()/2,tree.getLength());
    }

    @Override
    public String getAns()
    {
        Long a= Math.round(sumArea);
        return a.toString();
    }

    private Double circleArea(Double r)
    {
        return (r*r*Math.PI);
    }

    private Double traingleArea(Double base,Double high)
    {
        return (base*high)/2;
    }
    private Double rectangleArea(Double width,Double high)
    {
        return width*high;
    }
}
