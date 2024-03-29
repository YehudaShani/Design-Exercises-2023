 
/**
 * The Main class contains methods for creating and interacting with paintings and papers, including menus for adding
 * elements and printing information.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Main {

    /**
     * The function prompts the user to choose between two options and calls a corresponding menu function based on the
     * user's choice.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "p: Papers");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }
    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();
        Map<String, Element> files = new HashMap();

        Files.lines(Paths.get(path))
            .map(str -> ElementDetailsFactory.getPaintingElement(str))
            .forEach(e-> painting.addElement(e));
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        //String path=scanner.nextLine();
        //Painting root= readElementDetails(path);
        Painting root= readElementDetails("C:\\Users\\David Ohhana\\Desktop\\College" +
                "\\OO design and programming\\Design-Exercises-2023\\ex7\\src\\elements.txt");
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    System.out.println(root.accept(new CountVisit()));
                    break;
                case "sh":
                    System.out.print(root.accept(new NameVisit()));
                    break;
                case "ta":
                    System.out.println(root.accept(new AreaVisit()));
                    break;
                case "lp":
                    System.out.println(root.accept(new LongPrintVisit()));
                    break;


            }

        }
    }

    public static void paperMenu(Scanner scanner){
        System.out.println("Choose from the following paper:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "jr: journal article\n" +
                "bk: book");

        Paper paper = PaperFactory.createPaper(scanner.nextLine());
        String choice="";
        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());

            }
        }


    }
   public static Paper paperElementMenu(Scanner scanner, Paper paper){
        System.out.println("Choose from the following elements:\n" +
                "tb: table\n" +
                "eq: equation\n" +
                "d: diagram\n" +
                "nt: note");

        return PaperDecoratorFactory.creatPaperDecortor(scanner.nextLine(),paper);
    }
}
