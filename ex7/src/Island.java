// TODO: Implement Composite (change this file).

import java.util.LinkedList;
import java.util.List;

public class Island extends Element {

    private List<Element> myElements;

    public Island(String name, double diameter, String path) {

        super(diameter,diameter,path);
        this.name=name;
        myElements=new LinkedList<>();

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
        for(Element elment:myElements)
        {
            elment.accept(visitor);
        }

    }

    public void setElement(Element element){
        if (element.getHabitat() == Habitat.AMPHIBIAN ||
                element.getHabitat() == Habitat.TERRESTRIAL)
            myElements.add(element);
        else
            System.out.println(name+" cannot contain "+element.getName());
    }

    public Boolean empty()
    {
        return myElements.size() == 0;
    }
}
