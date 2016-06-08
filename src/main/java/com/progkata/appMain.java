package main.java.com.progkata;

public class appMain {


    public static void main(String[] args) throws Exception {

        String basePath = "src/main/resources/";
        part1(basePath);
        part2(basePath);
    }

    private static void part1(String basePath) throws Exception {

        String[] results = getResults(basePath + "weather.dat", 2, 6, 12);
        System.out.println("Min spread is " + results[1] + " for day " + results[0]);
    }

    private static void part2(String basePath) throws Exception {

        String[] results = getResults(basePath + "football.dat", 1, 43, 50);
        System.out.println("Goal spread is " + results[1] + " for team n. " + results[0]);
    }

    private static String[] getResults(String filename, int skiplines, int index1, int index2) throws Exception {

        String data = MiscUtils.readFile(filename, skiplines);
        String[] lines = data.split("\n");
        double min = Double.MAX_VALUE;
        int lineIndex = 0;
        for (int j=0; j<lines.length; j++) {
            double val = getMinValue(lines[j], index1, index2);
            if (val < min) {
                min = val;
                lineIndex = j+skiplines;
            }
        }
        return new String[] {"" + lineIndex, "" + min};
    }

    private static double getMinValue(String line, int index1, int index2) {

        double val1 = getNumber(line, index1);
        double val2 = getNumber(line, index2);

        if (val1 == Double.MAX_VALUE || val2 == Double.MAX_VALUE) {
            return Double.MAX_VALUE;
        }

        return val1 - val2;
    }

    private static double getNumber(String line, int index) {
        int start = index;
        while (line.charAt(index) != ' ') index ++;
        int end = index;

        try {
            Double val = Double.parseDouble(line.substring(start, end+1));
            return val;
        }
        catch (NumberFormatException nfe) {
            return Double.MAX_VALUE;
        }
    }
}