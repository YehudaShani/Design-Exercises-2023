public class EquationDecortor extends PaperDecorator {
    public EquationDecortor(Paper paper) {
        super(paper);
    }

    @Override
    public String write() {
        return super.write()+" Equation";
    }
}
