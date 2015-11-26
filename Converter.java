import java.io.*;

public class Converter {

    private static final String PATH = "/Users/jeanluc/hw1.c";
    private static final String OUT = "/Users/jeanluc/a.c";

    public static int replaceComment(String path, String out) throws IOException {
        // Set up the IO
        BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter pw = new PrintWriter(out);

        // Loop over each line until we find a comment line
        String line;
        int indexOfComment;
        int count = 0;
        while ((line = br.readLine()) != null) {

            System.out.println(line);

            // Check if this line contains a comment
            if (line.contains("//")) {

                // Replace the comment symbol ("//") with the C-style comment "/*"
                StringBuilder sb = new StringBuilder(line);
                indexOfComment = sb.indexOf("//");
                sb.replace(indexOfComment, indexOfComment + 2, "/*");

                // Add the end comment symbol to the end
                sb.insert(sb.length(), " */");
                line = sb.toString(); // reassign the line

                count++;
            }

            // Write the line to the file
            pw.println(line);
        }

        pw.close();
        return count;
    }

    public static void main(String[] args) throws IOException {

        try {
            System.out.println(replaceComment(args[0], args[1]));
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

}
