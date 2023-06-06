import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lake extends Element {

    private List<Element> myElements;
    public Lake(String name, double diameter, String path) {

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
        return Habitat.TERRESTRIAL;
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
                element.getHabitat() == Habitat.AQUATIC)
        {
           myElements.add(element);

        }
        else
            System.out.println(name+" cannot contain "+element.getName());
    }

    public Boolean empty()
    {
        return myElements.size() == 0;
    }
}
