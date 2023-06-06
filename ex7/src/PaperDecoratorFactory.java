public class PaperDecoratorFactory {
    public static Paper creatPaperDecortor(String code,Paper paper)
    {
        switch (code)
        {
            case "tb":
                return new TableDecorator(paper);
            case "eq":
                return new EquationDecortor(paper);
            case "d":
                return new DiagramDecorator(paper);
            case "nt":
                return new NoteDecorator(paper);
        }
        throw new RuntimeException("wrong SymbolType");
    }
}
