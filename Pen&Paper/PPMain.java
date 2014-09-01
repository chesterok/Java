public class PPMain {
    public static void main(String[] args) 
    throws OutOfInkException, OutOfSpaceException {
        Pen pen = new Pen();
        Paper paper = new Paper();

        pen.write(paper, "Hello, world!");
        paper.show();
    }
}
