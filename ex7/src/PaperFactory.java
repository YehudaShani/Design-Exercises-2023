 

public class PaperFactory {
    public static Paper createPaper(String code){
        switch (code)
        {
            case "ac":
                return new AcademicPaper();
            case "cn":
                return new Contract();
            case "bk":
                return new Book();
            case "jr":
                return new JournalArticle();
        }
        throw new RuntimeException("wrong PaperType");
    }
}
