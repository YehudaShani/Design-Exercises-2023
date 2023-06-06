 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;
    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }
    public void addElement(Element element){
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()){
            elementList.add(element);
        }
        else {
            Element containingElement = pathToElementMap.get(element.getPath());
            if (containingElement instanceof Lake)
                ((Lake)containingElement).setElement(element);
            else if (containingElement instanceof Island) {
                ((Island)containingElement).setElement(element);
            }
        }
    }

    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }

    public String accept (IElementVisitor visitor)
    {
        for(Element element :elementList)
            element.accept(visitor);
        return visitor.getAns();
    }


}
